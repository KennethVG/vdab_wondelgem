function calculateBmi(w =0 , h=1) {
  return w / (h**2);
}

function diagnoseBmi(bmi = 0) {
  let result;
  if (bmi < 18) {
    result = 'underweight';
  } else if (bmi < 25) {
    result = 'normal';
  } else if (bmi < 27) {
    result = 'light overweight';
  } else if (bmi < 30) {
    result = 'moderate overweight';
  } else if (bmi <= 40) {
    result = 'severe overweight';
  } else if (bmi > 40) {
    result = 'obesitas';
  } 
  return result;
}
let weight = prompt('Enter your weight (kg):');
let height = prompt('Enter your heigth (cm):');
height /= 100;
let bmi = calculateBmi(weight, height);
let diagnose = diagnoseBmi(bmi);

console.log('Weight (kg): ' + weight);
console.log('Height (m): ' + height);
console.log('BMI: ' + bmi);
console.log('Diagnose: ' + diagnose);
