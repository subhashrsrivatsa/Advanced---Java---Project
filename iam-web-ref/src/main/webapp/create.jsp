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
    <div>
        <h2>login</h2>
        <form action="createIdentity" method="post">
            <div><label>Display Name</label><input name="name" type="name" /> </div>
            <div><label>Email</label><input name="email" type="name" /></div>
            <input type="submit" />
        </form>

    </div>


</body>
</html>