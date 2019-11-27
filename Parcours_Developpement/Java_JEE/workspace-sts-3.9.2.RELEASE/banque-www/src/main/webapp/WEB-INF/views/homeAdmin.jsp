<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>

<body>
	<h1>${message}</h1>
	
	<table>
		<tr>
			<th>Action</th>
		</tr>
		<tr>
			<td><a href="ajoutClient">Ajouter un client</td>
		</tr>
		<tr>
			<td><a href="modifClient">Modif<td>Modifie un client</td>
		</tr>
		<%-- <tr><td><a href="<c:url value="/j_spring_security_logout" />">Deconnexion</a></td><td>Quitter le mode admin</td></tr> --%>
	</table>
</body>

<footer>
	<P>${serverTime}</P>
</footer>

</html>
