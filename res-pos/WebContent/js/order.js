var orderListSize = $('#orderListSize').val();
var deleteItemId = null;
var increaseQtyId = null;
var decreaseQtyId = null;
var idx = null;
var params = null;
var orderType = null;

$.ajaxSetup({
	cache: true
});

$(document).ready(function(){
	
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

	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();
	
	//highlight order rows that are selected
	$('#orderTable tbody tr').live('click', function(event) {
	    $(this).addClass('highlight').siblings().removeClass('highlight');
	    determineAvailableFoodSize();
	});
	
	//on adding an item, last row is selected
	var lastRow = $('#lastRow').val();
	if(lastRow == 'true'){
		$('#orderTable tbody tr:last').addClass('highlight').siblings().removeClass('highlight');
	}else{
		var rowIndex = $('#rowIndex').val();
		$('#orderTable tbody tr:eq('+rowIndex+')').addClass('highlight').siblings().removeClass('highlight');
	}
	
	$('#small').click(function(){
		var rowIndex = getRowIndex();
		changeSize(rowIndex, SMALL);
	});
	
	$('#large').click(function(){
		var rowIndex = getRowIndex();
		changeSize(rowIndex, LARGE);
	});
	
	$('#lunch').click(function(){
		var rowIndex = getRowIndex();
		changeSize(rowIndex, LUNCH);
	});
	
	$('#combo').click(function(){
		var rowIndex = getRowIndex();
		changeSize(rowIndex, COMBO);
	});
	
	$('#extras').click(function(){
		var params = {rowIndex: getRowIndex()};
		$.ajax({
			type: "GET",
			url: "showExtras.json",
			data: params,
			success:
				function(data){
					$('#subcategoryajax').html(data).show();
				},
			error:
				function(data){
					alert("unsuccessful making extras ajax call...");
				}
		});
	});
	
	$('#new').click(function(){
		$.ajax({
			type: "GET",
			url: "newOrder.json",
			success:
				function(data){
					clearCustomerInfo();
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful clearing customer info and order in ajax call...");
			}
		});
	});
	
	$('#void').click(function(){
		$('#voidAlertWarning').modal();
	});
	
	$('#confirmVoid').click(function(){
		$.ajax({
			type: "GET",
			url: "voidOrder.json",
			success:
				function(data){
					window.location.replace($('#welcomeJsp').val());
			},
			error:
				function(data){
					alert("unsuccessful voiding the order in ajax call...");
			}
		});
	});
	
	$('#save').click(function(){
		params = createJsonCusOrder();
		if(!validateOrderType()){
			return;
		}
		if(!validateHasPhoneNumber()){
			return;
		}
		params.orderType = orderType;
		if(!validateDeliveryHasAddress(params)){
			return;
		}
		$('#saveConfirmation').modal();
		$.ajax({
			type: "GET",
			url: "saveOrder.json",
			contentType: 'application/json',
			data: params,
			success:
				function(data){
					window.location.replace($('#welcomeJsp').val());
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
		disableDeliveryFields();
		setOrderType("Walk In");
	});
	
	$('#pickup').click(function(){
		disableDeliveryFields();
		setOrderType("Pick Up");
	});
	
	$('#delivery').click(function(){
		enableDeliveryFields();
		setOrderType("Delivery");
	});
	
	$('#eatin').click(function(){
		disableDeliveryFields();
		setOrderType("Eat In");
	});
	
	//tooltip
	$('#new').attr('title', "Clears customer and order.");
	$('#new').tooltip();
	$('#void').attr('title', "Cancels order.");
	$('#void').tooltip();
	$('#save').attr('title', "Saves customer and order.");
	$('#save').tooltip();
	$('#print').attr('title', "Print receipt.");
	$('#print').tooltip();
});


function createJsonCusOrder(){
	var jsonParams = {"customer": {"firstName": $('#firstName').val(),
									"lastName": $('#lastName').val(),
									"phone1": $('#phone1').val(),
									"phone2": $('#phone2').val(),
									"ext": $('#ext').val(),
									"email": $('#email').val(),
									"note": $('#note').val()
									},
					"address": {"street1": $('#street1').val(),
							"street2": $('#street2').val(),
							"city": $('#city').val(),
							"state": $('#state').val(),
							"zipCode": $('#zipCode').val()
							},
					"orderType": "Pick Up"
				};
	return jsonParams;
}

function clearCustomerInfo(){
	$('#firstName').val("");
	$('#lastName').val("");
	$('#phone1').val("");
	$('#phone2').val("");
	$('#ext').val("");
	$('#email').val("");
	$('#street1').val("");
	$('#street2').val("");
	$('#city').val("");
	$('#state').val("");
	$('#zipCode').val("");
	$('#note').val("");
}

function setOrderType(type){
	orderType = type;
	$('b#orderType').html(orderType);
}

function validateDeliveryHasAddress(data){
	if(data.orderType == "Delivery"){
		var addr = data.address;
		if(addr.street1 != "" && addr.city != "" 
				&& addr.state != "" && addr.zipCode != ""){
			return true;
		}else{
			$('#validateDeliveryHasAddressModal').modal();
			return false;
		}
	}
	return true;
}

function validateOrderType(){
	if(orderType == null){
		$('#orderTypeModal').modal();
		return false;
	}
	return true;
}

function validateHasPhoneNumber(){
	if(orderType == "Delivery" || orderType == "Pick Up"){
		if($('#phone1').val() == ""){
			$('#validateHasPhoneNumberModal').modal();
			return false;
		}
	}
	return true;
}

function changeSize(rowIndex, size){
	$.ajax({
		type: "GET",
		url: "changeSize.json",
		data: {rowIndex: rowIndex, size: size},
		success:
			function(data){
				$('#orderListAjax').html(data).show();
			},
		error:
			function(data){
				alert("unsuccessful change size to " + size + " for item in ajax call...");
			}
	});
}

function disableDeliveryFields(){
	$('#street1').val("");
	$('#street1').attr("disabled", "disabled");
	$('#street2').val("");
	$('#street2').attr("disabled", "disabled");
	$('#city').val("");
	$('#city').attr("disabled", "disabled");
	$('#state').val("");
	$('#state').attr("disabled", "disabled");
	$('#zipCode').val("");
	$('#zipCode').attr("disabled", "disabled");
}

function enableDeliveryFields(){
	$('#street1').removeAttr("disabled");
	$('#street2').removeAttr("disabled");
	$('#city').removeAttr("disabled");
	$('#state').removeAttr("disabled");
	$('#zipCode').removeAttr("disabled");
}

function getRowIndex(){
	return $('#orderTable tbody tr.highlight').index();
}
