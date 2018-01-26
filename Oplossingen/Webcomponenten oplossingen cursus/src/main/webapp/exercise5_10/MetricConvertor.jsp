<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Metric Convertor</title>
<body>
<c:forEach items="${paramValues.unit}" var="unit">
   <c:choose>
      <c:when test="${unit == 'inch'}">
         <c:set var="factor" value="0.0254" />
         <c:set var="inchsel" value="true" />
      </c:when>
      <c:when test="${unit == 'feet'}">
         <c:set var="factor" value="0.3048" />
         <c:set var="feetsel" value="true" />
      </c:when>
      <c:when test="${unit == 'yard'}">
         <c:set var="factor" value="0.9144" />
         <c:set var="yardsel" value="true" />
      </c:when>
      <c:when test="${unit == 'mile'}">
         <c:set var="factor" value="1609.344" />
         <c:set var="milesel" value="true" />
      </c:when>
   </c:choose>
   ${param.meter} meter = ${param.meter/factor} ${unit}<br />
</c:forEach>
<br />
<form>
   <input type="text" name="meter" value="${param.meter}" size="8" />
    &nbsp;meter 
   <input type="submit" value=" = " />
      <select name="unit" multiple >
      <option value="inch" ${inchsel?'selected':''}>inch</option>
      <option value="feet" ${feetsel?'selected':''}>feet</option>
      <option value="yard" ${yardsel?'selected':''}>yard</option>
      <option value="mile" ${milesel?'selected':''}>mile</option> 
   </select></form>
</body>
</html>
