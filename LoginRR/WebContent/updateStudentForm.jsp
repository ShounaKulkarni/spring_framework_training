<%@page import="com.zensar.BeanStudent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p align="right">
		<a href="logoutStudent?requestAction=logoutmessage"><input
			type="button" value="logout" /></a>
	</p>
	<%
		BeanStudent bs = (BeanStudent) request.getAttribute("bs");
	%>
	<center>
		<h2>Update Student Details</h2>
		<form action="updateStudent">
			<input type="hidden" name="requestAction" value="updateDB" />
			<table>

				<tr>
					<td>Student Id:</td>
					<td><input type="text" name="sid" value=<%=bs.getSid()%>></td>
				</tr>
				<tr>
					<td>Student Name:</td>
					<td><input type="text" name="sname" value="<%=bs.getSname()%>" /></td>
				</tr>
				<tr>
					<td>Student Course:</td>
					<td><input type="text" name="scourse"
						value="<%=bs.getScourse()%>" /></td>
				</tr>
				<tr>
					<td>Student HomeTown</td>
					<td><select name="shometown">
							<option value="Pune" label="Pune"
								<%if (bs.getShometown().equalsIgnoreCase("Pune")) {%> selected
								<%}%> />
							<option value="Ahmednagar" label="Ahmednagar"
								<%if (bs.getShometown().equalsIgnoreCase("Ahmednagar")) {%>
								selected <%}%> />
							<option value="Mumbai" label="Mumbai"
								<%if (bs.getShometown().equalsIgnoreCase("Mumbai")) {%> selected
								<%}%> />
							<option value="Delhi" label="Delhi"
								<%if (bs.getShometown().equalsIgnoreCase("Delhi")) {%> selected
								<%}%> />
					</select></td>
				</tr>
				<tr>
					<td>Student Gender:</td>
					<td><input type="radio" id="male" name="sgender" value="male"
						<%if (bs.getSgender().equalsIgnoreCase("male")) {%> checked <%}%> />
						Male</td>

					<td><input type="radio" id="female" name="sgender"
						value="female"
						<%if (bs.getSgender().equalsIgnoreCase("female")) {%> checked
						<%}%> /> Female</td>

				</tr>
				<tr>
					<td><center>
							<input type="submit" value="Update Student" />
						</center></td>
				</tr>
			</table>
		</form>
		<a href="loginForm.jsp"><input type="button" value="logout" /></a><br>
	</center>

</body>
</html>
