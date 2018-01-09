function validate(e) {
   let valid = true;
   const firstNameField = document.getElementById("firstName");
   const lastNameField = document.getElementById("lastName");

   if (firstNameField.value.length == 0) {
      valid = false;
      firstNameField.setAttribute("class","error");
   } else {
      firstNameField.removeAttribute("class");      
   }

   if (lastNameField.value.length == 0) {
      valid = false;
      lastNameField.setAttribute("class","error");
   }else {
      lastNameField.removeAttribute("class");      
   }

   if (!valid) {
      alert("Enter your firstname and lastname!");
      e.preventDefault();
   }
}

function init() {
   const form = document.getElementById("myForm");
   form.addEventListener("submit", validate);
}

window.addEventListener("load", init);
