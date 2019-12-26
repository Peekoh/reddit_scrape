document.getElementById("form").addEventListener(
		"submit",
		function(e) {

			e.preventDefault()

			$.ajax({
				url : "/scrape/" + document.getElementById("subreddit").value
						+ "/" + document.getElementById("search-text").value,

				success : function(d) {
					let data = d;
					console.log("Success");

					console.log(data);
					for (let i = 0; i < data.length; i++) {
						document.getElementById("results").append(data[i] + "<br/>");
					}
				},
				error : function(err) {
					console.log(err);
				}
			});
		})
