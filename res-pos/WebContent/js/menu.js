$.ajaxSetup({
	cache: true //true is the default value
});

$(document).ready(function(){	

	//creating on click event for food category buttons
	for(var i=0; i < foodCategoryIDs.length; i++){
		var id = '#fc_'+foodCategoryIDs[i].toString();
		createFoodCategoryOnClick(id);
	}
	
	var sessionFoodCategoryId = $('#foodCategoryId').val();
	fireCategoryButton(sessionFoodCategoryId);
});

function createFoodCategoryOnClick(id){
	$(id).click(function(){
		showSubCategory($(this).val());
	});
}

function showSubCategory(foodCategoryId){
	var params = {foodCategoryId : foodCategoryId};
	$.ajax({
		type: "GET",
		url: "subMenu.json",
		data: params,
		success: 
			function(data){
				$('#subcategoryajax').html(data).show();
		},
		error: 
			function(data){
				alert("unsuccessful..." + data);
		}
	});
	
}

function fireCategoryButton(sessionFoodCategoryId){
	if(sessionFoodCategoryId == ""){
		$('#fc_1').click();
	}else{
		$('#fc_'+sessionFoodCategoryId).click();
	}
	
}