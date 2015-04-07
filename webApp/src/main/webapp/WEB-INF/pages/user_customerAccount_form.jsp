<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                                <h2 class="title"><a href="user_customerAccount_list"><center>Link Customer to an Account</center></a></h2>
                                <div class="entry">
                                    <center>
                                        <div style="color: darkorange; font-size: 30px">CB Bank | Registration Form</div>
                                        <br />
                                        <c:url var="customerAccountRegistration" value="saveCustomerAccount.html" />
                                        <form:form id="registerForm" modelAttribute="customerAccount" method="post"
                                                   action="user_customerAccount_register">
                                            <table width="400px" height="150px">
                                                <tr>
                                                    <td><form:label path="idCustomer">Id Customer</form:label></td>
                                                    <td><form:input path="idCustomer" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="idAccount">Id Account</form:label></td>
                                                    <td><form:input path="idAccount" /></td>
                                                </tr>
                                                <tr>
                                                    <td><form:label path="creation">Creation</form:label></td>
                                                    <td><form:input path="creation" /></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td></td>
                                                    <td><input type="submit" value="Register" />
                                                    </td>
                                                </tr>
                                            </table>
                                        </form:form>
                                        <a href="user_customerAccount_list">Click Here to see Customer-Account List</a>
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
