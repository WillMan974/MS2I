<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>R�sultat</title>
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

<h1>R�sultat de la saisie</h1>

<h1>Nom : ${nouveauClient.nom}</h1>
<h1>Pr�nom : ${nouveauClient.prenom}</h1>
<h1>Adresse : ${nouveauClient.adresse}</h1>
<h1>Code Postal : ${nouveauClient.codePostal}</h1>
<h1>Ville : ${nouveauClient.ville}</h1>

</body>

</html>
