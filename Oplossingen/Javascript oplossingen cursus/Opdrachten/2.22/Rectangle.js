class Rectangle{
  constructor(width = 0, height = 0, x = 0, y = 0) {
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
  }
  get width() {
    return this._width;
  }
  set width(width) {
    this._width = width < 0 ? 0 : width;
  }
  get height() {
    return this._height;
  }
  set height(height) {
    this._height = height < 0 ? 0 : height;
  }
  get x() {
    return this._x;
  }
  set x(x) {
    this._x = x;
  }
  get y() {
    return this._y;
  }
  set y(y) {
    this._y = y;
  }
  get area() {
    return (this._height * this._width);
  }
  get perimeter() {
    return 2 * (this._height + this._width);
  }
  
  scale(factor) {
    if(factor > 0) {
      this.width*= factor;
      this.height*= factor;
    }
  }
  
  toString() {
    return `Rectangle [width:${this.width},height:${this.height},x:${this.x},y:${this.y}]`;
  }
}


const rect1 = new Rectangle(10, 5, 3, 6);
console.log(rect1.toString());
const rect2 = new Rectangle();
console.log(rect2.toString());
const rect3 = new Rectangle(-9,-8,5,3);
console.log(rect3.toString());
rect1.scale(3);
console.log(rect1.toString());
