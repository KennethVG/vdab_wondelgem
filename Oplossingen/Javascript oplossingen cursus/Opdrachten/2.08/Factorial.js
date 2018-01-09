function faculty(value) {
  if(faculty == 1) {
    return 1;
  }
  else {
    return value * faculty(value-1);
  }
}


let result = faculty(5);
console.log(5);