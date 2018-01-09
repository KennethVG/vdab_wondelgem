const shoppingCart = new Map();
shoppingCart.set("Milk",12.56);
shoppingCart.set("Potatoes",3.5);
shoppingCart.set("Fish",5.6);
shoppingCart.set("Tomatoes",5.7);
shoppingCart.set("Candy",8.3);

for(el of shoppingCart) {
	console.log(el[0] + " : " + el[1]);
}

shoppingCart.delete("Candy");

for(el of shoppingCart) {
	console.log(el[0] + " : " + el[1]);
}

console.log(shoppingCart.size);

let sum = 0;
shoppingCart.forEach(a => sum+=a);
console.log(sum);

