<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Bank | Edit Account</title>
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
                                <h2 class="title"><a href="login"><center>Edit Account</center></a></h2>
                                <div class="entry">
                                    <center>
                                        <div style="color: darkorange; font-size: 30px">CB Bank | Edit Details</div>
                                        <br />
                                        <c:url var="accountRegistration" value="saveAccount.html" />
                                        <form:form id="registerForm" modelAttribute="account" method="post"
                                                   action="user_account_update">
                                            <table width="400px" height="150px">
                                                <form:hidden path="id" value="${accountObject.id}" />
                                                <tr>
                                                    <td><form:label path="IBAN">IBAN</form:label></td>                                      
                                                    <td><form:input path="IBAN" value="${accountObject.IBAN}" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="type">Type</form:label></td>                                      
                                                    <td><form:input path="type" value="${accountObject.type}" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="balance">Balance</form:label></td>
                                                    <td><form:input path="balance" value="${accountObject.balance}"/></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="interestRate">Interest Rate</form:label></td>
                                                    <td><form:input path="interestRate" value="${accountObject.interestRate}"/></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="overdraft">Overdraft</form:label></td>
                                                    <td><form:input path="overdraft" value="${accountObject.overdraft}"/></td>
                                                </tr>

                                                <tr>
                                                    <td></td>                                                   
                                                    <td><br /><input type="submit" value="Update" />
                                                    </td>
                                                </tr>
                                            </table>
                                        </form:form>
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
