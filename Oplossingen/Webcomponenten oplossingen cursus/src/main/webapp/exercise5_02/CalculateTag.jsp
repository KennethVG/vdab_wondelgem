<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyTagLib.tld" prefix="mtl"%>
<!DOCTYPE html>
<html>
<head>
<title>Calculation</title>
</head>
<body>
   <form method="post">
      <div>
         <input type="number" name="number1" size="4" value="${param.number1}" />
         *
         <input type="number" name="number2" size="4" value="${param.number2}" />
         <input type="submit" value="=" />
         &nbsp;
         <mtl:calculate number1="${param.number1}" number2="${param.number2}" />
      </div>
   </form>
</body>
</html>