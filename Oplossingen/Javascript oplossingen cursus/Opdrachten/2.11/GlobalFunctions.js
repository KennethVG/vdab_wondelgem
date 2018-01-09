let value1;
let value2;

do {
  value1 = prompt("Enter value 1:");
} while (isNaN(value1));

do {
  value2 = prompt("Enter value 2:");
} while (isNaN(value2));


let number1 = parseInt(value1);
let number2 = parseInt(value2);
console.log(`The sum of ${number1} and ${number2} is ${number1 + number2}`);
