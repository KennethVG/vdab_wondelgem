function updateCity() {
   if (this.value.length != 4)
      return;
   const xhr = new XMLHttpRequest();
   xhr.onload = onLoad;
   // xhr.open("GET", "http://www.noelvaes.eu/Ajax/zipcodejson?code=" +
   // this.value, true);
   xhr.open("GET", "zipcodejson?code=" + this.value, true);
   xhr.send(null);
}

function onLoad() {
   const city = document.getElementById("cityField");
   city.options.length = 0;

   const cities = JSON.parse(this.responseText);   
   
   for (let i = 0; i < cities.length - 1; i++) {
      const option = document.createElement('option');
      option.text = cities[i].name;
      option.id = cities[i].id;
      city.options[i] = option;
   }
}

function init() {
   var zipcode = document.getElementById("zipcodeField");
   zipcode.addEventListener("keyup", updateCity);
}

window.addEventListener("load", init);
