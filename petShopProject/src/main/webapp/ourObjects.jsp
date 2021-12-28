<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
application.setAttribute("nbrItems", request.getAttribute("nbrItems"));
application.setAttribute("commandes", request.getAttribute("commandes"));

application.setAttribute("produit", request.getAttribute("produit"));

application.setAttribute("products", request.getAttribute("products"));

application.setAttribute("resultat", request.getAttribute("resultat"));

application.setAttribute("nameUser", request.getAttribute("nameUser"));
application.setAttribute("total", request.getAttribute("total"));
application.setAttribute("devise", request.getAttribute("devise"));



%>
<jsp:forward page="index.jsp"/>
</body>
</html>