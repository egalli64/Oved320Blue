<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reception</title>
</head>
<body>     
<%@include  file="../html/Reception.html" %>
    <c:if test="${user != null}">
        <p>${user}</p>
    </c:if>
    <c:if test="${user = null}">
        <div id="picId">
    <a href="./Userform.html">
         <img src="../images/omino.png" title="user" width="10%" />
    </a>
    </div>
    </c:if>
</body>
</html>