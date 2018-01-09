let age = prompt('Enter your age:', '0');
let days = age * 365;
let weeks = days / 7;
let adult = (age > 18);
console.log('Years: ' + age);
console.log('Days: ' + days);
console.log('Weeks: ' + weeks);
console.log(adult ? 'Adult' : 'Minor');
