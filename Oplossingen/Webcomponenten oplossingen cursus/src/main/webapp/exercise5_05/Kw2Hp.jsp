<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyTagLib.tld" prefix="mtl"%>
<!DOCTYPE html>
<html>
<head>
<title>Kilowatt to Horsepower</title>
</head>
<body>
   <form>
      <div>
         <input type="text" name="kw" size="4" value="${param.kw}" />
         kw
         <input type="submit" value="-->" />
         ${mtl:round(mtl:kw2hp(param.kw),2)} hp
      </div>
   </form>
</body>
</html>
