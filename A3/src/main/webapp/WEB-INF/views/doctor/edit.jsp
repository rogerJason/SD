<%-- 
    Document   : list
    Created on : Apr 28, 2015, 4:26:37 PM
    Author     : Cipri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="CB">
        <title>Edit Consultation</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/scripts/bootstrap/css/bootstrap.min.css"/>">
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="<c:url value="/resources/css/cb.css"/>">
    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">CB Clinic</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/secured/basicWebsockets">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/patient/list">Patients</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/user/consultation/list">Consultations</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h3>Edit Consultation</h3>
                <br />
                <form:form id="registerForm" modelAttribute="consultation" method="post"
                           action="${pageContext.request.contextPath}/doctor/update">
                    
                    <form:hidden path="id" value="${consultationObject.id}" />
                    <form:hidden path="patientId" value="${consultationObject.patientId}" />
                    <form:hidden path="doctorId" value="${consultationObject.doctorId}" />
                    <form:hidden path="fromDate" value="${consultationObject.fromDate}" />
                    <form:hidden path="toDate" value="${consultationObject.toDate}" />

                    <div class="form-group">
                        <form:label path="details">Details</form:label>
                        <form:input path="details" type="text" class="form-control" value="${consultationObject.details}"/>
                    </div>
                    <button type="submit" class="btn btn-default">Update</button>
                </form:form>
            </div>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/scripts/js/jquery-1.8.2.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/bootstrap.min.js"/>" type="text/javascript"></script>
    </body>
</html>

