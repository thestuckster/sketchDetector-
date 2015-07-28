$(document).ready(function() {
  $("button").click(function() {
    var url = $("#url").val();
    var scrape = "http://localhost:8080/scrape?url=" + url;

    $.ajax({
      url: scrape,
      type: 'GET',
      success: function(data) {
        console.log(JSON.stringify(data));

        if (data.source === "bad connection to site") {
          alert("bad connection to site");
        } else if (data.source === "Malformed URL") {
          alert("Bad URL. Please try again.");
        } else if(data.source === "IO Exception") {
          alert("Bad URL. Please try again.");
        } else {

          var count = 0;

          $.each(data, function(key, value) {
            if (typeof value === "boolean" && value === true) {
              count = count + 1;
            }
          });

          if (count === 0) {
            alert("This site is safe!");
          } else if (count === 1) {
            alert("This site is slightly sketchy");
          } else if (count === 2) {
            alert("This site is moderately sketchy");
          } else {
            alert("This site SUPER sketchy!!!!1");
          }
        }
      }
    });
  });

  $("body").keypress(function(e) {
    if (e.which == 13) {
      var url = $("#url").val();
      var scrape = "http://localhost:8080/scrape?url=" + url;

      $.ajax({
        url: scrape,
        type: 'GET',
        success: function(data) {
          console.log(JSON.stringify(data));

          if (data.source === "bad connection to site") {
            alert("bad connection to site");
          } else if (data.source === "Malformed URL") {
            alert("Bad URL. Please try again.");
          } else if (data.source === "IO Exception") {
            alert("Bad URL. Please try again.");
          } else {

            var count = 0;

            $.each(data, function(key, value) {
              if (typeof value === "boolean" && value === true) {
                count = count + 1;
              }
            });

            if (count === 0) {
              alert("This site is safe!");
            } else if (count === 1) {
              alert("This site is slightly sketchy");
            } else if (count === 2) {
              alert("This site is moderately sketchy");
            } else {
              alert("This site SUPER sketchy!!!!1");
            }
          }
        }
      });
    }
  });
});
