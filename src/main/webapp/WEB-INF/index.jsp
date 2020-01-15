<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/main.css" />
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
</head>
<body>
	<h1>This is a Title</h1>
	<form action="" id="form" method="get">
		<label for="subreddit">Enter Subreddit</label> <input type="text"
			name="subreddit" id="subreddit" /> <label for="search-text">What
			do you want to search?</label> <input type="text" name="search-text"
			id="search-text" /> <input type="submit" value="Search" />
	</form>
	<div id="count"></div>
	<ul id="results"></ul>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script src="scripts/ajax.js"></script>

</html>