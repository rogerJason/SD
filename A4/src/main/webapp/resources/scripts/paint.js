/* global fabric */

$.getScript("resources/scripts/fabric.min.js", function () {

    // Obtain a canvas drawing surface from fabric.js
    var canvas = new fabric.Canvas('canvas');

    var mouse = {x: 0, y: 0};
    var start_mouse = {x: 0, y: 0}; // used for saving the starting coordinates for drawing the line
    var color = '#000000', fillColor = '#FFFFFF', lineWidth = 1;

    // ---------------------------------- SELECTING THE CURRENT COLOR FOR DRAWING ---------------------------------

    document.getElementById("drawing_color").addEventListener("change", function () {
        canvas.freeDrawingBrush.color = document.getElementById("drawing_color").value;
        color = document.getElementById("drawing_color").value;
    });
    
    document.getElementById("fill_color").addEventListener("change", function () {
        fillColor = document.getElementById("fill_color").value;
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- SELECTING THE LINE WIDTH FOR DRAWING ---------------------------------
    document.getElementById("width_range").addEventListener("change", function () {
        canvas.freeDrawingBrush.width = parseInt(document.getElementById("width_range").value);
        lineWidth = parseInt(document.getElementById("width_range").value);
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- SELECTING THE MODE FOR DRAWING ---------------------------------
    // current mode
    var mode = 'draw';

    $('#mode button').on('click', function () {
        mode = $(this).attr('id');
        if (mode === 'draw')
        {
            fabric.Object.prototype.selectable = false;
            if (tool === 'brush')
                canvas.isDrawingMode = true;
        } else {
            fabric.Object.prototype.selectable = true;
            canvas.isDrawingMode = false;
        }
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- SELECTING THE CURRENT TOOL FOR DRAWING ---------------------------------
    // current tool
    var tool = 'brush';
    canvas.isDrawingMode = true;

    $('#tools button').on('click', function () {
        tool = $(this).attr('id');
        if (tool === 'brush' && mode === 'draw')
            canvas.isDrawingMode = true;
        else
            canvas.isDrawingMode = false;
        console.log(tool);  // it is used for debugging, press F12 in Chrome and select Console
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- CLEAR THE CANVAS ----------------------------------------------
    document.getElementById("clear").addEventListener("click", function () {
        if (confirm("Do you really want to CLEAR the canvas?")) {
            canvas.clear();
        }
    });
    // -----------------------------------------------------------------------------------------------------------

    /* Get the mouse coordinates while moving mouse */
    canvas.on('mouse:move', function (options) {
        mouse.x = options.e.offsetX;
        mouse.y = options.e.offsetY;
        //console.log(mouse.x, mouse.y);
    });

    canvas.on('mouse:down', function (options) {

        mouse.x = options.e.offsetX;
        mouse.y = options.e.offsetY;

        // save the start x/y positions of the mouse to know where to start drawing the line
        start_mouse.x = mouse.x;
        start_mouse.y = mouse.y;

    });

    canvas.on('mouse:up', function (options) {
        onPaint();
    });

    var onPaintBrush = function () {

    };

    var onPaintRect = function () {

        var x = Math.min(mouse.x, start_mouse.x);
        var y = Math.min(mouse.y, start_mouse.y);
        var width = Math.abs(mouse.x - start_mouse.x);
        var height = Math.abs(mouse.y - start_mouse.y);
        // create a rectangle object
        var rect = new fabric.Rect({
            left: x,
            top: y,
            fill: fillColor,
            width: width,
            height: height,
            stroke: color, strokeWidth: lineWidth
        });

        // "add" rectangle onto canvas
        canvas.add(rect);
    };

    var onPaintCircle = function () {

        var x = Math.min(mouse.x, start_mouse.x);
        var y = Math.min(mouse.y, start_mouse.y);
        var width = Math.abs(mouse.x - start_mouse.x);
        var height = Math.abs(mouse.y - start_mouse.y);

        var radius = Math.max(
                Math.abs(mouse.x - start_mouse.x),
                Math.abs(mouse.y - start_mouse.y)
                ) / 2;

        var circle = new fabric.Circle({
            radius: radius, fill: fillColor, left: x, top: y, stroke: color, strokeWidth: lineWidth
        });
        canvas.add(circle);
    };

    var onPaintLine = function () {
        canvas.add(new fabric.Line([start_mouse.x, start_mouse.y, mouse.x, mouse.y], {
            //left: 170,
            //top: 150,
            stroke: color, strokeWidth: lineWidth
        }));
    };
    
    var onPaintTriangle = function () {

        var x = Math.min(mouse.x, start_mouse.x);
        var y = Math.min(mouse.y, start_mouse.y);
        var width = Math.abs(mouse.x - start_mouse.x);
        var height = Math.abs(mouse.y - start_mouse.y);
        // create a triangle object
        var triangle = new fabric.Triangle({
            left: x,
            top: y,
            fill: fillColor,
            width: width,
            height: height,
            stroke: color, strokeWidth: lineWidth
        });

        // "add" rectangle onto canvas
        canvas.add(triangle);
    };

    var onPaintText = function () {
        canvas.add(new fabric.IText('Enter Text', {
            fontFamily: 'arial black',
            left: 100,
            top: 100,
            fill: fillColor,
            stroke: color,
            strokeWidth: lineWidth
        }));
    };

    var onPaint = function () {
        if (mode === 'draw')
        {
            if (tool === 'brush')
            {
                onPaintBrush();
            }
            else if (tool === 'circle')
            {
                onPaintCircle();
            }
            else if (tool === 'line')
            {
                onPaintLine();
            }
            else if (tool === 'rectangle')
            {
                onPaintRect();
            }
            else if (tool === 'triangle')
            {
                onPaintTriangle();
            }
            else if (tool === 'text')
            {
                onPaintText();
            }
        }
    };

    // ---------------------------------- JSON DE/SERIALIZATION ----------------------------------------------------
    $("#save").click(function (event) {
        this.href = 'data:plain/text,' + JSON.stringify(canvas);
    });

    $("#load").change(function (event) {
        var fr = new FileReader();
        fr.onload = function () {
            canvas.loadFromJSON(this.result, canvas.renderAll.bind(canvas));
        };
        fr.readAsText(this.files[0]);
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- SAVE CANVAS AS PNG IMAGE --------------------------------------------------
    $("#download").click(function (event) {
        this.href = canvas.toDataURL('png');
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- CLEAR THE CANVAS ----------------------------------------------
    document.getElementById("eraser").addEventListener("click", function () {
        //canvas.remove(canvas.getActiveObject()); // used to remove a single object

        if (canvas.getActiveGroup()) {
            canvas.getActiveGroup().forEachObject(function (o) {
                canvas.remove(o);
            });
            canvas.discardActiveGroup().renderAll();
        } else {
            canvas.remove(canvas.getActiveObject());
        }

    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- UNDO / REDO ----------------------------------------------
    var current;
    var list = [];
    var state = [];
    var index = 0;
    var index2 = 0;
    var action = false;
    var refresh = true;

    canvas.on("object:added", function (e) { //canvas -object of canvas tag
        console.log("OBJECT ADDED");
        var object = e.target;
        if (action === true) {
            state = [state[index2]];
            list = [list[index2]];
            action = false;
            index = 1;
        }
        object.saveState(); //save object
        state[index] = JSON.stringify(object.originalState);
        list[index] = object;
        index++;
        index2 = index - 1;
        refresh = true;
    });

    canvas.on("object:modified", function (e) {
        console.log("OBJECT MODIFIED");
        var object = e.target;
        if (action === true) {
            state = [state[index2]];
            list = [list[index2]];
            action = false;
            index = 1;
        }
        object.saveState();
        state[index] = JSON.stringify(object.originalState);
        list[index] = object;
        index++;
        index2 = index - 1;
        refresh = true;
    });

    document.getElementById("undo").addEventListener("click", function () {
        console.log("UNDO");
        if (index <= 0) {
            index = 0;
            return;
        }

        if (refresh === true) {
            index--;
            refresh = false;
        }

        index2 = index - 1;
        current = list[index2];
        current.setOptions(JSON.parse(state[index2]));
        index--;
        current.setCoords();
        canvas.renderAll();
        action = true;
    });

    document.getElementById("redo").addEventListener("click", function () {
        console.log("REDO");
        action = true;
        if (index >= state.length - 1)
            return;

        index2 = index + 1;
        current = list[index2];
        current.setOptions(JSON.parse(state[index2]));
        index++;
        current.setCoords();
        canvas.renderAll();
    });
    // -----------------------------------------------------------------------------------------------------------

});