<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="factor" value="0.0254" />
<c:set var="inch" value="${param.meter/factor}" />
<!DOCTYPE html>
<html>
<head>
<title>Metric Convertor</title>
</head>
<body>
<form>
  <input type="text" name="meter" value="${param.meter}" size="8"/>&nbsp;meter
  <input type="submit" value=" = "/> 
  <input type="text" disabled="disabled" value="${inch}" size="8" /> &nbsp;inch
</form>
</body>
</html>