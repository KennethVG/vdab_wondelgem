// Global variables
let x= 300;
let y= 300;
let timer;

// Animation function
function animation() {
    const layer = document.getElementById("layer");
    if((--x == 0 ) || (--y == 0 )) {
        stopAnimation();
    }
    layer.style.left= x+"px";
    layer.style.top= y+"px";   
}

// Function to start the animation
function startAnimation() {
   const layer = document.getElementById("layer");
   layer.style.visibility="visible";
   layer.style.left= x+"px";
   layer.style.top= y+"px";   
   timer = setInterval(animation,20);
}

// Function to stop the animation
function stopAnimation() {
    clearInterval(timer);
}

//Function to initialize animation
function init() {
    setTimeout(startAnimation,5000);
}

window.addEventListener("load", init);
