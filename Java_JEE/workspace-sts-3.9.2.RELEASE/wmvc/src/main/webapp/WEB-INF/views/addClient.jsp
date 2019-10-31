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
 <p><input type="text" name="nom"></p>
 <p><input type="text" name="prenom"></p>
 <p><input type="text" name="adresse"></p>
 <p><input type="text" name="codePostal"></p>
 <p><input type="text" name="ville"></p>
 <p><input type="submit" value="ajouter"></p>
</form>

</body>

</html>
