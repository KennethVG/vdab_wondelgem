function selectLanguage() {
   setCookie("language",this.name,1);
   forward(this.name);
}

function forward(value) {
   switch(value) {
      case "en": location.replace("English.html"); break;
      case "nl": location.replace("Dutch.html"); break;
      case "fr": location.replace("French.html"); break;
   }
}

function init() {
   const lang = getCookie("language");
   if(lang != null) {
      forward(lang);
      return;
   }
   const dutchButton = document.getElementById("dutch");
   const englishButton = document.getElementById("english");
   const frenchButton = document.getElementById("french");
   dutchButton.addEventListener("click",selectLanguage);
   englishButton.addEventListener("click",selectLanguage);
   frenchButton.addEventListener("click",selectLanguage);
}

window.addEventListener("load", init);

