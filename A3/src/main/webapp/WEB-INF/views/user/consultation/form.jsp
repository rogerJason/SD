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
        <title>Add Consultation</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/scripts/bootstrap/css/bootstrap.min.css"/>">
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="<c:url value="/resources/css/cb.css"/>">
        
        <link rel="stylesheet" href="<c:url value="/resources/scripts/datetimepicker/bootstrap-datetimepicker.min.css"/>" media="screen">
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
                <h3>Registration Form</h3>
                <br />
                <form:form id="registerForm" modelAttribute="consultation" method="post"
                           action="${pageContext.request.contextPath}/user/consultation/register">

                    <div class="form-group">
                        <form:label path="patientId">Patient Id</form:label>
                        <form:input path="patientId" type="text" class="form-control" placeholder="Hint:"/>
                    </div>
                    <div class="form-group">
                        <form:label path="doctorId">Doctor Id</form:label>
                        <form:input path="doctorId" type="text" class="form-control" placeholder="Hint:"/>
                    </div>
                    <div class="form-group">
                        <form:label path="fromDate">From</form:label>
                        <div class="input-group date form_datetime" data-date="2015-04-01T05:25:07Z" data-date-format="yyyy-mm-dd hh:ii:00">
                            <form:input path="fromDate" type="text" class="form-control" value=""/>                           
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>                       
                    </div>
                    <div class="form-group">
                        <form:label path="toDate">To</form:label>
                        <div class="input-group date form_datetime" data-date="2015-04-01T05:25:07Z" data-date-format="yyyy-mm-dd hh:ii:00">
                            <form:input path="toDate" type="text" class="form-control" value=""/>                           
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>                       
                    </div>
                            <button type="submit" class="btn btn-default">Submit</button> &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/user/consultation/check" target="_blank" class="btn btn-info" role="button">Check Doctor</a>
                </form:form>
            </div>

        </div><!-- /.container -->
        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/scripts/js/jquery-1.8.2.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/bootstrap.min.js"/>" type="text/javascript"></script>

        <script src="<c:url value="/resources/scripts/datetimepicker/bootstrap-datetimepicker.js"/>" type="text/javascript" charset="UTF-8"></script>
        <script type="text/javascript">
            $('.form_datetime').datetimepicker({
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                forceParse: 0
            });
        </script>
    </body>
</html>

