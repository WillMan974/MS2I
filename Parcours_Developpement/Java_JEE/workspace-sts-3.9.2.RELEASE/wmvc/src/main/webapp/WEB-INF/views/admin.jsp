<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>

<style>
	table, p, h1, li {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
	}
	td, th {
		border: 1px, solid, #dddddd;
		text-align: left;
		padding: 8px;
	}
	tr:nth-child(even){
		background-color: #dddddd;
	}
</style>

<body>
<h1>
	Page admin  
</h1>

<P>${message}.</P>

<table>
	<tr><th>url</th><th>description</th></tr>
	<tr><td><a href="ajoutClient">AjoutClient</td><td>Ajoute un client</td></tr>
	<tr><td><a href="modifClient">ModifClient</td><td>Modifie un client</td></tr>
	<tr><td><a href="<c:url value="/j_spring_security_logout" />">Deconnexion</a></td><td>Quitter le mode admin</td></tr>
	
</table>
</body>
</html>
