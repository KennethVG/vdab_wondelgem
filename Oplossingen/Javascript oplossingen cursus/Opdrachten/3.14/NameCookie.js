let name = getCookie("name");
if(name == null || name=="null") {
   name = window.prompt("Enter your name :","");
   setCookie("name",name,0,5);
}
window.alert("Hello " + name);
