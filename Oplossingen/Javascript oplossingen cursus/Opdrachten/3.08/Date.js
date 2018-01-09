function init(e) {
   //const dateNode = document.getElementById("date");
   const dateNode = $("date");
   
   const today = new Date();
   const hour = today.getHours();
   let greeting ="";
   let className ="";
   if(hour <= 11) {
      greeting = "Goede morgen!";
      className="morning";
   }
   else if(hour <= 16) {
      greeting = "Goede middag!";
      className="noon";
   }
   else {
      greeting = "Goede avond";
      className="evening";
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
   
   //const imageNode = document.getElementById("img");
   const imageNode = $("img");

   imageNode.setAttribute("src",image);
   imageNode.setAttribute("width",100);
   imageNode.setAttribute("height",100);

   //dateNode.setAttribute("class",className);
   $("date").setAttribute("class",className);
}

const $ = function(id) {
	return window.document.getElementById(id);
};

window.addEventListener("load", init);
