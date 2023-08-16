<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
String table = (String) request.getAttribute("table");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Extreme activities database</title>
</head>
<body>

	<h1>Extreme activities database</h1>
	
	
	<%= table %>
	<br/>
	<a href="add">Add activity</a>
	
	
</body>
</html>