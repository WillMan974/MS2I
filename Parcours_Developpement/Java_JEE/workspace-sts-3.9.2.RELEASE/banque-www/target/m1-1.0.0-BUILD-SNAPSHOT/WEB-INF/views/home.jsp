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

<p>Veuillez-vous connecter</p>

<table>
	<tr><th>url</th><th>url</th></tr>
	<tr><td><a href="test2">test2</td><td>Utilisation de ModelAndView</td></tr>
	<tr><td><a href="test2a">test2a</td><td>Utilisation de Model</td></tr>
	<tr><td><a href="test3?param=testParam">test3</td><td>Utilisation de Param</td></tr>
	<tr><td><a href="test3">test3</td><td>Utilisation sans param</td></tr>
	<tr><td><a href="ajoutClient">AjoutClient</td><td>Ajoute un client</td></tr>
	<tr><td><a href="modifClient">ModifClient</td><td>Modifie un client</td></tr>
</table>

<form method="post">
 <p><input type="text" placeholder="Nom" name="nom"></p>
 <p><input type="text" placeholder="Prénom" name="prenom"></p>
 <p><input type="text" placeholder="Adresse" name="adresse"></p>
 <p><input type="text" placeholder="Code Postal" name="codePostal"></p>
 <p><input type="text" placeholder="Ville" name="ville"></p>
 <p><input type="submit" value="Ajouter"></p>
</form>
	
</body>

<footer>
	<P>${serverTime}</P>
</footer>

</html>
