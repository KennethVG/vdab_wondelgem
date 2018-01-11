window.addEventListener("load", () => {
  alert("Document Loaded!");
  var myButton = document.getElementById("myButton");
  myButton.addEventListener("click", () => {
    alert("Geklikt op de button!");
  });
});

window.addEventListener("resize", () => {
  console.log("Hoogte= " + screen.height + " Breedte= " + screen.width);
  console.log(
    "Hoogte= " + window.outerHeight + " Breedte= " + window.outerWidth
  );
});
