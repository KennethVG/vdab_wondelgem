function updateContent() {
   const content = document.getElementById("content");
   const xhr = new XMLHttpRequest();
   xhr.onload = onLoadUpdateContent; 
   xhr.open("GET", "https://www.noelvaes.eu/Ajax/GuestBook", true);
   xhr.send(null);
}

function onLoadUpdateContent() {
   const items = JSON.parse(this.responseText);
   while (content.firstChild) {
      content.removeChild(content.firstChild);
   }
   
   for (item of items) {
      const d = document.createElement('div');
      const t = document.createTextNode(`${item.date}  : ${item.name}  ${item.message}`);
      d.appendChild(t);
      content.appendChild(d);
   }
}

function addItem(e) {
   e.preventDefault();
   const nameField = document.getElementById("name");
   const messageField = document.getElementById("message");

   const item =
   {
      name : nameField.value,
      message : messageField.value
   }

   const xhr = new XMLHttpRequest();
   xhr.onload = onLoadAddItem; 
   xhr.open("POST", "https://www.noelvaes.eu/Ajax/GuestBook", true);
   xhr.send(JSON.stringify(item));
}

function onLoadAddItem() {
   const form = document.getElementById("form");
   form.reset();
   updateContent();
}

function init() {
   updateContent();
   const form = document.getElementById("form");
   form.addEventListener("submit", addItem);
}

window.addEventListener("load", init);
