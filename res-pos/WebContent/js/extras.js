var modifyTasteId = null;

$(document).ready(function(){

	$("[name=tasteModifierRdo]").attr("checked", "true").click(function(){
		modifyTasteId = $(this).val();
	});
	
	for(var i =0; i < extraIDs.length; i++){
		var id = "#extra_" + extraIDs[i].toString();
		createSubCategoriesOnClick(id);
	}
	
	function getRowIndex(){
		return $('#rowIndex').val();
	}

});

function getTasteModifier(){
	return modifyTasteId;
}

function createSubCategoriesOnClick(id){
	$(id).click(function(){
		addToOrder($(this).val(), "Extras", getTasteModifier());
	});
}

function addToOrder(menuId, foodLegend, modifyTasteId){
	var params = {menuId: menuId, 
			foodLegend: foodLegend,
			modifyTasteId: modifyTasteId,
			rowIndex: getRowIndex(),
			lastRow: false};
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