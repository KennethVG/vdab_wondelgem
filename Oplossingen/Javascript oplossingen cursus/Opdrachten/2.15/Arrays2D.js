const table = new Array(5);
for(let i = 0; i< table.length; i++) {
   table[i] = new Array(5);
}

for(let row = 0;row < table.length; row++) {
   for(let column = 0; column < table[row].length; column++) {
   	table[row][column]  = column + row;  
   }
}

for(row of table) {
   for(el of row) {
      console.log(el);
   }
}

let sum = 0;
for(row of table) {
   for(el of row) {
      sum+=el;
   }
}

console.log("Total sum: ${sum}");


