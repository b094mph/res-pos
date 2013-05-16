var orderListSize = $('#orderListSize').val();

for(var i=0; i<orderListSize; i++){
	var deleteItemId = '#deleteItem_' + i.toString();
	$(deleteItemId).click(function(){
		var idx = $(this).val();
		var params = {idx: idx};
		$.ajax({
			type: "GET",
			url: "deleteItem.json",
			data: params,
			success:
				function(data){
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful deleting item in ajax call...");
			}
		});
	});	
}
