<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<p align="right">
		<a href="logoutStudent?requestAction=logoutmessage"><input
			type="button" value="logout" /></a>
	</p>
	<center>
		
   <%= request.getAttribute("fname") %>
		 
	
		<h1>Welcome To Employee Details Page:</h1>
		<a href="addStudent.jsp"><input type="button" value="Add Student" /></a><br>
		<br> <a href="getAllStudent?requestAction=getAllS"><input
			type="button" value="Show all Students" /></a><br> <br> <a
			href="loginForm.jsp"><input type="button" value="logout" /></a><br>
	</center>

</body>
</html>