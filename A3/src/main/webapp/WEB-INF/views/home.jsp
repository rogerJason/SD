<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>CB Clinic :: Homepage</title>
        <meta name="description" content="">
        <meta name="author" content="CB">
        <link rel="stylesheet" href="<c:url value="/resources/scripts/bootstrap/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/isotope.css"/>">
        <link rel="stylesheet" media="screen" href="<c:url value="/resources/scripts/js/fancybox/jquery.fancybox.css"/>" type="text/css">
        <link rel="stylesheet" media="screen" href="<c:url value="/resources/css/animate.css"/>">
        <!-- Owl Carousel Assets -->
        <link rel="stylesheet" href="<c:url value="/resources/scripts/js/owl-carousel/owl.carousel.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="<c:url value="/resources/font/css/font-awesome.min.css"/>">
    </head>

    <body>
        <header class="header">
            <div class="container">
                <nav class="navbar navbar-inverse" role="navigation">
                    <div class="navbar-header">
                        <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                        <a href="#" class="navbar-brand scroll-top logo  animated bounceInLeft"><b><i></i>CB Clinic</b></a> </div>
                    <!--/.navbar-header-->
                    <div id="main-nav" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav" id="mainNav">
                            <li class="active" id="firstLink"><a href="#home" class="scroll-link">Home</a></li>
                            <li><a href="#services" class="scroll-link">Services</a></li>
                            <li><a href="#aboutUs" class="scroll-link">About Us</a></li>
                            <li><a href="#work" class="scroll-link">Portfolio</a></li>
                            <li><a href="#team" class="scroll-link">Team</a></li>
                            <li><a href="#login" class="scroll-link">Login</a></li>
                        </ul>
                    </div>
                    <!--/.navbar-collapse--> 
                </nav>
                <!--/.navbar--> 
            </div>
            <!--/.container--> 
        </header>
        <!--/.header-->
        <div id="#top"></div>
        <section id="home">   
            <div class="banner-container"> <img src="<c:url value="/resources/images/banner-bg.jpg"/>" alt="banner" />
                <div class="container banner-content">
                    <div class="hero-text animated fadeInDownBig">
                        <h1 class="responsive-headline" style="font-size: 40px;">Belief in recovery always</h1>
                        <a href="#basics" class="arrow-link"> <i class="fa fa-arrow-circle-down fa-2x"><!--  Some content --></i> </a> 
                    </div>
                </div>
            </div>
        </section>
        <section id="services" class="page-section colord">
            <div class="container">
                <div class="heading text-center"> 
                    <!-- Heading -->
                    <h2>Our Services</h2>
                    <p>Our mission is to greet every patient with care, to make sure that he is investigated and diagnosed correctly.</p>
                </div>
                <div class="row"> 
                    <!-- item -->
                    <div class="col-md-3 text-center c1"> <i class="fa fa-life-ring fa-2x circle"><!--  Some content --></i>
                        <h3><span class="id-color">Cardio Monitoring</span></h3>
                        <p>The phrase cardiac monitoring generally refers to continuous monitoring of the heart activity.</p>
                    </div>
                    <!-- end: --> 

                    <!-- item -->
                    <div class="col-md-3 text-center c2"> <i class="fa fa-plus-square fa-2x circle"><!--  Some content --></i>
                        <h3><span class="id-color">Medical Treatment</span></h3>
                        <p>The attempted remediation of a health problem, usually following a diagnosis.</p>
                    </div>
                    <!-- end: --> 

                    <!-- item -->
                    <div class="col-md-3 text-center c1"> <i class="fa fa-female fa-2x circle"><!--  Some content --></i>
                        <h3><span class="id-color">Women Care Help</span></h3>
                        <p>Working with communities hit by natural disasters and war, CARE helps keep women safe.</p>
                    </div>
                    <!-- end: --> 

                    <!-- item -->
                    <div class="col-md-3 text-center c2"> <i class="fa fa-child fa-2x circle"><!--  Some content --></i>
                        <h3><span class="id-color">Child Care</span></h3>
                        <p>Your gift will help women in your community choose life for their babies.</p>
                    </div>
                    <!-- end:--> 
                </div>
            </div>
            <!--/.container--> 
        </section>
        <section id="aboutUs">
            <div class="container">
                <div class="heading text-center"> 
                    <!-- Heading -->
                    <h2>About Us</h2>
                    <p>At CB Clinic, we offer clinical and paraclinical integrated medical services.</p>
                </div>
                <div class="row feature design">
                    <div class="six columns right">
                        <h3>Clean and Modern Clinic.</h3>
                        <p>Our mission is to greet every patient with care, to make sure that he is investigated and 
                            diagnosed correctly, that he is treated completely, in due time, with professionalism and with respect. </p>
                        <p>Shortly, we wish to offer quality medical services. We believe that medicine without the help 
                            of technique cannot be imagined, but that, without humaneness and respect for the moral values, it remains just a job. </p>
                    </div>
                    <div class="six columns feature-media left"> <img src="<c:url value="/resources/images/feature-img-1.png"/>" alt=""> </div>     
                </div>
            </div>
        </section>
        <section id="work" class="page-section page">
            <div class="container text-center">
                <div class="heading">
                    <h2>Our Facilities</h2>
                    <p>Founded and managed by four Romanian doctors, represents the materialization of their vision and experience.</p>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div id="portfolio">
                            <ul class="items list-unstyled clearfix animated fadeInRight showing" data-animation="fadeInRight" style="position: relative; height: 438px;">
                                <li class="item branding" style="position: absolute; left: 0px; top: 0px;"> <a href="<c:url value="/resources/images/work/1.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/1.jpg"/>" alt="">
                                        <div class="overlay"> <span>Clinic</span> </div>
                                    </a> </li>
                                <li class="item photography" style="position: absolute; left: 292px; top: 0px;"> <a href="<c:url value="/resources/images/work/2.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/2.jpg"/>" alt="">
                                        <div class="overlay"> <span>Patient</span> </div>
                                    </a> </li>
                                <li class="item branding" style="position: absolute; left: 585px; top: 0px;"> <a href="<c:url value="/resources/images/work/3.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/3.jpg"/>" alt="">
                                        <div class="overlay"> <span>Medical</span> </div>
                                    </a> </li>
                                <li class="item photography" style="position: absolute; left: 877px; top: 0px;"> <a href="<c:url value="/resources/images/work/4.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/4.jpg"/>" alt="">
                                        <div class="overlay"> <span>Healthcare</span> </div>
                                    </a> </li>
                                <li class="item photography" style="position: absolute; left: 0px; top: 219px;"> <a href="<c:url value="/resources/images/work/5.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/5.jpg"/>" alt="">
                                        <div class="overlay"> <span>Safe</span> </div>
                                    </a> </li>
                                <li class="item web" style="position: absolute; left: 292px; top: 219px;"> <a href="<c:url value="/resources/images/work/6.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/6.jpg"/>" alt="">
                                        <div class="overlay"> <span>Clean</span> </div>
                                    </a> </li>
                                <li class="item photography" style="position: absolute; left: 585px; top: 219px;"> <a href="<c:url value="/resources/images/work/7.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/7.jpg"/>" alt="">
                                        <div class="overlay"> <span>Heart</span> </div>
                                    </a> </li>
                                <li class="item web" style="position: absolute; left: 877px; top: 219px;"> <a href="<c:url value="/resources/images/work/8.jpg"/>" class="fancybox"> <img src="<c:url value="/resources/images/work/8.jpg"/>" alt="">
                                        <div class="overlay"> <span>Patient</span> </div>
                                    </a> </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="team" class="page-section">
            <div class="container">
                <div class="heading text-center"> 
                    <!-- Heading -->
                    <h2>Our Team</h2>
                    <p>Starting from the principle "the patient has the right to be treated completely and correctly"</p>
                </div>
                <!-- Team Member's Details -->
                <div class="team-content">
                    <div class="row">
                        <div class="col-md-3 col-sm-6 col-xs-6"> 
                            <!-- Team Member -->
                            <div class="team-member pDark"> 
                                <!-- Image Hover Block -->
                                <div class="member-img"> 
                                    <!-- Image  --> 
                                    <img class="img-responsive" src="<c:url value="/resources/images/photo-1.jpg"/>" alt=""> </div>
                                <!-- Member Details -->
                                <h4>John Doe</h4>
                                <!-- Designation --> 
                                <span class="pos">CEO</span> </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-6"> 
                            <!-- Team Member -->
                            <div class="team-member pDark"> 
                                <!-- Image Hover Block -->
                                <div class="member-img"> 
                                    <!-- Image  --> 
                                    <img class="img-responsive" src="<c:url value="/resources/images/photo-2.jpg"/>" alt=""> </div>
                                <!-- Member Details -->
                                <h4>Larry Doe</h4>
                                <!-- Designation --> 
                                <span class="pos">Art Director</span> </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-6"> 
                            <!-- Team Member -->
                            <div class="team-member pDark"> 
                                <!-- Image Hover Block -->
                                <div class="member-img"> 
                                    <!-- Image  --> 
                                    <img class="img-responsive" src="<c:url value="/resources/images/photo-3.jpg"/>" alt=""> </div>
                                <!-- Member Details -->
                                <h4>Ranith Kays</h4>
                                <!-- Designation --> 
                                <span class="pos">Manager</span> </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-6"> 
                            <!-- Team Member -->
                            <div class="team-member pDark"> 
                                <!-- Image Hover Block -->
                                <div class="member-img"> 
                                    <!-- Image  --> 
                                    <img class="img-responsive" src="<c:url value="/resources/images/photo-4.jpg"/>" alt=""> </div>
                                <!-- Member Details -->
                                <h4>Joan Ray</h4>
                                <!-- Designation --> 
                                <span class="pos">Creative</span> </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/.container--> 
        </section>
        <section id="login" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row">
                        <div class="heading text-center"> 
                            <!-- Heading -->
                            <h2>Login</h2>
                            <p>Please enter your username and password.</p>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <div class="col-sm-8">
                            <form method="post" action="${pageContext.request.contextPath}/login" id="contactfrm" role="form">                        
                                <div class="form-group">
                                    <label for="username">Name</label>
                                    <input type="text" class="form-control" name="username" id="username" placeholder="Enter name" title="Please enter your name (at least 2 characters)">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" title="Please enter a valid password">
                                    <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">Submit</button>
                                </div>
                            </form>
                            <c:if test="${'fail' eq param.auth}">
                                <p>
                                <div class="alert alert-danger">Login Failed!!! Reason :
                                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
                            </c:if>
                        </div>                     
                        <div class="col-sm-4">
                            <h4>Address:</h4>
                            <address>
                                CB Clinic<br>
                                Prieteniei Street, 543410<br>
                                Targu Mures, Mures County<br>
                            </address>
                            <h4>Phone:</h4>
                            <address>
                                0265 934 122<br>
                            </address>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="social text-center"> <a href="#"><i class="fa fa-twitter"><!--  Some content --></i></a> <a href="#"><i class="fa fa-facebook"><!--  Some content --></i></a> <a href="#"><i class="fa fa-dribbble"><!--  Some content --></i></a> <a href="#"><i class="fa fa-flickr"><!--  Some content --></i></a> <a href="#"><i class="fa fa-github"><!--  Some content --></i></a> </div>
                    <!--CLEAR FLOATS--> 
                </div>
                <!--/.container--> 
            </div>
        </section>
        <!--/.page-section-->
        <section class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 text-center"> Copyright 2015 | All Rights Reserved -- by <a href="#">CB</a> </div>
                </div>
                <!-- / .row --> 
            </div>
        </section>
        <a href="#top" class="topHome"><i class="fa fa-chevron-up fa-2x"><!--  Some content --></i></a> 

        <script src="<c:url value="/resources/scripts/js/modernizr-latest.js"/>"></script> 
        <script src="<c:url value="/resources/scripts/js/jquery-1.8.2.min.js"/>" type="text/javascript"></script>  
        <script src="<c:url value="/resources/scripts/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/js/jquery.isotope.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/fancybox/jquery.fancybox.pack.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/jquery.nav.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/scripts/js/jquery.fittext.js"/>"></script> 
        <script src="<c:url value="/resources/scripts/js/waypoints.js"/>"></script> 
        <script src="<c:url value="/resources/scripts/js/custom.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/js/owl-carousel/owl.carousel.js"/>"></script>
    </body>
</html>
