<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Bank | Registration</title>
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
                                <li><a href="#">Links</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                        <!-- end #menu -->
                        <div id="content">
                            <div class="post">
                                <h2 class="title"><a href="login"><center>Register Client</center></a></h2>
                                <div class="entry">
                                    <center>
                                        <div style="color: darkorange; font-size: 30px">CB Bank | Registration Form</div>
                                        <br />
                                        <c:url var="clientRegistration" value="saveClient.html" />
                                        <form:form id="registerForm" modelAttribute="client" method="post"
                                                   action="user_register">
                                            <table width="400px" height="150px">
                                                <tr>
                                                    <td><form:label path="firstName">First Name</form:label></td>
                                                    <td><form:input path="firstName" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="lastName">Last Name</form:label></td>
                                                    <td><form:input path="lastName" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="email">Email</form:label></td>
                                                    <td><form:input path="email" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="phone">Phone</form:label></td>
                                                    <td><form:input path="phone" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="address">Address</form:label></td>
                                                    <td><form:input path="address" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="PNC">PNC</form:label></td>
                                                    <td><form:input path="PNC" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="idCardNr">Id Card Nr</form:label></td>
                                                    <td><form:input path="idCardNr" /></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td><input type="submit" value="Register" />
                                                    </td>
                                                </tr>
                                            </table>
                                        </form:form>
                                        <a href="user_list">Click Here to see Client List</a>
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
