<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Body Mass Index</title>
</head>
<body>
	<h1>Body Mass Index</h1>
	<form method="post">
		<input type="text" name="weight" value="${weight}" min="1"
			size="5" /> &nbsp;kg&nbsp;<span style="color: red">${errorWeight}</span><br />
		<input type="text" name="height" value="${height}" min="1"
			size="5" /> &nbsp;cm&nbsp;<span style="color: red">${errorHeight}</span><br />
		<input type="submit" value="Calculate BMI" />
	</form>
	BMI:
	<span style="color:${bmi<25?'green':'red'}">${bmi}</span>
	<div>Total visitors: ${visitorsTotal} Active visitors:
		${visitorsActive}</div>
</body>
</html>