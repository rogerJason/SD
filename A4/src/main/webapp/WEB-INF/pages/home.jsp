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

            <span id="colors" >	
                <button  class="black" id="#000000"> </button>
                <button  class="white" id = '#FFFFFF'> </button>
                <button  class="blue" id = '#0000FF'> </button>
                <button  class="red" id = '#FF0000'> </button>
                <button  class="yellow" id = '#FFFF00'> </button>
                <button  class="green" id = '#008000'> </button>
                <button  class="purple" id = '#800080'> </button>
                
                <input type="hidden" id="color_value_form">	
            </span>

            <div id="sketch">
                <canvas  id="paint"></canvas>
            </div>

            <div id="functions">
                <canvas id="brush_size" width="50" height="50"></canvas>
                Brush Size<input type="range"  id="width_range" value="10">
                Opacity  <input type="range"  id="opacity_range" value="100">
                <button  id="undo">Undo</button> 
                <button  id="redo">Redo</button>
                <button  id="id_download">Download</button> 
                <button  id="clear">Clear All</button>
            </div>  
            
        </div>


        <script src="<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/scripts/paint.js"/>"></script>
    </body>
</html>
