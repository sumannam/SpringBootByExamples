<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC
        "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JSP Index Page</title>
</head>
<body>
        <h1>Index page</h1>
        <p>${val}</p>
        <form method="post" action="/">
                <input type="text" name="text1">
                <input type="submit">
        </form>
</body>
</html>
