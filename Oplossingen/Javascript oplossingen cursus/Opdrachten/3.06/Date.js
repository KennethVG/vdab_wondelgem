function init(e) {
   const dateNode = document.getElementById("date");
   const today = new Date();
   const hour = today.getHours();
   let greeting ="";
   if(hour <= 11) {
      greeting = "Good morning!";
   }
   else if(hour <= 16) {
      greeting = "Good afternoon!";
   }
   else {
      greeting = "Good evening";
   }
   
   dateNode.innerHTML = greeting +"<br /><strong>" +today.toLocaleString() +"</strong>";
   
//   const strongNode = document.createElement("strong");
//   const textNode = document.createTextNode(today.toLocaleString());
//   
//   dateNode.appendChild(strongNode);
//   strongNode.appendChild(textNode);
}

window.addEventListener("load", init);
