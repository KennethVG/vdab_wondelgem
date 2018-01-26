function init() {
	var select = document.getElementById("unitSelect");
	select.addEventListener("change", function() {
		this.form.submit();
	});
}

window.addEventListener("load", init);
