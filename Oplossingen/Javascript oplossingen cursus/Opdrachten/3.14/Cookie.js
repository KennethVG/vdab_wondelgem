/* This file contains JavaScript functions to handle cookies */

/*
 * This function creates a cookie.
 * 
 * Arguments:
 * -----------
 * name:    Name of the cookie. 
 * content: Content of the cookie.
 * days:    Number of days from now before expiration.
 * hours:	Number of hours from now before expiration.
 * minutes: Number of minutes from before expiration.
 */
function setCookie(name, content, days=0, hours=0, minutes=0) {
   const now = new Date();
   const exp = new Date(now.getTime()
         + (((((days * 24) + hours) * 60) + minutes) * 60000));
   const expiration = exp.toUTCString()
   name = encodeURIComponent(name);
   content = encodeURIComponent(content);
   document.cookie = `${name}=${content};expires=${expiration}`;
}

/*
 * This function gets the content of a cookie.
 * 
 * Arguments: ---------- name: Name of the cookie.
 */
function getCookie(name) {
   const regex = new RegExp(name + "=([^;]+)");
   const result = regex.exec(document.cookie);
   if (result)
      return decodeURIComponent(result[1]);
   else
      return null;
}

/*
 * This function clears a cookie.
 * 
 * Arguments: ---------- name: Name of the cookie.
 */
function clearCookie(name) {
   setCookie(name, "", -1);
}

/* This array contains a list of text-types (including HTML5) */
const textTypes = ["text","color","date","datetime","datetime-local","email","month","number","range","search","tel","time","url","week"];

/*
 * This function fill a form with data from a cookie. Arguments: ----------
 * form: The form to fill.
 */
function loadForm(form) {
   for (let i = 0; i < form.elements.length; i++) {
      if (textTypes.indexOf(form.elements[i].type) >=0 ) {
         form.elements[i].value = getCookie(form.elements[i].name) || "";
      }
   }  
}

/*
 * This function write all text-content to a cookie. Arguments: ---------- form:
 * The form
 */
function saveForm(form) {
   for (let i = 0; i < form.elements.length; i++) {
      if (textTypes.indexOf(form.elements[i].type) >=0 ) {
         setCookie(form.elements[i].name, form.elements[i].value, 1, 0, 0);
      }
   }
}
