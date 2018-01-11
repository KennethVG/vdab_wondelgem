window.addEventListener("load", () => {
  let result = document.getElementById("result");
  let queryString = decodeURIComponent(location.search);
  console.log("queryString= " + queryString);
  let all = queryString.substring(1).split("&");
  console.log(all);

  let resultString = "Dag ";
  for (const keyAndValue of all) {
    let value = keyAndValue.split("=")[1].replace(/\+/g, "");;
    resultString += value + " ";
  }

  console.log(resultString);
  result.innerHTML = resultString;
});
