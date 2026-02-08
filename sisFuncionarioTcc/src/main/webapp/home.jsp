<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
	String usuario = (String) session.getAttribute("usuarioLogin");
%>


<h2>Bem-vindo, <%= usuario %>!</h2>
</head>
<body>

</body>
</html>