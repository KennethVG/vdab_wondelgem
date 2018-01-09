function updateCity() {
   if (this.value.length != 4)
      return;
   const xhr = new XMLHttpRequest();
   xhr.onload = onLoad;

   xhr.open("GET", "https://www.noelvaes.eu/Ajax/zipcode?code=" + 
            this.value, true);
   //xhr.open("GET", "zipcode?code=" + this.value, true);

   xhr.send(null);
}

function onLoad() {
   const city = document.getElementById("cityField");
   city.options.length = 0;

   const cities = this.responseText.split(";", 100);
   for (let i = 0; i < cities.length - 1; i++) {
      const option = document.createElement('option');
      option.text = cities[i];
      city.options[i] = option;
   }
}

function init() {
   var zipcode = document.getElementById("zipcodeField");
   zipcode.addEventListener("keyup", updateCity);
}

window.addEventListener("load", init);
