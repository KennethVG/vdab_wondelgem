function init(e) {
   const dateNode = document.getElementById("date");
   const today = new Date();
   const hour = today.getHours();
   let greeting ="";
   if(hour <= 11) {
      greeting = "Goede morgen!";
   }
   else if(hour <= 16) {
      greeting = "Goede middag!";
   }
   else {
      greeting = "Goede avond";
   }
   
   const strongNode = document.createElement("strong");
   const greetingNode = document.createTextNode(greeting);   
   const textNode = document.createTextNode(today.toLocaleString());
   
   dateNode.appendChild(greetingNode);
   dateNode.appendChild(strongNode);
   strongNode.appendChild(textNode);

   
   let image = "sun.png";
   if(hour < 7 || hour > 20 ) {
      image = "moon.jpg";
   } 
   
   const imageNode = document.getElementById("img");
   imageNode.setAttribute("src",image);
   imageNode.setAttribute("width",100);
   imageNode.setAttribute("height",100);
   
}

window.addEventListener("load", init);
