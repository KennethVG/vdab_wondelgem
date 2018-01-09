class Person {
  constructor(firstName ="", lastName="") {
    this._firstName= firstName;
    this._lastName = lastName;
  }
  
  get firstName() {
    return this._firstName;    
  }
  
  get lastName() {
    return this._lastName
  }
  
  toString() {
    return `Person [firstName=${this._firstName},lastName=${this._lastName}]`;
  }
}



class Student extends Person {
  constructor(firstName, lastName, studentId = 0) {
    super(firstName,lastName);
    this._studentId = studentId;
  }
  
  get studentId() {
    return this._studentId;
  }
  
  study() {
    console.log("Studying")
  }

  toString() {
    return `Student [firstName=${this._firstName},lastName=${this._lastName},studentId=${this._studentId}]`;
  }
  
}

class Teacher extends Person {
  constructor(firstName, lastName, employeeId = 0) {
    super(firstName,lastName);
    this._employeeId = employeeId;
  }
  
  get empoyeeId() {
    return this._employeeId;
  }
  
  teach() {
    console.log("Teaching");
  }

  toString() {
    return `Teacher [firstName=${this._firstName},lastName=${this._lastName},employeeId=${this._employeeId}]`;
  }
  
}



const person = new Person("Homer","Simpson");
console.log(person.toString());

const student = new Student("Bart","Simpson", 1);
console.log(student.toString());
student.study();

const teacher = new Teacher("Marge","Simpson", 200);
console.log(teacher.toString());
teacher.teach();

