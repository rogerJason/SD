<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>CB Bank | Edit Account</title>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    </head>

    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="home">CB Bank</a></h1>
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
                                <li><a href="account_list">Accounts</a></li>
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
                                                   action="account_update">
                                            <table width="400px" height="150px">
                                                <form:hidden path="id" value="${accountObject.id}" />
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
                                                    <td><form:label path="lastAccess">Last Access</form:label></td>
                                                    <td><form:input path="lastAccess" value="${accountObject.lastAccess}"/></td>
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
