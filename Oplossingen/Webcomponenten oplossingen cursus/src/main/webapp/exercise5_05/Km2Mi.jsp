<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyTagLib.tld" prefix="mtl"%>
<!DOCTYPE html>
<html>
<head>
<title>KM to Mile</title>
</head>
<body>
   <form>
      <div>
         <input type="text" name="km" size="4" value="${param.km}" />
         km
         <input type="submit" value="-->" />
         ${mtl:round(mtl:km2mi(param.km),2)} miles
      </div>
   </form>
</body>
</html>
