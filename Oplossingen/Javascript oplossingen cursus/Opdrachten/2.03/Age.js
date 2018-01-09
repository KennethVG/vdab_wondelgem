let age;
do {
  age = prompt('Enter your age (between 0 and 150):');
} while ((age != null) && !((age > 0) && (age < 150)));
console.log((age != null) ? 'Age: ' + age : 'Cancelled');
