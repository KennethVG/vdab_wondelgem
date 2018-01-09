const email = prompt("Enter your e-mail address:");
const re = new RegExp("^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$");
let result = re.test(email);
console.log(result ? "Valid" : "Invalid");
