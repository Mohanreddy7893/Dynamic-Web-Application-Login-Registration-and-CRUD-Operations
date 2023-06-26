<%@page import="org.jsp.user_web_app.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<%
User u=(User) session.getAttribute("user");
if(u!=null){
%>

<form action="edit" method="post">

<input type="number" name="id" value="<%=u.getId()%>" readonly="readonly"> <br>
<input type="text" name="nm" value="<%=u.getName()%>"> <br>
<input type="tel" name="ph" value="<%=u.getPhone()%>"> <br>
<input type="email" name="em" value="<%=u.getEmail()%>"> <br>
<input type="password" name="ps" value="<%=u.getPassword()%>"><br>

<input type="submit" value="Update">
</form>
<%
} else {
	response.sendRedirect("login.jsp");
}


%>
</body>
</html>