<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>

<h1>Welcome to the identity and access management application</h1>
<h2>Hello <%=session.getAttribute("user")%>, <h2/>

<br/>

<h2>Last action success!<h2/>

<br/>
<br/>

<a href="/iam-web/create.jsp" > Create Identity </a><br/>
<a href="/iam-web/update.jsp" > Update Identity </a><br/>
<a href="/iam-web/delete.jsp" > Delete Identity </a><br/>
<a href="/iam-web/search.jsp" > Search Identity </a><br/>
<a href="/iam-web/readIdentity" > See all </a><br/>


</body>
</html>