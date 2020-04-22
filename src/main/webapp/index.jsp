<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<base href="/blue/">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<br>
<div class="container-fluid" >
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
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
  	</form>
	</nav>
 	</div>
 	<div class="col">
 	    <c:choose>
 	      <c:when test="${error}">
            <div>
              <p id ="errorId" class="mistake">${error}</p>"
 	      </div>
 	      </c:when>      
        <c:otherwise>
            <div id="picId">
              <a href="Userform.html">
              <img src="images/omino.png" title="user" width="10%" />
              </a>
           
    <a href="Carrello.jsp">
 	    <img src="images/carrello.jpg" title="carrello" width="14%" />
 	</a>  
 	</div>
 	</c:otherwise>
 	   </c:choose>
    </div>
     
    </div>
  	</div>
	<hr>
	<div class="container-fluid" >
	<div class="row">
	<div class="col">
    <h1></h1>  
    </div>
	<div class="col">
	<div id="dropId">
	<div class="btn-group">
  	<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Vini Rossi
  	</button>
  	<div class="dropdown-menu">
    <a class="dropdown-item" href="ServletVino?vino=Bonarda">Bonarda</a>
    <a class="dropdown-item" href="ServletVino?vino=Lambrusco">Lambrusco</a>
    <a class="dropdown-item" href="ServletVino?vino=Negroamaro">Negroamaro</a>
  	</div>
	</div>
	<div class="btn-group">
  	<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Vini Bianchi
  	</button>
  	<div class="dropdown-menu">
    <a class="dropdown-item" href="ServletVino?vino=Chardonnay">Chardonnay</a>
    <a class="dropdown-item" href="ServletVino?vino=Lugana">Lugana</a>
    <a class="dropdown-item" href="ServletVino?vino=Vermentino">Vermentino</a>
  	</div>
	</div>
	<div class="btn-group">
  	<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Spumanti
  	</button>
  	<div class="dropdown-menu">
    <a class="dropdown-item" href="ServletVino?vino=Prosecco">Prosecco</a>
    <a class="dropdown-item" href="ServletVino?vino=Champagne">Champagne</a>
    <a class="dropdown-item" href="ServletVino?vino=Trento Doc">Trento Doc</a>
  	</div>
	</div>
	</div>
	<hr>
	</div>
	<div class="col">
    <h1></h1>  
    </div>
    </div>
    </div>
    <br>
	<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
  	<ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
  	</ol>
  	<div class="carousel-inner">
    <div class="carousel-item active">
    <img src="images/uva.jpg" class="d-block w-100" width="10%">
    <div class="carousel-caption d-none d-md-block">
    <h5>LA QUALITA NON E UN OPTIONAL, MA UN MUST</h5>
        <p>I vigneti di prima qualità di cui provvengono i nostri prodotti sono la dimostrazione della nostra passione </p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="images/bottiglie-vino.jpg" class="d-block w-100" width="14%">
      <div class="carousel-caption d-none d-md-block">
        <h5>INGREDIENTE MAGICO: IL TEMPO</h5>
        <p>L'invecchiamento consente ai vari prodotti di offrire un autentico risveglio al momento della scoperta</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="images/calici.jpg" class="d-block w-100" width="10%">
      <div class="carousel-caption d-none d-md-block">
        <h5>FESTEGGIAMO INSIEME</h5>
        <p>Ogni momento è propizio per degustare e scoprire nuovi sapori</p>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>    
</body>
</html>