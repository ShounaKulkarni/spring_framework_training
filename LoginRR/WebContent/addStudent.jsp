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
	<center>
		<h1>Add Student Details:</h1>
		<form action="addStudent" method="post">
			<input type="hidden" name="requestAction" value="addDB" />
			<table>

				<tr>
					<td>Student Id:</td>
					<td><input type="text" name="sid" /></td>
				</tr>
				<tr>
					<td>Student Name:</td>
					<td><input type="text" name="sname" /></td>
				</tr>
				<tr>
					<td>Course Name:</td>
					<td><input type="text" name="scourse" /></td>
				</tr>
				<tr>
					<td><label for="towns">Choose a Town:</label></td>

					<td><select name="shometown">
							<option value="Pune">Pune</option>
							<option value="Ahmednagar">Ahmednagar</option>
							<option value="Mumbai">Mumbai</option>
							<option value="Delhi">Dehli</option>
					</select></td>
				</tr>
				<tr>
					<td>Employee Gender:</td>
					<td><input type="radio" id="male" name="sgender" value="male">
						Male</td>

					<td><input type="radio" id="female" name="sgender"
						value="female"> Female</td>

				</tr>
				<tr>
					<td><center>
							<input type="submit" value="Add Student" />
						</center></td>
				</tr>
			</table>
		</form>
		<a href="loginForm.jsp"><input type="button" value="logout" /></a><br>
		<br>
	</center>

</body>
</html>