<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Bienvenue sur WillyBank !  
</h1>

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
<footer>
	<P>  Vous êtes en ${country}, il est ${serverTime}. </P>
</footer>
</html>
