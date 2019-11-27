<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ajouter un client</title>
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
<form method="post">
 <p><input type="text" placeholder="Nom" name="nom"></p>
 <p><input type="text" placeholder="Prénom" name="prenom"></p>
 <p><input type="text" placeholder="Adresse" name="adresse"></p>
 <p><input type="text" placeholder="Code Postal" name="codePostal"></p>
 <p><input type="text" placeholder="Ville" name="ville"></p>
 <p><input type="submit" value="Ajouter"></p>
</form>

</body>

</html>
