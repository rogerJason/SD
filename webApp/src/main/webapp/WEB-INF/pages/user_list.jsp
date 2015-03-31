<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CB Bank | Client Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">CB Bank | Client Details</div>

		<c:if test="${!empty clientList}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Phone</td>
                                        <td>Address</td>
                                        <td>PNC</td>
                                        <td>Id Card Nr</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${clientList}" var="client">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						
						<td><c:out value="${client.firstName}" />
						</td>
						<td><c:out value="${client.lastName}" />
						</td>
						<td><c:out value="${client.email}" />
						</td>
						<td><c:out value="${client.phone}" />
						</td>
                                                <td><c:out value="${client.address}" />
						</td>
                                                <td><c:out value="${client.PNC}" />
						</td>
                                                <td><c:out value="${client.idCardNr}" />
						</td>
						<td><a href="user_edit?id=${client.id}">Edit</a></td>
						<td><a href="user_delete?id=${client.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<a href="user_form">Click Here to add new Client</a>
	</center>
</body>
</html>
