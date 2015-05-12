<%-- 
    Document   : home
    Created on : May 9, 2015, 10:01:10 PM
    Author     : Cipri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CB Paint | Home</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/paint.css"/>">
    </head>
    <body>
        <div id="content" >
            <span id="tools">
                <button  id="brush">Brush</button>
                <button  id="circle" >Circle</button>
                <button  id="line">Line</button>
                <button  id="rectangle">Rectangle</button>
                <button  id="ellipse">Ellipse</button>   
                <button  id="spray">Spray</button>
                <button  id="eraser">  Eraser</button>
            </span>

            <label for="drawing_color">Line color:</label>
            <input id="drawing_color" type="color" value="#000000">

            <span id="mode">
                <button  id="draw">Draw</button>
                <button  id="select" >Select</button>
            </span>


            <div id="sketch">
                <canvas  id="paint"></canvas>
            </div>

            <div id="functions">
                <canvas id="brush_size" width="50" height="50"></canvas>
                Brush Size<input id="width_range" type="range" min="1" max="51" step="5" value="1">
                <button  id="undo">Undo</button> 
                <button  id="redo">Redo</button>
                <button  id="id_download">Download</button> 
                <button  id="clear">Clear</button>
            </div>  

        </div>


        <script src="<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/paint.js"/>"></script>
    </body>
</html>
