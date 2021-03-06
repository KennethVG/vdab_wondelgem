<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--fmt:setLocale value="NL"  /-->
<c:catch var="ex">
	<fmt:parseNumber type="number" value="${param.meter}" var="meter" />
</c:catch>
<html>
<title>Metric Convertor</title>
<body>
	<c:choose>
		<c:when test="${ex == null}">
			<c:forEach items="${paramValues.unit}" var="unit">
				<c:choose>
					<c:when test="${unit == 'inch'}">
						<c:set var="factor" value="0.0254" />
						<c:set var="inchsel" value="selected" />
					</c:when>
					<c:when test="${unit == 'feet'}">
						<c:set var="factor" value="0.3048" />
						<c:set var="feetsel" value="selected" />
					</c:when>
					<c:when test="${unit == 'yard'}">
						<c:set var="factor" value="0.9144" />
						<c:set var="yardsel" value="selected" />
					</c:when>
					<c:when test="${unit == 'mile'}">
						<c:set var="factor" value="1609.344" />
						<c:set var="milesel" value="selected" />
					</c:when>
				</c:choose>
				<fmt:formatNumber value="${meter}" maxFractionDigits="2"
					minFractionDigits="2" /> meter = 
            <fmt:formatNumber value="${meter/factor}"
					maxFractionDigits="2" minFractionDigits="2" />
    ${unit}<br />
			</c:forEach>
		</c:when>
		<c:otherwise>
      Invalid value!<br />
		</c:otherwise>
	</c:choose>
	<br />
	<form>
		<input type="text" name="meter" value="${param.meter}" size="8" />
		&nbsp;meter <input type="submit" value=" = " /> <select name="unit"
			multiple="multiple">
			<option value="inch" ${inchsel}>inch</option>
			<option value="feet" ${feetsel}>feet</option>
			<option value="yard" ${yardsel}>yard</option>
			<option value="mile" ${milesel}>mile</option>
		</select>
	</form>
</body>
</html>
