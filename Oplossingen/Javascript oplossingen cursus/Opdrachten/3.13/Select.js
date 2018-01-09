function select(e) {
   const form  = document.getElementById("myForm");
   const selection = document.getElementById("selection");
   const option = selection.options[selection.selectedIndex];
   alert("Your choice: " + option.value);
   form.submit();
}

function init() {
   const selection = document.getElementById("selection");   
   selection.addEventListener("change", select);
}


window.addEventListener("load", init);
