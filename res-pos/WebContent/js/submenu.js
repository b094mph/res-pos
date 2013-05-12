var id = null;

$(document).ready(function(){
	for(var i = foodIDs[0]; i <= foodIDs[foodIDs.length-1]; i++){
		id = "#food_" + i.toString();
		createSubCategoriesOnClick(id);
	}
});

function createSubCategoriesOnClick(id){
	$(id).click(function(){
		addToOrder($(this).val());
	});
}

function addToOrder(foodId){
	alert(foodId);
}