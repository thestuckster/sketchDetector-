$(document).ready(function() {
	$("button").click(function() {
		var url = $("#url").val();
		var scrape = "http://localhost:8080/scrape?url=" + url;

		$.ajax({
			url: scrape,
			type: 'GET',
			success: function(data) {
				console.log(data);
			}
	});
	});
});
