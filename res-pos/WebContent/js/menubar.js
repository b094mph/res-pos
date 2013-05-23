$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	$('#english').attr('title', "English");
	$('#english').tooltip();
	$('#chinese').attr('title', "Chinese");
	$('#chinese').tooltip();
});
