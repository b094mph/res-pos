$(document).ready(function(){

	for(var i =0; i < extraIDs.length; i++){
		var id = "#extra_" + extraIDs[i].toString();
		createSubCategoriesOnClick(id);
	}
});

function createSubCategoriesOnClick(id){
	$(id).click(function(){
		addToOrder($(this).val(), $('#foodLegend').val());
	});
}

function addToOrder(menuId, foodLegend){
	var params = {menuId: menuId, foodLegend: foodLegend};
	$.ajax({
		type: "GET",
		url: "addToOrder.json",
		data: params,
		success:
			function(data){
				$('#orderListAjax').html(data).show();
		},
		error:
			function(data){
				alert("unsuccessful in order ajax...");
		}
	});
}