<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>Home Page | CB Bank</title>
</head>
<body>
	<center>
		<br /> <br /> <br />
		<h1>Welcome !!!</h1>
                
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                This session will be visible to an admin only.<br/>
                You are an Administrator.<br/>
               </sec:authorize>
               <sec:authorize access="hasRole('ROLE_USER')">
                This session will be visible to a Customer only.<br/>
                You are a Customer.<br/>
               </sec:authorize>

		<c:url var="logoutUrl" value="j_spring_security_logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</center>

</body>
</html>