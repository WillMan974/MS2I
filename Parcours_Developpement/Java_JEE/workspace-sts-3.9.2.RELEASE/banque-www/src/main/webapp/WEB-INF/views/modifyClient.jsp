<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modifier un client</title>
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

	<label for="customers-select">Customer to modify :</label><br>

	<select name="pets" id="customers-select">
	    <option value="">--Please choose a customer--</option>
	    <c:forEach var="client" items="${customersList}">
	    	<option value="${client.id}">${client.nom}</option>
	    </c:forEach>
	    
	</select>

	<form:form method="post" modelAttribute="clientAModifier" action="modifClient">
		<p><form:input path="nom"/></p>
		<p><form:input path="prenom"/></p>
		<p><form:input path="adresse"/></p>
		<p><form:input path="codepostal"/></p>
		<p><form:input path="ville"/></p>
		<p><input type="submit" value="MODIFIER"/></p>
	</form:form>

</body>

</html>
