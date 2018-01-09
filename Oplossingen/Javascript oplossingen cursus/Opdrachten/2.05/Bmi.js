   let weight = prompt("Enter your weight (kg):");
   let height = prompt("Enter your heigth (cm):");
   height /= 100;
   let bmi = weight / (height**2);
   let result;
   if (bmi < 18) {
      result = "underweight";
   } else if (bmi < 25) {
      result = "normal";
   } else if (bmi < 27) {
      result = "light overweight";
   } else if (bmi < 30) {
      result = "moderate overweight";
   } else if (bmi <= 40) {
      result = "severe overweight";
   } else if (bmi > 40) {
      result = "obesitas";
   }
   console.log("Diagnose: " + result);
