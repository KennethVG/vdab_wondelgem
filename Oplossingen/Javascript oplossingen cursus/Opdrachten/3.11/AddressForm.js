function validate(e) {
   clearErrors();
   const firstName = document.getElementById("firstNameField");
   const firstNameError = document.getElementById("firstNameErrorField");
   const lastName = document.getElementById("lastNameField");
   const lastNameError = document.getElementById("lastNameErrorField");
   const email = document.getElementById("emailField");
   const emailError = document.getElementById("emailErrorField");
   const birthday = document.getElementById("birthdayField");
   const birthdayError = document.getElementById("birthdayErrorField");

   let valid = true;
   if (lastName.value.length == 0) {
      lastName.setAttribute("class", "error");
      lastNameError.innerHTML = "Enter your lastname.";
      valid = false;
   }

   if (firstName.value.length == 0) {
      firstName.setAttribute("class", "error");
      firstNameError.innerHTML = "Enter your fistname.";
      valid = false;
   }

   if (!email.value
         .match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)) {
      email.setAttribute("class", "error");
      emailError.innerHTML = "Enter your email.";
      valid = false;
   }

   if (!birthday.value.match(/^[0-3]?[0-9][\/][01]?[0-9][\/][0-9]{4}$/)) {
      birthday.setAttribute("class", "error");
      birthdayError.innerHTML = "Enter a valid birthday.";
      valid = false;
   }

   if (!valid) {
      e.preventDefault();
   }
}

function clearErrors() {
   const firstName = document.getElementById("firstNameField");
   const firstNameError = document.getElementById("firstNameErrorField");
   firstName.removeAttribute("class");
   firstNameError.innerHTML = "&nbsp;";

   const lastName = document.getElementById("lastNameField");
   const lastNameError = document.getElementById("lastNameErrorField");
   lastName.removeAttribute("class");
   lastNameError.innerHTML = "&nbsp;";

   const email = document.getElementById("emailField");
   const emailError = document.getElementById("emailErrorField");
   email.removeAttribute("class");
   emailError.innerHTML = "&nbsp;";

   const birthday = document.getElementById("birthdayField");
   const birthdayError = document.getElementById("birthdayErrorField");
   birthday.removeAttribute("class");
   birthdayError.innerHTML = "&nbsp;";
}

function reset() {
   clearErrors();
}

function init() {
   const form = document.getElementById("addressForm");
   form.addEventListener("submit", validate);
   form.addEventListener("reset", reset);
}

window.addEventListener("load", init);
