<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<title>Gastenboek</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<br>
		<ul class="list-group">
			<c:forEach var="bean" items="${list}">
				<li class="list-group-item">${bean.formattedDate()} <br>${bean.name}&nbsp;- &nbsp;
					${bean.message}</li>
			</c:forEach>
		</ul>
		<br>
		<form action="guestbook" method="post">
			<div class="form-group">
				<label for="name">Naam: </label> <input type="text"
					class="form-control" name="name" id="name">
			</div>

			<div class="form-group">
				<label for="message">Bericht:</label>
				<textarea class="form-control" name="message" id="message" rows="5"
					cols="10"></textarea>
			</div>

			<button type="submit" class="btn btn-success">Toevoegen aan
				gastenboek</button>
		</form>

	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</body>
</html>