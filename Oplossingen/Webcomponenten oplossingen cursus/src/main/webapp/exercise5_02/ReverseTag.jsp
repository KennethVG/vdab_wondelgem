<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyTagLib.tld" prefix="mtl"%>
<!DOCTYPE html>
<html>
<head>
<title>Reverse Text</title>
</head>
<body>
   <div>
      <form>
         <input type="text" name="text" value="${param.text}" placeholder="Enter your text here" />
         <input type="submit" value="<==>" />
         <mtl:reverse text="${param.text}" />
      </form>
   </div>
</body>
</html>