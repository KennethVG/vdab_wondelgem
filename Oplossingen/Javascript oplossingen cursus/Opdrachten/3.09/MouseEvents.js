function mouseMoved(e) {
   this.innerHTML = `Mouse moved: ${e.clientX},${e.clientY}`;
}

function mouseOver(e) {
   this.innerHTML = "Mouse enters area";
}

function mouseOut(e) {
   this.innerHTML = "Mouse leaves area";
}

function mouseDown(e) {
   switch (e.button) {
   case 0:
      this.innerHTML = "Left mouse button down";
      break;
   case 1:
      this.innerHTML = "Middle mouse button down";
      break;
   case 2:
      this.innerHTML = "Right mouse button down";
      break;
   }
}

function mouseUp(e) {
   switch (e.button) {
   case 0:
      this.innerHTML = "Left mouse button up";
      break;
   case 1:
      this.innerHTML = "Middle mouse button up";
      break;
   case 2:
      this.innerHTML = "Right mouse button up";
      break;
   }
}

function init() {
   const area = document.getElementById("area");
   area.addEventListener("mousemove", mouseMoved);
   area.addEventListener("mouseover", mouseOver);
   area.addEventListener("mouseout", mouseOut);
   area.addEventListener("mousedown", mouseDown);
   area.addEventListener("mouseup", mouseUp);
}

window.addEventListener("load", init);
