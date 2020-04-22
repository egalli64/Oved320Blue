<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Userform</title>
<base href="/blue/">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/Userform.css">
</head>
<body>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div id="titleId">
					<a href="index.jsp" id="titleId">SoulWine</a>
				</div>
			</div>
			<div class="col">
				<nav class="navbar navbar-light bg-light">
					<a class="navbar-brand" id="researchId">Ricerca</a>
					<form class="form-inline">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
					</form>
				</nav>
			</div>
			<div class="col">
				<div id="picId">
					<a href="Userform.html"> <img src="images/omino.png"
						title="user" width="10%" />
					</a> <a href="Carrello.jsp"> <img src="images/carrello.jpg"
						title="carrello" width="14%" />
					</a>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<br>
	<h1>Autenticazione</h1>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<h4>SEI UN NUOVO UTENTE?</h4>
				<hr>

				<form action="utente/nuovo" method="post">

					<div>
						Nome Utente: <br> <input type="text" name="user">
					</div>
					<div>
						Password: <br> <input type="password" name="password"
							maxlength="30" required>
					</div>
					<div>
						<input type="hidden" name="invisible" value="notShowed">
					</div>
					<div>
						<br> <input type="submit" value="Crea un account" />
					</div>
				</form>
			</div>
			<div class="col">
				<h4>SEI GIA REGISTRATO?</h4>
				<hr>
				<form action="utente/login" method="post">

					<div>
						Nome Utente: <br> <input type="text" name="user">
					</div>
					<div>
						Password: <br> <input type="password" name="password"
							maxlength="30" required>
					</div>
					<div>
						<input type="hidden" name="invisible" value="notShowed">
					</div>
					<div>
						<br> <input type="submit" value="Entra" />
					</div>
				</form>
				<c:if test="${error != null}">
					<p class="error">${error}</p>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>