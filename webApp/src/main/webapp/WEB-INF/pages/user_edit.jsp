<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cb Web App | Edit Client Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">CB Bank |
			Edit Details</div>



		<c:url var="clientRegistration" value="saveClient.html" />
		<form:form id="registerForm" modelAttribute="client" method="post"
			action="user_update">
			<table width="400px" height="150px">
                            <form:hidden path="id" value="${clientObject.id}" />
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>                                      
					<td><form:input path="firstName" value="${clientObject.firstName}" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" value="${clientObject.lastName}"/></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" value="${clientObject.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="phone">Phone</form:label></td>
					<td><form:input path="phone" value="${clientObject.phone}"/></td>
				</tr>
                                <tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:input path="address" value="${clientObject.address}"/></td>
				</tr>
                                <tr>
					<td><form:label path="PNC">PNC</form:label></td>
					<td><form:input path="PNC" value="${clientObject.PNC}"/></td>
				</tr>
                                <tr>
					<td><form:label path="idCardNr">Id Card Nr</form:label></td>
					<td><form:input path="idCardNr" value="${clientObject.idCardNr}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update" />
					</td>
				</tr>
			</table>
		</form:form>


		
	</center>
</body>
</html>
