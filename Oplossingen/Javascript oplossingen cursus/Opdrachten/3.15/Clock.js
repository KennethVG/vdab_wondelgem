function updateTime() {
	const clock = document.getElementById("clock");
	const now = new Date();
	clock.innerHTML = now.toLocaleTimeString();
}

function init() {
	updateTime();
	setInterval(updateTime, 1000);
}

window.addEventListener("load", init);
