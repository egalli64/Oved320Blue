<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ciao ${vino.nome}</title>
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
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div id="titleId">
					<a href="." id="titleId">SoulWine</a>
				</div>
			</div>
			<div class="col">
				<nav class="navbar navbar-light bg-light">
					<form class="form-inline"></form>
				</nav>
			</div>
			<div class="col">
				<c:choose>
					<c:when test="${user != null}">
						<div>
							<p>${user.nome}</p>
							<a href="Carrello.jsp"> <img src="images/carrello.jpg"
								title="carrello" width="14%" />
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div id="picId">
							<a href="Userform.html"> <img src="images/omino.png"
								title="user" width="10%" />
							</a> <a href="Carrello.jsp"> <img src="images/carrello.jpg"
								title="carrello" width="14%" />
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<hr>


	<div class="container-fluid">
		<h1>SoulWine presenta: ${vino.nome}</h1>


		<div class="row">
			<div class="col">
				<img src="images/${vino.nome}.jpg" width='30%'>
			</div>
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">/</th>
							<th scope="col">Specifiche</th>
						</tr>
					</thead>
					<tr>
						<th scope="row">Tipo</th>
						<td>${vino.tipo}</td>
					</tr>
					<tr>
						<th scope="row">Anno</th>
						<td>${vino.anno}</td>
					</tr>
					<tr>
						<th scope="row">Prezzo</th>
						<td>${vino.prezzo}euro</td>
					</tr>
				</table>
			</div>

		</div>
		<div class="row">
			<div class="col">
				<form action="ServletCarrello" method="get">
					<button type="submit">Aggiungi al carrello</button>
				</form>
			</div>
			<div class="col">
				<c:if test="${message != null}">
					<p class="message">${message}</p>
				</c:if>
				<c:if test="${error != null}">
					<div>
						<p class="error">${error}</p>

					</div>
				</c:if>
			</div>
		</div>

	</div>


	<hr>
	<div class="col">
		<div id="dropId">
			<div class="btn-group"></div>
			<div class="col">
				
				<h1></h1>
			</div>
		</div>
	</div>
	<br>
</body>
</html>