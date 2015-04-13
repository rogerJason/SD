<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Bank | Home Page</title>
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
                                <h2 class="title"><a href="home">Welcome to CB Bank </a></h2>
                                <div class="entry">
                                    <p>
                                        <img src="<c:url value="/resources/images/bank.jpg" />" width="143" height="143" alt="CB Bank" class="alignleft border"/> 
                                        <strong>CB Bank</strong> (abbreviated as CBB) is an American multinational banking and financial services corporation headquartered in Charlotte, North Carolina. It is the second largest bank holding company in the United States by assets. As of 2013, CB Bank is the twenty-first largest company in the United States by total revenue. In 2010, Forbes listed CB Bank as the third biggest company in the world.
                                    <p>The bank's 2008 acquisition of Merrill Lynch made CB Bank the world's largest wealth management corporation and a major player in the investment banking market. According to the Scorpio Partnership Global Private Banking Benchmark 2014 it had assets under management (AuM) of 1,866.6 (USD Bn) an increase of 12.5% on 2013</p>
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>
                        <!-- end #content -->
                        <div id="sidebar">
                            <ul>
                                <li>
                                    <h2>Our Motto:</h2>
                                    <p>"Invest with confidence"</p>
                                </li>
                                <li>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        This session will be visible to an admin only.<br/>
                                        You are an Administrator.<br/>
                                        Click <a href="admin">Here</a> to perform operations on Employees!<br/>
                                    </sec:authorize>
                                </li>
                                <li>
                                    <h2>Categories</h2>
                                    <ul>
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Login</a></li>
                                        <li><a href="#">Clients</a></li>
                                        <li><a href="#">Accounts</a></li>
                                        <li><a href="#">Links</a></li>
                                        <li><a href="#">Contact</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!-- end #sidebar -->
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
