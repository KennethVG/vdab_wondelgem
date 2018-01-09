const colors = {
	a : "aqua",
	b : "blue",
	c : "cyan",
	d : "deeppink",
	f : "fuchsia",
	g : "green",
	h : "honeydew",
	i : "indigo",
	k : "khaki",
	l : "lime",
	m : "magenta",
	n : "navy",
	o : "orange",
	p : "purple",
	r : "red",
	s : "silver",
	t : "turquoise",
	v : "violet",
	w : "white",
	y : "yellow",
};

function pressed(e) {
	const c = String.fromCharCode(e.which);
	const body = document.getElementById("body");
	body.style.backgroundColor = colors[c];
}

function init() {
	document.addEventListener("keypress", pressed);
}

window.addEventListener("load", init);
