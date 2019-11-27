<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Comptes clients  
</h1>
<table>
	<tr>
		<th>Client</th>
		<th>Numéro de compte</th>
	</tr>
	
	<c:forEach var="client" items="${data}">
		<c:if test="${empty client.value}">
			<td>${client.key}</td>
			<td>NOTHING</td>
		</c:if>
		<c:forEach var="compte" items="${client.value}">
			<tr>
				<td>${client.key}</td>
				<td>${compte.numero}</td>
			</tr>					
		</c:forEach>
	</c:forEach>
	
</table>
</body>
</html>
