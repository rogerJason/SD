(function () {
    var canvas = document.querySelector('#paint');
    var ctx = canvas.getContext('2d');

    var sketch = document.querySelector('#sketch');
    var sketch_style = getComputedStyle(sketch);
    canvas.width = parseInt(sketch_style.getPropertyValue('width'));
    canvas.height = parseInt(sketch_style.getPropertyValue('height'));

    // Creating a tmp canvas
    var tmp_canvas = document.createElement('canvas');
    var tmp_ctx = tmp_canvas.getContext('2d');
    tmp_canvas.id = 'tmp_canvas';
    tmp_canvas.width = canvas.width;
    tmp_canvas.height = canvas.height;

    sketch.appendChild(tmp_canvas);

    var mouse = {x: 0, y: 0};
    var start_mouse = {x: 0, y: 0}; // used for saving the starting coordinates for drawing the line
    var last_mouse = {x: 0, y: 0};

    // Pencil Points - used for drawing smoother curved lines
    var ppts = [];

    // ---------------------------------- SELECTING THE CURRENT TOOL FOR DRAWING ---------------------------------
    // current tool
    var tool = 'brush';

    $('#tools button').on('click', function () {
        tool = $(this).attr('id');
        console.log(tool);  // it is used for debugging, press F12 in Chrome and select Console
    });
    // -----------------------------------------------------------------------------------------------------------

    // ---------------------------------- SELECTING THE CURRENT COLOR FOR DRAWING ---------------------------------
    $('#colors button').on('click', function () {
        tmp_ctx.strokeStyle = $(this).attr('id');
        tmp_ctx.fillStyle = tmp_ctx.strokeStyle;
        console.log(tmp_ctx.strokeStyle);
    });
    // -----------------------------------------------------------------------------------------------------------

    /* Mouse Capturing Work */
    tmp_canvas.addEventListener('mousemove', function (e) {
        mouse.x = typeof e.offsetX !== 'undefined' ? e.offsetX : e.layerX;
        mouse.y = typeof e.offsetY !== 'undefined' ? e.offsetY : e.layerY;
    }, false);


    /* Drawing on Paint App */
    tmp_ctx.lineWidth = 5;
    tmp_ctx.lineJoin = 'round';
    tmp_ctx.lineCap = 'round';
    tmp_ctx.strokeStyle = 'blue';
    tmp_ctx.fillStyle = 'blue';

    tmp_canvas.addEventListener('mousedown', function (e) {
        tmp_canvas.addEventListener('mousemove', onPaint, false);

        // we use e.offsetX (chrome, opera) or e.layerX (firefox) to capture the mouse coordinates relative to the canvas
        mouse.x = typeof e.offsetX !== 'undefined' ? e.offsetX : e.layerX;
        mouse.y = typeof e.offsetY !== 'undefined' ? e.offsetY : e.layerY;

        // save the start x/y positions of the mouse to know where to start drawing the line
        start_mouse.x = mouse.x;
        start_mouse.y = mouse.y;

        ppts.push({x: mouse.x, y: mouse.y});

        onPaint();
    }, false);

    tmp_canvas.addEventListener('mouseup', function () {
        tmp_canvas.removeEventListener('mousemove', onPaint, false);

        // for erasing, else after erasing won't draw anything
        ctx.globalCompositeOperation = 'source-over';

        // Writing down to real canvas now
        ctx.drawImage(tmp_canvas, 0, 0);
        // Clearing tmp canvas
        tmp_ctx.clearRect(0, 0, tmp_canvas.width, tmp_canvas.height);

        // Emptying up Pencil Points
        ppts = [];
    }, false);

    var onPaintBrush = function () {

        // Saving all the points in an array
        ppts.push({x: mouse.x, y: mouse.y});

        if (ppts.length < 3) {
            var b = ppts[0];
            tmp_ctx.beginPath();
            tmp_ctx.arc(b.x, b.y, tmp_ctx.lineWidth / 2, 0, Math.PI * 2, !0);
            tmp_ctx.fill();
            tmp_ctx.closePath();

            return;
        }

        // Tmp canvas is always cleared up before drawing.
        tmp_ctx.clearRect(0, 0, tmp_canvas.width, tmp_canvas.height);

        tmp_ctx.beginPath();
        tmp_ctx.moveTo(ppts[0].x, ppts[0].y);

        for (var i = 1; i < ppts.length - 2; i++) {
            var c = (ppts[i].x + ppts[i + 1].x) / 2;
            var d = (ppts[i].y + ppts[i + 1].y) / 2;

            tmp_ctx.quadraticCurveTo(ppts[i].x, ppts[i].y, c, d);
        }

        // For the last 2 points
        tmp_ctx.quadraticCurveTo(
                ppts[i].x,
                ppts[i].y,
                ppts[i + 1].x,
                ppts[i + 1].y
                );
        tmp_ctx.stroke();

    };

    var onPaintLine = function () {

        // Tmp canvas is always cleared up before drawing.
        tmp_ctx.clearRect(0, 0, tmp_canvas.width, tmp_canvas.height);

        tmp_ctx.beginPath();
        tmp_ctx.moveTo(start_mouse.x, start_mouse.y);
        tmp_ctx.lineTo(mouse.x, mouse.y);
        tmp_ctx.stroke();
        tmp_ctx.closePath();
    };

    var onPaintRect = function () {

        // Tmp canvas is always cleared up before drawing.
        tmp_ctx.clearRect(0, 0, tmp_canvas.width, tmp_canvas.height);

        var x = Math.min(mouse.x, start_mouse.x);
        var y = Math.min(mouse.y, start_mouse.y);
        var width = Math.abs(mouse.x - start_mouse.x);
        var height = Math.abs(mouse.y - start_mouse.y);
        tmp_ctx.strokeRect(x, y, width, height);
    };

    var onPaintCircle = function () {

        // Tmp canvas is always cleared up before drawing.
        tmp_ctx.clearRect(0, 0, tmp_canvas.width, tmp_canvas.height);

        var x = (mouse.x + start_mouse.x) / 2;
        var y = (mouse.y + start_mouse.y) / 2;

        var radius = Math.max(
                Math.abs(mouse.x - start_mouse.x),
                Math.abs(mouse.y - start_mouse.y)
                ) / 2;

        tmp_ctx.beginPath();
        tmp_ctx.arc(x, y, radius, 0, Math.PI * 2, false);
        tmp_ctx.stroke();
        tmp_ctx.closePath();
    };

    var onPaintEllipse = function () {

        tmp_ctx.clearRect(0, 0, tmp_canvas.width, tmp_canvas.height);

        var x = Math.min(mouse.x, start_mouse.x);
        var y = Math.min(mouse.y, start_mouse.y);

        var w = Math.abs(mouse.x - start_mouse.x);
        var h = Math.abs(mouse.y - start_mouse.y);

        var kappa = .5522848;
        ox = (w / 2) * kappa, // control point offset horizontal
                oy = (h / 2) * kappa, // control point offset vertical
                xe = x + w, // x-end
                ye = y + h, // y-end
                xm = x + w / 2, // x-middle
                ym = y + h / 2;       // y-middle

        tmp_ctx.beginPath();
        tmp_ctx.moveTo(x, ym);
        tmp_ctx.bezierCurveTo(x, ym - oy, xm - ox, y, xm, y);
        tmp_ctx.bezierCurveTo(xm + ox, y, xe, ym - oy, xe, ym);
        tmp_ctx.bezierCurveTo(xe, ym + oy, xm + ox, ye, xm, ye);
        tmp_ctx.bezierCurveTo(xm - ox, ye, x, ym + oy, x, ym);
        tmp_ctx.closePath();
        tmp_ctx.stroke();
    };

    var onErase = function () {

        // Saving all the points in an array
        ppts.push({x: mouse.x, y: mouse.y});

        /* Basically, when using this operation, anything that we draw on the canvas, 
         makes those portions transparent and you can only see the portions on the canvas 
         that do not overlap with the drawing done after setting this operation */
        ctx.globalCompositeOperation = 'destination-out';
        ctx.fillStyle = 'rgba(0,0,0,1)';
        ctx.strokeStyle = 'rgba(0,0,0,1)';
        ctx.lineWidth = tmp_ctx.lineWidth;

        if (ppts.length < 3) {
            var b = ppts[0];
            ctx.beginPath();
            ctx.arc(b.x, b.y, ctx.lineWidth / 2, 0, Math.PI * 2, !0);
            ctx.fill();
            ctx.closePath();

            return;
        }

        ctx.beginPath();
        ctx.moveTo(ppts[0].x, ppts[0].y);

        for (var i = 1; i < ppts.length - 2; i++) {
            var c = (ppts[i].x + ppts[i + 1].x) / 2;
            var d = (ppts[i].y + ppts[i + 1].y) / 2;

            ctx.quadraticCurveTo(ppts[i].x, ppts[i].y, c, d);
        }

        // For the last 2 points
        ctx.quadraticCurveTo(
                ppts[i].x,
                ppts[i].y,
                ppts[i + 1].x,
                ppts[i + 1].y
                );
        ctx.stroke();
    };

    var onPaint = function () {

        if (tool === 'brush')
        {
            onPaintBrush();
        }
        else if (tool === 'line')
        {
            onPaintLine();
        }
        else if (tool === 'rectangle')
        {
            onPaintRect();
        }
        else if (tool === 'circle')
        {
            onPaintCircle();
        }
        else if (tool === 'ellipse')
        {
            onPaintEllipse();
        }
        else if (tool === 'eraser')
        {
            onErase();
        }

    };



}());
