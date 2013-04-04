$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	for(var i=subCategoryStartIndex; i<subCategoriesSize + subCategoryStartIndex; i++){
		var idx = '#subcategory' + i.toString();
		addToOrderJquery(idx);
	}
});

function addToOrderJquery(idx){
	$(idx).click(function(){
		addToOrder($(this).val());
	});
}

function addToOrder(idx){
	var params = {id: idx};
	$.ajax({
		type: "GET",
		url: "order.json",
		data: params,
		success: function(data){
					$("#tableOrder").html(data).show();
//					var table = document.getElementById("tableOrder");
//					var row = document.createElement("tr");
//					var cell = document.createElement("td");
//					var cellText = document.createTextNode("shortName");
//					cell.appendChild(cellText);
//					row.appendChild(cell);
//					cell = document.createElement("td");
//					cellText = document.createTextNode("large");
//					cell.appendChild(cellText);
//					row.appendChild(cell);
//					table.appendChild(row);	
				},
		error: function(data, args){
			alert("failure");
			for (var i in data){
				alert(i + " / " + data[i]);
			}
		}
	});
};