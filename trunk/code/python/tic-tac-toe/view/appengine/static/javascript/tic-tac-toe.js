$(document).ready(function(){
	$("table *").replaceText(/_/,"<img src='/static/image/blank.gif'>");
	$("table *").replaceText(/O/,"<img src='/static/image/nought.gif'>");
	$("table *").replaceText(/X/,"<img src='/static/image/cross.gif'>");
});