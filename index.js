$("button").click(function() {
	var url = $("#url").val();
	$.get( "ajax/test.html", function( data ) {
  		$( ".result" ).html( data );
  		alert( "Load was performed." );
	});
})
