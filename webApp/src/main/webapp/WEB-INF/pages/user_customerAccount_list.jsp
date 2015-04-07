<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Bank | Account</title>
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
                                <h2 class="title"><a href="user_customerAccount_list"><center>Customer-Account</center></a></h2>
                                <div class="entry">
                                    <center>
                                        <div style="color: darkorange; font-size: 30px">CB Bank | Customer-Account Details</div>
                                        <br />
                                        <c:if test="${!empty customerAccountList}">
                                            <table border="1" bgcolor="black" width="600px">
                                                <tr
                                                    style="background-color: orange; color: white; text-align: center;"
                                                    height="40px">

                                                    <td>Id Customer</td>
                                                    <td>Id Account</td>
                                                    <td>Creation</td>
                                                    <td>Edit</td>
                                                    <td>Delete</td>
                                                </tr>
                                                <c:forEach items="${customerAccountList}" var="customerAccount">
                                                    <tr
                                                        style="background-color: white; color: black; text-align: center;"
                                                        height="30px">

                                                        <td><c:out value="${customerAccount.idCustomer}" />
                                                        </td>
                                                        <td><c:out value="${customerAccount.idAccount}" />
                                                        </td>
                                                        <td><c:out value="${customerAccount.creation}" />
                                                        </td>

                                                        <td><a href="user_customerAccount_edit?id=${customerAccount.id}">Edit</a></td>
                                                        <td><a href="user_customerAccount_delete?id=${customerAccount.id}">Delete</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </c:if>

                                        <br />
                                        <a href="user_customerAccount_form">Click Here to add new Customer-Account</a>
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
