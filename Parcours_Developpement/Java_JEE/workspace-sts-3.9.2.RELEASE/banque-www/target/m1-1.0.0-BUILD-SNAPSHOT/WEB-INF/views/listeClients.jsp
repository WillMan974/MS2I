<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<table>
	<tr><th>Client</th><th>Compte</th></tr>
	<c:forEach var="entry" items="${data}">
	<tr><td>${entry.key}<c:forEach var="compte" items="${entry.value}"><td>${compte}</td></c:forEach></tr>
	</c:forEach>
</table>
</body>
</html>
