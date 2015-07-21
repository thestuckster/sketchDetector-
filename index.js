$(document).ready(function() {
	$("button").click(function() {
		var url = $("#url").val();
		var scrape = "localhost:8080/scrape?url=" + url;

		$.get(scrape, function(data) {
	  		alert(data);
		});
	});
});
