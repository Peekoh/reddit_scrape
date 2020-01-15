document.getElementById("form").addEventListener("submit", function (e) {
    e.preventDefault();
    showLoadingDiv();
    $.ajax({
        url: `/scrape/${document.getElementById("subreddit").value}/${document.getElementById("search-text").value}`,
        success: function (d) {
        	clearResultDivs();
            let data = d;
            let count = 0;
            for (let i = 0; i < data.length; i++) {
            	let item = document.createElement("li");
            	item.innerHTML = data[i];
                $("#results").append(item);
                ++count;
            }
            let response = `<h2> COUNT: ${count} <h2>`;
            response += `<p>There were ${count} instances of the word ${document.getElementById("search-text").value} in r/${document.getElementById("subreddit").value}</p>`;
            $("#count").append(response);
        },
        error: function (err) {
            console.log(err);
        	clearResultDivs();

        }
    });
})
clearResultDivs = () => {
	$('#results').empty();
	$("#count").empty();
}
showLoadingDiv = () => {
	clearResultDivs();
	let img = $("<img src='img/loading.gif' class='loading-img'/>")
	$("#count").append(img);
}
