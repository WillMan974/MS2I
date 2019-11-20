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
	JSP Test 2
</h1>

<P>  La servlet à envoyé les valeurs suivantes :</P>
<table>
	<tr><th>Clé</th><th>Valeur</th></tr>
	<tr><td>Un</td><td>${un}</td></tr>
	<tr><td>Deux</td><td>${deux}</td></tr>
	<tr><td>Trois</td><td>${trois}</td></tr>
</table>
</body>
</html>
