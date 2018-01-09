function specialSum(value1, value2, operation) {  
  return operation(value1) + operation(value2);
}

const factorial = a => a<=1?1:a * factorial(a-1);

console.log(specialSum(3,4, a => a**2));
console.log(specialSum(3,4, a => a+4));
console.log(specialSum(3,4, a => a-1));
console.log(specialSum(3,4, a => a*7));
console.log(specialSum(3,4, factorial));

