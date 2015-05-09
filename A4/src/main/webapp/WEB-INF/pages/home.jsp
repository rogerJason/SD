<%-- 
    Document   : home
    Created on : May 9, 2015, 10:01:10 PM
    Author     : Cipri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Paint | Home</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/paint.css"/>">
    </head>
    <body>
        <div id="sketch">
            <canvas id="paint"></canvas>
        </div>
        
        <script src="<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/paint.js"/>"></script>
    </body>
</html>
