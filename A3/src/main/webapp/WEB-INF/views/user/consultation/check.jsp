<%-- 
    Document   : list
    Created on : Apr 28, 2015, 4:26:37 PM
    Author     : Cipri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="CB">
        <title>Consultations</title>
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
                <h2>Check if doctor available</h2> <br/>
                <form method="GET" action="${pageContext.request.contextPath}/user/consultation/check">
                    <input type="text" name="fromDate" style="font-size: 15px" value="yyyy-mm-dd hh:mm:ss"/>  
                    <br/><br/><input type="text" name="toDate" style="font-size: 15px" value="yyyy-mm-dd hh:mm:ss"/>
                    <br/><br/><input type="submit" value="Check" class="btn btn-info"/>
                </form>

                    <br/><br/><br/>
                <c:if test="${!empty doctorList}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Last Name</th>
                                <th>First Name</th>

                            </tr>
                        </thead>
                        <c:forEach items="${doctorList}" var="doctor">
                            <tbody>
                                <tr>
                                    <td><c:out value="${doctor.lastName}" />
                                    </td>
                                    <td><c:out value="${doctor.firstName}" />
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </c:if>
            </div>

        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/scripts/js/jquery-1.8.2.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/bootstrap.min.js"/>" type="text/javascript"></script>
    </body>
</html>

