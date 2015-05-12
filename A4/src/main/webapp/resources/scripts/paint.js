/* global fabric */

$.getScript("resources/scripts/fabric.min.js", function () {

    // Obtain a canvas drawing surface from fabric.js
    var canvas = new fabric.Canvas('paint');

    //fabric.Object.prototype.selectable = false;

    // Set the height and width of the canvas from CSS
    var sketch = document.querySelector('#sketch');
    var sketch_style = getComputedStyle(sketch);
    canvas.setWidth(parseInt(sketch_style.getPropertyValue('width')));
    canvas.setHeight(parseInt(sketch_style.getPropertyValue('height')));

    var mouse = {x: 0, y: 0};
    var start_mouse = {x: 0, y: 0}; // used for saving the starting coordinates for drawing the line
    
    // ---------------------------------- SELECTING THE MODE FOR DRAWING ---------------------------------
    // current mode
    var mode = 'draw';

    $('#mode button').on('click', function () {
        mode = $(this).attr('id');
        if (mode === 'draw')
        {
            fabric.Object.prototype.selectable = false;
            if (tool === 'brush') canvas.isDrawingMode = true;
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

        // ---------------------------------- SELECTING THE CURRENT COLOR FOR DRAWING ---------------------------------

        document.getElementById("drawing_color").addEventListener("change", function () {
            canvas.freeDrawingBrush.color = document.getElementById("drawing_color").value;
        });
        // -----------------------------------------------------------------------------------------------------------

        // ---------------------------------- SELECTING THE LINE WIDTH FOR DRAWING ---------------------------------
        document.getElementById("width_range").addEventListener("change", function () {
            canvas.freeDrawingBrush.width = parseInt(document.getElementById("width_range").value);
        });
        // -----------------------------------------------------------------------------------------------------------

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
            fill: 'red',
            width: width,
            height: height
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
            radius: radius, fill: 'green', left: x, top: y
        });
        canvas.add(circle);
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
            else if (tool === 'ellipse')
            {
                drawEllipse(tmp_ctx);
            }
            else if (tool === 'eraser')
            {
                onErase();
            }
            else if (tool === 'spray')
            {
                generateSprayParticles();
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


});