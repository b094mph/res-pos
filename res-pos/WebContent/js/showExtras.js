$(document).ready(function(){

	for(var i = 0; i < extraCategoryNames.length; i++){
		var extraLongName = '#' + extraCategoryNames[i].toString();
		
		$(extraLongName).click(function(){
			getExtrasSubCategory($(this).val());
		});
	}

});

function getExtrasSubCategory(extrasCategoryId){
	var params = {extrasCategoryId: extrasCategoryId};
	$.ajax({
		type: "GET",
		url: "extrasSubCategory.json",
		data: params,
		success:
			function(data){
				$('#extraMenu').html(data).show();
			},
		error:
			function(data){
				alert("unsuccessful displaying extras subcategories in ajax call...");
			}
	});
}