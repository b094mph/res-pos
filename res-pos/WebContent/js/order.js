$(document).ready(function(){

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
	
	$('#new').click(function(){
		$.ajax({
			type: "GET",
			url: "newOrder.json",
			success:
				function(data){
					$('#hiddenReset').trigger('click');
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful clearing customer info and order in ajax call...");
			}
		});
	});
	
	$('#void').click(function(){
		$.ajax({
			type: "GET",
			url: "voidOrder.json",
			success:
				function(data){
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful voiding the order in ajax call...");
			}
		});
	});
	
	$('#save').click(function(){
		$.ajax({
			type: "GET",
			url: "saveOrder.json",
			success:
				function(data){
					//$('#hiddenSubmit').trigger('click');
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful sending the order in ajax call...");
			}
		});
	});
	
	//Temp buttons for alert as actions.
	$('#print').click(function(){
		alert("printing...");
	});
	
	$('#walkin').click(function(){
		alert("Walk In");
	});
	
	$('#pickup').click(function(){
		alert("Pick Up");
	});
	
	$('#delivery').click(function(){
		alert("Delivery");
	});
	
	$('#eatin').click(function(){
		alert("Eat In");
	});
	
	$('#small').click(function(){
		alert("Small");
	});
	
	$('#large').click(function(){
		alert("Large");
	});
	
	$('#lunch').click(function(){
		alert("Lunch");
	});
	
	$('#combo').click(function(){
		alert("Combo");
	});
	
	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();

	$('#new').attr('title', "Clears customer and order information.");
	$('#new').tooltip();
	$('#void').attr('title', "Cancels order.");
	$('#void').tooltip();
	$('#save').attr('title', "Saves customer and order information.");
	$('#save').tooltip();
	$('#print').attr('title', "Printing to receipt.");
	$('#print').tooltip();
});
