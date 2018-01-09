function average() {
  let total = 0;
  for (const arg in arguments) {
    total += arg;
  }
  return total/arguments.length;
}

let avg = average(5, 7, 9, 3, 2);
console.log('Average: ' + avg);
