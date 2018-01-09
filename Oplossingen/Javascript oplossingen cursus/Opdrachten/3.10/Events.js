function init() {
	const area1 = document.getElementById("area1");
	const area2 = document.getElementById("area2");
	document.addEventListener("click", documentClickCapture, true);
	document.addEventListener("click", documentClickBubble, false);
	area1.addEventListener("click", area1ClickCapture, true);
	area1.addEventListener("click", area1ClickBubble, false);
	area2.addEventListener("click", area2ClickCapture, true);
	area2.addEventListener("click", area2ClickBubble, false);
}

function documentClickCapture() {
	console.log("Capture Document");
}

function documentClickBubble() {
	console.log("Bubble Document");
}

function area1ClickCapture() {
	console.log("Capture Area1");
}

function area1ClickBubble() {
	console.log("Bubble Area1");
}

function area2ClickCapture() {
	console.log("Capture Area2");
}

function area2ClickBubble() {
	console.log("Bubble Area2");
}

window.addEventListener("load", init);
