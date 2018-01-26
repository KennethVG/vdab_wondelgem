<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyTagLib.tld" prefix="mtl"%>
<!DOCTYPE html>
<html>
<head>
<title>Repeat tag</title>
</head>
<body>
<mtl:repeat count="5">
This text is printed multiple times.
 <br />
</mtl:repeat>

</body>
</html>