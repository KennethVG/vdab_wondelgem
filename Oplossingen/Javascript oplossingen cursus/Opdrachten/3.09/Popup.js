function mouseDown(e) {
   const popup = document.getElementById("popup");
   if (e.button == 0) {
     popup.style.visibility = "visible";
     popup.style.left = e.clientX +"px";
     popup.style.top = e.clientY +"px";
   }
}

function init() {
   const area = document.getElementById("area");
   area.addEventListener("mousedown", mouseDown);
}

window.addEventListener("load", init);
