<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrello</title>
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
<link rel="stylesheet" type="text/css" href="./css/index.css">
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
				<c:choose>
					<c:when test="${user != null}">
						<div id="dropId">
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">${user.nome}</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="ServletLogout">Disconnetti</a>
								</div>
							</div>
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
	<div class="container fluid">
		<c:set var="totale" value="0" />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Items</th>
					<th>Quantità</th>
					<th>Prezzo</th>
				</tr>
			</thead>

			<c:forEach var="vino" items="${acquisti}">
				<tr>
					<td><c:out value="${vino.nome}" /></td>
					<td><c:out value="${vino.stock}" /></td>
					<td><c:set var="totale" value='${totale+vino.prezzo}' />
						<p>
							<c:out value="${vino.prezzo*vino.stock}" />
							€
						</p></td>
				</tr>
			</c:forEach>
			
			<tr>
			<th><c:if test="${error != null}">
					<p class="error">${error}</p>
				</c:if></th>
				<th></th>
				<th>
				<p>	Totale = <c:out value="${totale}" />	€</p>
				</th>
			</tr>
		</table>

	</div>

	<div class="container fluid">
		<a href="index.jsp">Continua con gli acquisti!</a>
	</div>


	</div>


</body>
</html>