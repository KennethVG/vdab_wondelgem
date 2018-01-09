function select(e) {   
   const selection = document.getElementById("selection");
   const body = document.getElementById("body");
   const option = selection.options[selection.selectedIndex];
   body.setAttribute("style","background-color:" + option.value);
}

function init() {
   const sel = document.getElementById("selection");   
   sel.addEventListener("change", select);
}

window.addEventListener("load", init);
