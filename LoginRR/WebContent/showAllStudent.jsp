<%@page import="com.zensar.BeanStudent"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Student</title>
</head>
<body>
	<p align="right">
		<a href="logoutStudent?requestAction=logoutmessage"><input
			type="button" value="logout" /></a>
	</p>
	<%
		List<BeanStudent> listOfAllStudents = (List<BeanStudent>) request.getAttribute("listOfAllStudent");
	%>
	<center>
		<h2>ALL STUDENTS DATA</h2>
		<table border="1">
			<tr>
				<th>Student id</th>
				<th>Student Name</th>
				<th>Student course</th>
				<th>Student HomeTown</th>
				<th>Student Gender</th>
				<th>Delete Student</th>
				<th>Update Student</th>
			</tr>
			<%
				for (BeanStudent bs : listOfAllStudents) {
			%>
			<tr>
				<td><%=bs.getSid()%></td>
				<td><%=bs.getSname()%></td>
				<td><%=bs.getScourse()%></td>
				<td><%=bs.getShometown()%></td>
				<td><%=bs.getSgender()%></td>
				<td><a
					href="deleteStudent?requestAction=delete&sid=<%=bs.getSid()%>"><input
						type="button" value="Delete"></a></td>
				<td><a
					href="updateStudent?requestAction=updateS&sid=<%=bs.getSid()%> "><input
						type="button" value="Update"></a></td>
			</tr>
			<%
				}
			%>

		</table>
		<a href="loginForm.jsp"><input type="button" value="logout" /></a><br>
	</center>

</body>
</html>