<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Résultat</title>
</head>

<style>
/* 	table, p, h1, li {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
	} */
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

<h1>Voici les coordonnées du nouveau client ajouté à la BDD : </h1>

<p>Nom : ${nouveauClient.nom}</p>
<p>Prénom : ${nouveauClient.prenom}</p>
<p>Adresse : ${nouveauClient.adresse}</p>
<p>Code Postal : ${nouveauClient.codepostal}</p>
<p>Ville : ${nouveauClient.ville}</p>

</body>

</html>
