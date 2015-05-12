$.getScript("resources/scripts/fabric.min.js", function () {

    // Obtain a canvas drawing surface from fabric.js
    var canvas = new fabric.Canvas('paint');

    // Set the height and width of the canvas from CSS
    var sketch = document.querySelector('#sketch');
    var sketch_style = getComputedStyle(sketch);
    canvas.setWidth(parseInt(sketch_style.getPropertyValue('width')));
    canvas.setHeight(parseInt(sketch_style.getPropertyValue('height')));
    
    var drawingModeEl = $('#mode button');

    // ---------------------------------- SELECTING THE MODE FOR DRAWING ---------------------------------
    // current mode
    var mode = 'draw';
    canvas.isDrawingMode = true;

    drawingModeEl.on('click', function () {
        mode = $(this).attr('id');
        console.log(mode);  // it is used for debugging, press F12 in Chrome and select Console
        if (mode === 'draw')
        {
            canvas.isDrawingMode = true;
        }
        else if (mode === 'select')
        {
            canvas.isDrawingMode = false;
        }
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- SELECTING THE CURRENT TOOL FOR DRAWING ---------------------------------
    // current tool
    var tool = 'brush';

    $('#tools button').on('click', function () {
        tool = $(this).attr('id');
        console.log(tool);  // it is used for debugging, press F12 in Chrome and select Console
    });
    // -----------------------------------------------------------------------------------------------------------

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

    // ---------------------------------- CLEAR THE CANVAS ----------------------------------------------
    document.getElementById("clear").addEventListener("click", function () {
        if (confirm("Do you really want to CLEAR the canvas?")) {
            canvas.clear();
        }
    });
    // -----------------------------------------------------------------------------------------------------------

    var mouse = {x: 0, y: 0};
    var start_mouse = {x: 0, y: 0}; // used for saving the starting coordinates for drawing the line
    var last_mouse = {x: 0, y: 0};


    // Create a text object. 
    // Does not display it-the canvas doesn't 
    // know about it yet.
    var hi = new fabric.Text('TYLER THE CREATOR', {
        left: canvas.getWidth() / 4,
        top: canvas.getHeight() / 4
    });

    // Attach it to the canvas object, then (re)display
    // the canvas.	
    canvas.add(hi);

    canvas.renderAll();
    canvas.calcOffset();    // recalculate all the objects positions

});