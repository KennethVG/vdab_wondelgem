const days = ['sunday','monday','tuesday','wednesday','thursday','friday','saturday'];
const answer = prompt('Enter your birthday: ', 'yyyy-mm-dd');
const birthday = new Date(answer);

if (isNaN(birthday.getDay())) {
  console.log('Invalid date');
} else {
  console.log('This was a  ' + days[birthday.getDay()]);
}
