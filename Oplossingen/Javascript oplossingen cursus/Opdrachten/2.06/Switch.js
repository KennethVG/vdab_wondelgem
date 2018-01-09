var language = prompt('Language (nl|fr|en):', 'en');
switch (language) {
  case 'nl':
    console.log('Dag Wereld');
    break;
  case 'en':
    console.log('Hello World');
    break;
  case 'fr':
    console.log('Bonjour Monde');
    break;
  default:
    console.log('Unknown language');
}
