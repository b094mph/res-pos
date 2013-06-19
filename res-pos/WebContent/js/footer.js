
$(document).ready(function(){
	
	$('#ToS').click(function(){
		$('#modal-ToS').modal();
	});
	
	$('#privacy').click(function(){
		$('#modal-privacy').modal();
	});
	
	$('#security').click(function(){
		$('#modal-security').modal();
	});
	
	$('#facebook').attr('title', "Like us on Facebook");
	$('#facebook').tooltip();
	$('#twitter').attr('title', "Follow us on Twitter");
	$('#twitter').tooltip();
	$('#google').attr('title', "+1 us on Google+");
	$('#google').tooltip();
	$('#linkedin').attr('title', "Link with us on LinkedIn");
	$('#linkedin').tooltip();
	$('#lovenyc').attr('title', "Made in NYC");
	$('#lovenyc').tooltip();
});