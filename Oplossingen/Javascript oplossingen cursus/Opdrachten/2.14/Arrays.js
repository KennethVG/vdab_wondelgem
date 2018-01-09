const text = prompt("Enter words:");
if(text != null) {
	const words = text.split(" ");
	console.log(words.length);
	for(const el of words) {
		console.log(el);		
	}
	
	words.sort((a,b) => a.length - b.length);
	for(const el of words) {
		console.log(el);		
	}
	
	words.reverse();
	for(const el of words) {
		console.log(el);		
	}
	
	words.unshift("begin");
	words.push("end");
	for(const el of words) {
		console.log(el);		
	}
	
	
	
}
