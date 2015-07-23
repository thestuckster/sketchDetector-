$(document).ready(function() {
  $("button").click(function() {
    var url = $("#url").val();
    var scrape = "http://localhost:8080/scrape?url=" + url;

    $.ajax({
      url: scrape,
      type: 'GET',
      success: function(data) {
        console.log(JSON.stringify(data));

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
    });
  });

  $("body").keypress(function(e) {
    if(e.which == 13) {
      console.log("ENTER");
      var url = $("#url").val();
      var scrape = "http://localhost:8080/scrape?url=" + url;

      $.ajax({
        url: scrape,
        type: 'GET',
        success: function(data) {
          console.log(JSON.stringify(data));
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
      });
    }
  });
});
