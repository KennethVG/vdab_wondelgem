const now = new Date();
console.log(now.toLocaleString());
const hour = now.getHours();
if (hour < 11) {
  console.log('Good morning');
} else if (hour < 16) {
  console.log('Goede afternoon');
} else {
  console.log('Good evening');
}
