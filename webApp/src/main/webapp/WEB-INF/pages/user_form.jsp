<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CB Bank | Registration Form</title>
</head>
<body>
	<center>	
		<div style="color: teal; font-size: 30px">CB Bank | Registration Form</div>
		
		<c:url var="clientRegistration" value="saveClient.html" />
		<form:form id="registerForm" modelAttribute="client" method="post"
			action="user_register">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">Phone</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>
                                <tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:input path="address" /></td>
				</tr>
                                <tr>
					<td><form:label path="PNC">PNC</form:label></td>
					<td><form:input path="PNC" /></td>
				</tr>
                                <tr>
					<td><form:label path="idCardNr">Id Card Nr</form:label></td>
					<td><form:input path="idCardNr" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" />
					</td>
				</tr>
			</table>
		</form:form>


		<a href="user_list">Click Here to see Client List</a>
	</center>
</body>
</html>
