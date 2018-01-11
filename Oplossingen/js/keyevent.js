window.addEventListener("load", () => {
  document.oncontextmenu = () => false;

  let result = document.getElementById("result");

  window.addEventListener("keydown", eventObject => {
    let nummer = eventObject.which;
    console.log(eventObject.which);
    if (nummer == 65) {
      result.innerHTML = "U hebt op A gedrukt!";
    } else if (nummer == 13) {
      result.innerHTML = "U hebt op ENTER gedrukt!";
    }
  });

  let button = document.getElementById("btn_click");
  let buttonResult = document.getElementById("result_click");
  button.addEventListener("mousedown", e => {
    switch (e.button) {
      case 0:
        buttonResult.innerHTML = "Links geklikt";
        break;
      case 1:
        buttonResult.innerHTML = "Midden geklikt";
        break;
      case 2:
        buttonResult.innerHTML = "Rechts geklikt";
        break;
      default:
        buttonResult.innerHTML = "Werkt niet";
        break;
    }
  });
});
