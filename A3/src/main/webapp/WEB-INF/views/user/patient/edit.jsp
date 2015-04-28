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
        <title>Add Patient</title>
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
                        <li class="active"><a href="${pageContext.request.contextPath}/user/patient/list">Patients</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h3>Edit Patient</h3>
                <br />
                <form:form id="registerForm" modelAttribute="patient" method="post"
                           action="${pageContext.request.contextPath}/user/patient/update">
                    
                    <form:hidden path="id" value="${patientObject.id}" />
                    <div class="form-group">
                        <form:label path="lastName">Last Name</form:label>
                        <form:input path="lastName" type="text" class="form-control" value="${patientObject.lastName}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="firstName">First Name</form:label>
                        <form:input path="firstName" type="text" class="form-control" value="${patientObject.firstName}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="idCardNr">Identity Card Number</form:label>
                        <form:input path="idCardNr" type="text" class="form-control" value="${patientObject.idCardNr}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="PNC">Personal Numeric Code</form:label>
                        <form:input path="PNC" type="text" class="form-control" value="${patientObject.PNC}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="dateOfBirth">Date of Birth</form:label>
                        <form:input path="dateOfBirth" type="text" class="form-control" value="${patientObject.dateOfBirth}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="address">Address</form:label>
                        <form:input path="address" type="text" class="form-control" value="${patientObject.address}"/>
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

