/* global fabric */

$.getScript("resources/scripts/fabric.min.js", function () {

    // Obtain a canvas drawing surface from fabric.js
    var canvas = new fabric.Canvas('paint');

    // Set the height and width of the canvas from CSS
    var sketch = document.querySelector('#sketch');
    var sketch_style = getComputedStyle(sketch);
    canvas.setWidth(parseInt(sketch_style.getPropertyValue('width')));
    canvas.setHeight(parseInt(sketch_style.getPropertyValue('height')));

    // ---------------------------------- SELECTING THE CURRENT TOOL FOR DRAWING ---------------------------------
    // current tool
    var tool = 'eraser';

    $('#tools button').on('click', function () {
        tool = $(this).attr('id');
        canvas.isDrawingMode = false;
        canvas.selection = false;
        canvas.off('mouse:down');
        canvas.off('mouse:move');
        canvas.off('mouse:up'); // reset the mouse events
        drawFigure();   // each figure has its own set of mouse events
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

    var drawBrush = function () {
        canvas.isDrawingMode = true;
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

    var drawRect = function () {
        var rect, isDown, origX, origY;

        canvas.on('mouse:down', function (o) {
            isDown = true;
            var pointer = canvas.getPointer(o.e);
            origX = pointer.x;
            origY = pointer.y;
            var pointer = canvas.getPointer(o.e);
            rect = new fabric.Rect({
                left: origX,
                top: origY,
                originX: 'left',
                originY: 'top',
                width: pointer.x - origX,
                height: pointer.y - origY,
                angle: 0,
                fill: 'rgba(255,0,0,0.5)',
                transparentCorners: false
            });
            canvas.add(rect);
        });

        canvas.on('mouse:move', function (o) {
            if (!isDown)
                return;
            var pointer = canvas.getPointer(o.e);

            if (origX > pointer.x) {
                rect.set({left: Math.abs(pointer.x)});
            }
            if (origY > pointer.y) {
                rect.set({top: Math.abs(pointer.y)});
            }

            rect.set({width: Math.abs(origX - pointer.x)});
            rect.set({height: Math.abs(origY - pointer.y)});

            canvas.renderAll();
        });

        canvas.on('mouse:up', function (o) {
            isDown = false;
        });
    };

    var drawFigure = function () {

        if (tool === 'brush')
        {
            drawBrush();
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
            drawRect();
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
    };

});