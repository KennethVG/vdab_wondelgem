const answer = prompt("Enter the date: ","dd-mm-yyyy or dd.mm.yyyy");
const re = new RegExp("^[0-3]?[0-9][/\.\-][01]?[0-9][/\.\-][0-9]{4}$");
let result = re.test(answer);
if(result) {
   let parts = answer.split(/[\-/\.]/,3);
   let date = new Date(parts[2],parts[1]-1,parts[0]);
   console.log(date.toLocaleDateString());
}
else {
   console.log("Invalid date");
}
