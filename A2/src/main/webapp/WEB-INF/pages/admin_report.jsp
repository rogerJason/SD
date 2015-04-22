<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB BookStore | Report</title>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="all">
        <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />" />
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.6.2.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery.jcarousel.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/functions.js" />"></script>
    </head>
    <body>
        <!-- Header -->
        <div id="header" class="shell">
            <div id="logo"><h1><a href="home">BestSeller</a></h1></div>
            <!-- Navigation -->
            <div id="navigation">
                <ul>
                    <li><a href="#" class="active">Home</a></li>
                    <li><a href="#">Products</a></li>
                    <li><a href="#">Promotions</a></li>
                    <li><a href="#">Profile</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contacts</a></li>
                </ul>
            </div>
            <!-- End Navigation -->
            <div class="cl">&nbsp;</div>
            <!-- Login-details -->
            <div id="login-details">
                <c:url var="logoutUrl" value="j_spring_security_logout" />
                <form method="post" action="${logoutUrl}">
                    <p>Welcome, <a href="#" id="user">
                            <sec:authorize access="isAuthenticated()"> 
                                <sec:authentication property="principal.username" />
                            </sec:authorize></a> . <input type="submit" id="search-submit" value="Log Out" /></p>
                    <p><a href="#" class="cart" >
                            <img src="<c:url value="/resources/images/cart-icon.png" />" alt="" /></a>
                        Shopping Cart (0) <a href="#" class="sum">$0.00</a></p>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
            <!-- End Login-details -->
        </div>
        <!-- End Header -->
        <!-- Slider -->
        <div id="slider">
            <div class="shell">
                <ul>
                    <li>
                        <div class="image">
                            <img src="<c:url value="/resources/images/books1.jpg" />" alt="" />
                        </div>
                        <div class="details">
                            <h2>Thrillers</h2>
                            <h3>This Month's Top Picks</h3>
                            <p class="title">The first in a new series from David Baldacci</p>
                            <p class="description">A Stone Barrington novel from Stuart Woods, and more exciting new reads.</p>
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                    <li>
                        <div class="image">
                            <img src="<c:url value="/resources/images/books.png" />" alt="" />
                        </div>
                        <div class="details">
                            <h2>Bestsellers</h2>
                            <h3>Special Offers</h3>
                            <p class="title">The World is Flat</p>
                            <p class="description">The Coming Economic Collapse</p>
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                    <li>
                        <div class="image">
                            <img src="<c:url value="/resources/images/books2.jpg" />" alt="" />
                        </div>
                        <div class="details">
                            <h2>Inspiring</h2>
                            <h3>Life Stories</h3>
                            <p class="title">Perfect for Mother's Day</p>
                            <p class="description">These are the true stories of glamorous, funny, fierce, and courageous women.</p>
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                    <li>
                        <div class="image">
                            <img src="<c:url value="/resources/images/books3.jpg" />" alt="" />
                        </div>
                        <div class="details">
                            <h2>The Book</h2>
                            <h3>Nerd Diet</h3>
                            <p class="title">You’re in the middle of what’s shaping up to be a truly excellent book.</p>
                            <p class="description"> You’ve been reading for the past hour and a half, and the odds of you parting with your new beloved before you reach that bittersweet conclusion rival the odds of Mr. Darcy smiling at a public ball. </p>
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                </ul>
                <div class="nav">
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                </div>
            </div>
        </div>
        <!-- End Slider -->
        <!-- Main -->
        <div id="main" class="shell">
            <!-- Sidebar -->
            <div id="sidebar">
                <ul class="categories">
                    <li>
                        <h4>Categories</h4>
                        <ul>
                            <li><a href="#">Computing</a></li>
                            <li><a href="#">Crime & Thriller</a></li>
                            <li><a href="#">Fiction</a></li>
                            <li><a href="#">Humour</a></li>
                            <li><a href="#">Romance</a></li>
                            <li><a href="#">Sport</a></li>
                            <li><a href="#">Medical</a></li>
                        </ul>
                    </li>
                    <li>
                        <h4>Authors</h4>
                        <ul>
                            <li><a href="#">Steve Krug</a></li>
                            <li><a href="#">Jamie Bartlett</a></li>
                            <li><a href="#">Sophie Hannah</a></li>
                            <li><a href="#">Lee Child</a></li>
                            <li><a href="#">John Darnielle</a></li>
                            <li><a href="#">Barney Stinson</a></li>
                            <li><a href="#">Viktor E. Frankl</a></li>
                            <li><a href="#">Keri Smith</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- End Sidebar -->
            <!-- Content -->
            <div id="content">
                <center>
                    <div style="color: teal; font-size: 30px">CB BookStore | Generate Report</div>
                    <br /> <br /> <br /> 
                    <a href="admin_report_txt" style="font-size: 15px; ">Generate TXT Report</a>
                    <br/><br/>
                    <a href="admin_report_xml" style="font-size: 15px; ">Generate XML Report</a>
                    <br />                   
                </center>
            </div>
            <!-- End Content -->
            <div class="cl">&nbsp;</div>
        </div>
        <!-- End Main -->
        <!-- Footer -->
        <div id="footer" class="shell">
            <div class="top">
                <div class="cnt">
                    <div class="col about">
                        <h4>About CB BookStore</h4>
                        <p align="justify">Welcome to CB BookStore, the world's leading specialist online bookstore. We're proud to offer over 12 million titles, all at unbeatable prices with free delivery worldwide to over 100 countries. Whatever your interest or passion, you'll find something interesting in our bookshop full of delights.  </p>
                        <p align="justify">CB BookStore is the fastest growing bookseller in Europe, shipping to thousands of customers every day throughout the world from our fulfilment centre in Gloucester, United Kingdom. We have over a million customers and a reputation for extremely high service levels. </p>
                    </div>
                    <div class="col store">
                        <h4>Store</h4>
                        <ul>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Special Offers</a></li>
                            <li><a href="login">Log In</a></li>
                            <li><a href="#">Account</a></li>
                            <li><a href="#">Basket</a></li>
                            <li><a href="#">Checkout</a></li>
                        </ul>
                    </div>
                    <div class="col" id="newsletter">
                        <h4>Newsletter</h4>
                        <p>Enter Your Details for news: </p>
                        <form action="" method="post">
                            <input type="text" class="field" value="Your Name" title="Your Name" />
                            <input type="text" class="field" value="Email" title="Email" />
                            <div class="form-buttons"><input type="submit" value="Submit" class="submit-btn" /></div>
                        </form>
                    </div>
                    <div class="cl">&nbsp;</div>
                    <div class="copy">
                        <p>&copy; <a href="#">CBBookStore.com</a>. Design by CB</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Footer -->
    </body>
</html>