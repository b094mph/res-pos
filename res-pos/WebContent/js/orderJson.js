$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	addTogether(shortName, large);
});

function addTogether(shortName, large){
	var table = document.getElementById("tableOrder");
	var row = document.createElement("tr");
	var cell = document.createElement("td");
	var cellText = document.createTextNode(shortName);
	cell.appendChild(cellText);
	row.appendChild(cell);
	cell = document.createElement("td");
	cellText = document.createTextNode(large);
	cell.appendChild(cellText);
	row.appendChild(cell);
	table.appendChild(row);	
}
