var orderListSize = $('#orderListSize').val();
var deleteItemId = null;
var increaseQtyId = null;
var decreaseQtyId = null;
var idx = null;
var params = null;

for(var i=0; i<orderListSize; i++){
	deleteItemId = '#deleteItem_' + i.toString();
	increaseQtyId = '#increaseQty_' + i.toString();
	decreaseQtyId = '#decreaseQty_' + i.toString();
	
	$(deleteItemId).click(function(){
		idx = $(this).val();
		params = {idx: idx};
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
	
	$(increaseQtyId).click(function(){
		idx = $(this).val();
		params = {idx: idx};
		$.ajax({
			type: "GET",
			url: "increaseQty.json",
			data: params,
			success:
				function(data){
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful increasing qty for item in ajax call...");
			}
		});
	});
	
	$(decreaseQtyId).click(function(){
		idx = $(this).val();
		params = {idx: idx};
		$.ajax({
			type: "GET",
			url: "decreaseQty.json",
			data: params,
			success:
				function(data){
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful decreasing qty for item in ajax call...");
			}
		});
	});
}
