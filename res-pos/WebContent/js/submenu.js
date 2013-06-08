var id = null;

$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	for(var i = menuIDs[0]; i <= menuIDs[menuIDs.length-1]; i++){
		id = "#menu_" + i.toString();
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