<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cb Web App | Edit User Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">cb Web App |
			Edit Details</div>



		<c:url var="userRegistration" value="saveUser.html" />
		<form:form id="registerForm" modelAttribute="user" method="post"
			action="update">
			<table width="400px" height="150px">
                            <form:hidden path="id" value="${userObject.id}" />
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>                                      
					<td><form:input path="firstName" value="${userObject.firstName}" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" value="${userObject.lastName}"/></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" value="${userObject.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="phone">Phone</form:label></td>
					<td><form:input path="phone" value="${userObject.phone}"/></td>
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
