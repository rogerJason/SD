<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>CB Bank | Home Page</title>
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
                                <li><a href="#">About</a></li>
                                <li><a href="#">Links</a></li>
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
                            <div class="post">
                                <h2 class="title"><a href="#">Lorem ipsum sed aliquam</a></h2>
                                <p class="meta">Posted by <a href="#">Someone</a> on March 8, 2010
                                    &nbsp;&bull;&nbsp; <a href="#" class="comments">Comments (64)</a> &nbsp;&bull;&nbsp; <a href="#" class="permalink">Full article</a></p>
                                <div class="entry">
                                    <p><img src="images/img06.jpg" width="143" height="143" alt="" class="alignleft border" />Sed lacus. Donec lectus. Nullam pretium nibh ut turpis. Nam bibendum. In nulla tortor, elementum vel, tempor at, varius non, purus. Mauris vitae nisl nec metus placerat consectetuer. Donec ipsum. Proin imperdiet est. Phasellus <a href="#">dapibus semper urna</a>. Pellentesque ornare, consectetuer nisl felis ac diam.</p>
                                </div>
                            </div>
                            <div class="post">
                                <h2 class="title"><a href="#">Phasellus pellentesque turpis </a></h2>
                                <p class="meta">Posted by <a href="#">Someone</a> on March 8, 2010
                                    &nbsp;&bull;&nbsp; <a href="#" class="comments">Comments (64)</a> &nbsp;&bull;&nbsp; <a href="#" class="permalink">Full article</a></p>
                                <div class="entry">
                                    <p><img src="images/img05.jpg" width="143" height="143" alt="" class="alignleft border" />Sed lacus. Donec lectus. Nullam pretium nibh ut turpis. Nam bibendum. In nulla tortor, elementum vel, tempor at, varius non, purus. Mauris vitae nisl nec metus placerat consectetuer. Donec ipsum. Proin imperdiet est. Pellentesque ornare, orci in consectetuer hendrerit, urna elit eleifend nunc.</p>
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>
                        <!-- end #content -->
                        <div id="sidebar">
                            <ul>
                                <li>
                                    <h2>Aliquam tempus</h2>
                                    <p>Mauris vitae nisl nec metus placerat perdiet est. Phasellus dapibus semper consectetuer hendrerit.</p>
                                </li>
                                <li>
                                    <h2>Categories</h2>
                                    <ul>
                                        <li><a href="#">Aliquam libero</a></li>
                                        <li><a href="#">Consectetuer adipiscing elit</a></li>
                                        <li><a href="#">Metus aliquam pellentesque</a></li>
                                        <li><a href="#">Suspendisse iaculis mauris</a></li>
                                        <li><a href="#">Urnanet non molestie semper</a></li>
                                        <li><a href="#">Proin gravida orci porttitor</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <h2>Blogroll</h2>
                                    <ul>
                                        <li><a href="#">Aliquam libero</a></li>
                                        <li><a href="#">Consectetuer adipiscing elit</a></li>
                                        <li><a href="#">Metus aliquam pellentesque</a></li>
                                        <li><a href="#">Suspendisse iaculis mauris</a></li>
                                        <li><a href="#">Urnanet non molestie semper</a></li>
                                        <li><a href="#">Proin gravida orci porttitor</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <h2>Archives</h2>
                                    <ul>
                                        <li><a href="#">Aliquam libero</a></li>
                                        <li><a href="#">Consectetuer adipiscing elit</a></li>
                                        <li><a href="#">Metus aliquam pellentesque</a></li>
                                        <li><a href="#">Suspendisse iaculis mauris</a></li>
                                        <li><a href="#">Urnanet non molestie semper</a></li>
                                        <li><a href="#">Proin gravida orci porttitor</a></li>
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
