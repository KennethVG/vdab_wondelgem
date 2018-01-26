<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Body Mass Index</title>
</head>
<body>
   <h1>Body Mass Index</h1>
   <form method="post" >
      <input type="number" name="weight" size="5"  />
      &nbsp;kg <br />
      <input type="number"  name="height" size="5" />
      &nbsp;cm <br />
      <input type="submit" value="Calculate BMI" />
   </form>
   BMI: <span style="color:${bmi<25?'green':'red'}">${bmi}</span>   
   <div>
   Total visitors: ${visitorsTotal} Active visitors: ${visitorsActive}
   </div>
</body>
</html>