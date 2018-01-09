function init() {
   console.log(location.search);
   const firstName = document.getElementById("firstName");
   const lastName = document.getElementById("lastName");
   firstName.innerHTML = getParameter("firstName");
   lastName.innerHTML = getParameter("lastName");
}

function getParameter(name) {
   const regex = new RegExp(name + "=([^&]+)");
   const queryString = decodeURIComponent(location.search.replace(/\+/g,"%20"));
   const result = regex.exec(queryString);
   if (result)
      return result[1];
   else
      return null;
}

window.addEventListener("load", init);
