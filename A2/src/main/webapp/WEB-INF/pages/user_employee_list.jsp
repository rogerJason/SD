<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Bank | Clients</title>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    </head>

    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="home">CB Bank</a></h1>
                </div>
                <div id="search">
                    <c:url var="logoutUrl" value="j_spring_security_logout" />
                    <form method="post" action="${logoutUrl}">
                        <fieldset>
                            <p id="search-text">
                                Logged In: 
                            <sec:authorize access="isAuthenticated()"> 
                                <sec:authentication property="principal.username" />
                            </sec:authorize>
                            </p>
                            <p align="right">
                                <input type="submit" id="search-submit" value="Log Out" />  
                            </p>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </fieldset>
                    </form>
                </div>
            </div>
            <!-- end #header -->
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="menu">
                            <ul>
                                <li class="current_page_item"><a href="home">Home</a></li>
                                <li><a href="login">Login</a></li>
                                <li><a href="user_list">Clients</a></li>
                                <li><a href="user_account_list">Accounts</a></li>
                                <li><a href="user_customerAccount_list">Links</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                        <!-- end #menu -->
                        <div id="content">
                            <div class="post">
                                <h2 class="title"><a href="login"><center>Clients</center></a></h2>
                                <div class="entry">
                                    <center>
                                        <div style="color: darkorange; font-size: 30px">CB Bank | Client Details</div>
                                        <br />
                                        <c:if test="${!empty employeeList}">
                                            <table border="1" bgcolor="black" width="900px">
                                                <tr
                                                    style="background-color: orange; color: white; text-align: center;"
                                                    height="40px">

                                                    <td>First Name</td>
                                                    <td>Last Name</td>
                                                    <td>Income</td>
                                                    <td>Edit</td>
                                                    <td>Delete</td>
                                                </tr>
                                                <c:forEach items="${employeeList}" var="employee">
                                                    <tr
                                                        style="background-color: white; color: black; text-align: center;"
                                                        height="30px">

                                                        <td><c:out value="${employee.firstName}" />
                                                        </td>
                                                        <td><c:out value="${employee.lastName}" />
                                                        </td>
                                                        <td><c:out value="${employee.income}" />
                                                        </td>
                                                        
                                                        <td><a href="user_edit?id=${employee.id}">Edit</a></td>
                                                        <td><a href="user_delete?id=${employee.id}">Delete</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </c:if>

                                        <br />
                                        <a href="user_employee_form">Click Here to add new Employee</a>
                                    </center>
                                </div>                              
                            </div>
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                    </div>
                </div>
            </div>
            <!-- end #page -->
        </div>
        <div id="footer-wrapper">
            <div id="footer">
                <p>&copy; All rights reserved. Design by CB.</p>
            </div>
        </div>
        <!-- end #footer -->
    </body>
</html>
