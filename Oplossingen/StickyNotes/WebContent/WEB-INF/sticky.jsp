<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/sticky.css">

</head>

<body>
	<div class="container">
		<h1>${Hello}</h1>
		<!--Titel Open-->
		<div class="titel">
			<div class="row align-items-center m-5">
				<div class="col-xs-3 col-md-3 text-right">
					<i class="fa fa-sticky-note-o fa-5x" aria-hidden="true"></i>
				</div>
				<div class="col-xs-6  col-md-6">
					<h1 class="text-center" id="sticky-titel">Sticky Notes Deluxe</h1>
				</div>
				<div class="col-xs-3 col-md-3">
					<i class="fa fa-sticky-note-o fa-5x" aria-hidden="true"></i>
				</div>
			</div>
		</div>
		<!--Titel Close-->

		<!--Form Group Open-->
		<div class="form-group ">
			<form action="sticky" method="post">
				<div class="row align-items-center">
					<div class="col-xs-12 col-md-6">
						<input type="text" name="newsticky" id="invoerveld"
							class="form-control"
							placeholder="Vul hier je boodschap in tussend de 0 en 60 tekens.">
					</div>
					<div class="col-xs-6 col-md-3">
						<button type="submit" class="btn btn-info" id="button1"
							name="btn_toevoegen">
							<i class="fa fa-clipboard fa-1x"></i> Sticky toevoegen
						</button>
					</div>
					<div class="col-xs-6 col-md-3">
						<button type="submit" class="btn btn-info" id="button2"
							name="btn_wissen">
							<i class="fa fa-trash fa-1x"></i> Alles wissen...
						</button>
					</div>
				</div>
			</form>
		</div>

		<!--Form Group Close-->
		<!--Sticky Background Open-->
		<div id="achtergrond" class="bg-info row col-xs-12 col-md-12">
			<c:forEach items="${stickies}" var="mySticky" varStatus="s">
				<form action="sticky" method="post"
					class="stickyform col-xs-4 col-md-2">
					<div class="stickynote text-center">${mySticky}</div>
					<input type="hidden" name="mySticky" value="${mySticky.text}">
				</form>
			</c:forEach>

		</div>
		<!--Sticky Background Close-->

	</div>
	<!-- Wrapping Container Close-->


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<script src="js/sticky.js"></script>
</body>

</html>