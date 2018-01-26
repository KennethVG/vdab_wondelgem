<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${param.unit == 'inch'}">
		<c:set var="factor" value="0.0254" />
		<c:set var="inchsel" value="true" />
	</c:when>
	<c:when test="${param.unit == 'feet'}">
		<c:set var="factor" value="0.3048" />
		<c:set var="feetsel" value="true" />
	</c:when>
	<c:when test="${param.unit == 'yard'}">
		<c:set var="factor" value="0.9144" />
		<c:set var="yardsel" value="true" />
	</c:when>
	<c:when test="${param.unit == 'mile'}">
		<c:set var="factor" value="1609.344" />
		<c:set var="milesel" value="true" />
	</c:when>
</c:choose>
<c:set var="other" value="${param.meter/factor}" />
<!DOCTYPE html>
<html>
<title>Metric Convertor</title>
<head>
<script src="../js/MetricConvertor.js"></script>
</head>
<body>
	<form>
		<input type="text" name="meter" value="${param.meter}" size="8" />
		&nbsp;meter 
		<input type="submit" value=" = " />
		<input type="text" name="other" disabled="disabled" size="20" value="${other}" />
	   <select id="unitSelect" name="unit">
			<option value="inch" ${inchsel?'selected':''}>inch</option>
			<option value="feet" ${feetsel?'selected':''}>feet</option>
			<option value="yard" ${yardsel?'selected':''}>yard</option>
			<option value="mile" ${milesel?'selected':''}>mile</option>
		</select>
	</form>
</body>
</html>
