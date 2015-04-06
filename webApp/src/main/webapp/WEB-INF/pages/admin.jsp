<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Profile Page | cb Web App</title>
    </head>
    <body>
    <center>
        <br /> <br /> <br />
        <h1>Admin profile page !!!</h1>
        <c:url var="logoutUrl" value="j_spring_security_logout" />
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" /> <input type="hidden"
                                                           name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </center>

</body>
</html>