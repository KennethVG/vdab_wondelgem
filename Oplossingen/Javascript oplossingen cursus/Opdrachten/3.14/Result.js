function init() {
   console.log(location.search);
   var firstName = document.getElementById("firstName");
   var lastName = document.getElementById("lastName");
   firstName.innerHTML = getParameter("firstName");
   lastName.innerHTML = getParameter("lastName");
}

function getParameter(name) {
   var regex = new RegExp(name + "=([^&]+)");
   var queryString = decodeURIComponent(location.search.replace(/\+/g,"%20"));
   var result = regex.exec(queryString);
   if (result)
      return result[1];
   else
      return null;
}

window.addEventListener("load", init);
