function init(e) {
   console.log("Document loaded");
}

function resized(e) {
   console.log(`Window resized: ${window.outerWidth} x ${window.outerHeight}`);
}

window.addEventListener("load", init);
window.addEventListener("resize", resized);
