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
                        <li class="active"><a href="${pageContext.request.contextPath}/doctor/list">Details</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <center>
            <h2>Consultations</h2>
            <br />
            <c:if test="${!empty consultationList}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Patient</th>
                            <th>Doctor</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Details</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <c:forEach items="${consultationList}" var="consultation">
                        <tbody>
                            <tr>
                                <td><c:out value="${consultation[1].lastName} ${consultation[1].firstName}" />
                                </td>
                                <td><c:out value="${consultation[2].lastName} ${consultation[2].firstName}" />
                                </td>
                                <td><c:out value="${consultation[0].fromDate}" />
                                </td>
                                <td><c:out value="${consultation[0].toDate}" />
                                </td>
                                <td><c:out value="${consultation[0].details}" />
                                </td>

                                <td><a href="${pageContext.request.contextPath}/doctor/edit?id=${consultation[0].id}">Edit</a></td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
            </center>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/scripts/js/jquery-1.8.2.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/bootstrap.min.js"/>" type="text/javascript"></script>
    </body>
</html>

