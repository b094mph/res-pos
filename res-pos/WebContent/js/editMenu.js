$(document).ready(function(){
	
	//to initialize selectpicker
	$('select').selectpicker();
	
	var spicy = $('#spicy').val();
	var rice = $('#rice').val();
	var sauce = $('#sauce').val();
	var noodle = $('#noodle').val();
	var appetizerCombo = $('#appetizerCombo').val();
	
	$('#selectspicy').selectpicker('val', spicy);
	$('#selectrice').selectpicker('val', rice);
	$('#selectsauce').selectpicker('val', sauce);
	$('#selectnoodle').selectpicker('val', noodle);
	$('#selectappetizercombo').selectpicker('val', appetizerCombo);
	 
});