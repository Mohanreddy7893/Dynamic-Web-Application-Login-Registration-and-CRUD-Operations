<%@page import="org.jsp.user_web_app.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">
<%
User u=(User) session.getAttribute("user");
if(u!=null) {
%>
<h1>
name: <%=u.getName() %>

</h1>

<h1>
email: <%=u.getEmail() %>

</h1>


<h1>
id: <%=u.getId() %>

</h1>

<h1>
phone: <%=u.getPhone() %>

</h1>

<h1>
password: <%=u.getPassword() %>

</h1>

<%} %>
</body>
</html>