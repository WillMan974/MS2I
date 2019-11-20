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
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<table>
	<tr><th>url</th><th>url</th></tr>
	<tr><td><a href="test2">test2</td><td>Utilisation de ModelAndView</td></tr>
	<tr><td><a href="test2a">test2a</td><td>Utilisation de Model</td></tr>
	<tr><td><a href="test3?param=testParam">test3</td><td>Utilisation de Param</td></tr>
	<tr><td><a href="test3">test3</td><td>Utilisation sans param</td></tr>
	<tr><td><a href="ajoutClient">AjoutClient</td><td>Ajoute un client</td></tr>
	<tr><td><a href="modifClient">ModifClient</td><td>Modifie un client</td></tr>
</table>
</body>
</html>
