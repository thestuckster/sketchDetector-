$(document).ready(function() {
			var scrape = "localhost:8080/scrape";
			$.ajax({
		    url: "http://localhost:8080/scrape",
		    type: 'GET',
		    success: function() { alert('PUT completed'); }
		});


	$("button").click(function() {
		var url = $("#url").val();
		var scrape = "localhost:8080/scrape";

		$.get(scrape,
			 {url: "http://stucky.me"},
			 function(data) {
	  		alert(data);
		});
	});
});
