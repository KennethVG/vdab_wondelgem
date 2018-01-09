function createIncrementor(step) {
  let total = 0;
  return () => total+=step;
}

let inc = createIncrementor(1);

for(let i = 0; i < 10 ; i++) {
   console.log(inc());
}
