var id = null;

$(document).ready(function(){
	for(var i = menuIDs[0]; i <= menuIDs[menuIDs.length-1]; i++){
		id = "#menu_" + i.toString();
		createSubCategoriesOnClick(id);
	}
});

function createSubCategoriesOnClick(id){
	$(id).click(function(){
		addToOrder($(this).val());
	});
}

function addToOrder(menuId){
	var params = {menuId: menuId};
	$.ajax({
		type: "GET",
		url: "addOrder.json",
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