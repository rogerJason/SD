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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CB Paint | Home</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/scripts/bootstrap/css/bootstrap.min.css"/>">
        <!-- Custom styles for this page -->
        <link rel="stylesheet" href="<c:url value="/resources/css/paint.css"/>">
    </head>
    <body>
        <div class="container"> 
            <div class="row">
                <div class="col-md-12">
                    <span id="tools">
                        <button id="brush" class="btn btn-primary"><span title="Brush" class="glyphicon glyphicon-pencil"></span></button>
                        <button id="circle" class="btn btn-success"><span title="Circle" class="glyphicon glyphicon-dashboard"></span></button>
                        <button id="rectangle" class="btn btn-info"><span title="Rectangle" class="glyphicon glyphicon-stop"></span></button>
                        <button id="line" class="btn btn-warning"><span title="Line" class="glyphicon glyphicon-option-vertical"></span></button>               
                        <button id="ellipse" class="btn btn-danger"><span title="Ellipse" class="glyphicon glyphicon-eye-open"></span></button>  
                        <button id="spray" class="btn btn-primary"><span title="Spray" class="glyphicon glyphicon-certificate"></span></button>
                        <button id="eraser" class="btn btn-success"><span title="Eraser" class="glyphicon glyphicon-erase"></span></button>
                    </span>

                    <label for="drawing_color">Line color:</label>
                    <input id="drawing_color" type="color" value="#000000">

                    <span id="mode">
                        <button id="draw" class="btn btn-info"><span title="Draw" class="glyphicon glyphicon-edit"></span></button>
                        <button id="select" class="btn btn-warning"><span title="Select" class="glyphicon glyphicon-hand-up "></span></button>
                    </span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <canvas id="canvas" width="1200" height="500"  style="border: 2px solid black">
                        Sorry, your browser doesn't support the &lt;canvas&gt; element.
                    </canvas>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    Brush Size<input id="width_range" type="range" min="1" max="51" step="5" value="1">
                    <button id="undo">Undo</button> 
                    <button id="redo">Redo</button>
                    <a href="#" id="download" download="image.png">Download Image</a> 
                    <button id="clear">Clear</button>
                    <a href="#" id="save" download="data.json">Save Canvas</a>
                    Load Canvas<input type="file" id="load" />
                </div>
            </div>
        </div>


        <script src="<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/paint.js"/>"></script>
    </body>
</html>
