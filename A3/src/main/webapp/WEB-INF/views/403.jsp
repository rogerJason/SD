<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied | CB Clinic</title>
    </head>
    <body>
    <center>
        <br /> <br /> <br />
        <h1>
            Access Denied for User : <span style="color: red;">${username}</span>
        </h1>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </center>

</body>
</html>