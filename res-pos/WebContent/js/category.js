$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	
	$('#test').click(function(){
		$('#divCategory').toggle('slow');
		$('#divSubCategory').toggle('slow');
		$('#divSize').toggle('slow');
		$('#divCustomerInfo').toggle('slow');
		$('#divOrder').toggle('slow');
	});
	
	// creates on click to get subcategories of the amount of category
	for (var i=1; i<=categoriesSize; i++){
		var indexId = '#category'+i.toString();
		jQuerySubCategory(indexId);
	}
	
});

function jQuerySubCategory(indexId){
	$(indexId).click(function(){
		showSubCategory($(this).val());
	});
}

//Ajax - method #1 
function showSubCategory(categoryId){
	var params = {categoryId: categoryId};
	$.ajax({
		type: "GET",
		url: "subCategory.json",
		data: params,
		success: function(data){  
            		$("#divSubCategory").html(data).show();
            	 },
		error: showError
	});
}

//Ajax - method #2
/*function showSubCategory(categoryId){
	$.ajax({
		url: "subCategory.json?categoryId="+categoryId,
		success: showAlert,
		error: showError,
		cache: false
	});
}*/

function showError(){
	alert("Error: SubCategory not loaded...");
}

