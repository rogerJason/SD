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
                <div class="col-md-4">
                    <span id="tools">
                        <button id="brush" class="btn btn-primary"><span title="Brush" class="glyphicon glyphicon-pencil"></span></button>
                        <button id="circle" class="btn btn-success"><span title="Circle" class="glyphicon glyphicon-dashboard"></span></button>
                        <button id="rectangle" class="btn btn-info"><span title="Rectangle" class="glyphicon glyphicon-stop"></span></button>
                        <button id="line" class="btn btn-warning"><span title="Line" class="glyphicon glyphicon-option-vertical"></span></button>               
                        <button id="ellipse" class="btn btn-danger"><span title="Ellipse" class="glyphicon glyphicon-eye-open"></span></button>  
                        <button id="spray" class="btn btn-primary"><span title="Spray" class="glyphicon glyphicon-certificate"></span></button>
                        <button id="eraser" class="btn btn-success"><span title="Eraser" class="glyphicon glyphicon-erase"></span></button>
                    </span>
                </div>
                <div class="col-md-3">
                    <button class="btn btn-primary btn-block active"><span title="CB" class="glyphicon glyphicon-camera"></span> CB Paint Application</button>
                </div>
                <div class="col-md-3">
                    <span id="mode">
                        <button id="draw" class="btn btn-info"><span title="Draw" class="glyphicon glyphicon-edit"></span></button>
                        <button id="select" class="btn btn-warning"><span title="Select" class="glyphicon glyphicon-hand-up "></span></button>
                        <button id="clear" class="btn btn-danger"><span title="Clear" class="glyphicon glyphicon-remove"></span></button>
                        <a href="#" id="download" download="image.png"><button id="download" class="btn btn-primary"><span title="Download Image" class="glyphicon glyphicon-download-alt"></span></button></a>
                        <a href="#" id="save" download="data.json"><button id="save" class="btn btn-success"><span title="Save Canvas" class="glyphicon glyphicon-picture"></span></button></a>                    
                    </span>
                </div>
                <div class="col-md-2">
                <input type="file" id="load" title="Load Canvas"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <canvas id="canvas" width="1200" height="520"  style="border: 2px solid black">
                        Sorry, your browser doesn't support the &lt;canvas&gt; element.
                    </canvas>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <label for="drawing_color"><p class="text-primary">Line color:</p></label>
                    <input id="drawing_color" type="color" value="#000000">
                </div>
                <div class="col-md-2">
                    <label for="width_range"><p class="text-success">Brush Size</p></label>
                    <input id="width_range" type="range" min="1" max="51" step="5" value="1">
                </div>
                <div class="col-md-6">      
                    
                </div>
                <div class="col-md-2">                    
                    <button id="undo" class="btn btn-warning"><span title="Undo" class="glyphicon glyphicon-arrow-left"></span></button> 
                    <button id="redo" class="btn btn-info"><span title="Redo" class="glyphicon glyphicon-arrow-right"></span></button>                    
                    
                </div>
            </div>
        </div>


        <script src="<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/paint.js"/>"></script>
    </body>
</html>
