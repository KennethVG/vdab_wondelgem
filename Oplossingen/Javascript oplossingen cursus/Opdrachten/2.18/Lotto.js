const numbers = new Array(6);

for (let i = 0; i < numbers.length;) {
	let rand = Math.round(1 + (Math.random() * 41));
	if (!numbers.includes(rand))
			numbers[i++] = rand;
}

numbers.sort((a, b) => return a - b);

for(el of numbers) {
	console.log(el)
}

