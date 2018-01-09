function createAccumulator() {
  let sum = 0;
  return value => sum+=value;
}

let acc = createAccumulator();

console.log(acc(5));
console.log(acc(8));
console.log(acc(2));

let acc1 = createAccumulator();
let acc2 = createAccumulator();

console.log(acc1(5));
console.log(acc1(8));
console.log(acc1(2));

console.log(acc2(3));  
console.log(acc2(6));
console.log(acc2(5));



/*
let sum = 0;

function acc(value) {
  return sum+=value;
}

console.log(acc(5));
console.log(acc(8));
console.log(acc(2));

*/
