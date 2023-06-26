<%@page import="org.jsp.user_web_app.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="orange">
<%
User u=(User) session.getAttribute("user");
if(u!=null){
%>
<h1 style="color:cyan;">Login Successful</h1>
<h2 >
    <a href="edit.jsp" style="color:red;"> Click Here To Edit Your Details</a>
</h2>

<h2 >
    <a href="delete?id=<%=u.getId()%>" style="color:skyblue;"> Click Here To Delete Your Account </a>
</h2>

<h2 >
    <a href="view.jsp" style="color:pink;"> Click Here To  View Your Details </a>
</h2>

<h2 >
    <a href="logout" style="color:purple;"> Click Here To  Logout</a>
</h2>

<%
} else {
	response.sendRedirect("login.jsp");
}


%>
</body>
</html>