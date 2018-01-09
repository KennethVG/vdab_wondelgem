const names = new Set();

let name;
do {
	name = prompt(`Enter name ${names.size + 1}:`);
	if(name != null) {
	   names.add(name);
  }
} while(name != null && names.size < 5);

for(name of names) {
	console.log(name);
}