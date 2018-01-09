let name = window.prompt("Enter your: ");
let answer = window.confirm("Is your naam correct? " + name);
if (answer) {
	window.alert("Hello " + name);
} else {
	window.alert("No name");
}

