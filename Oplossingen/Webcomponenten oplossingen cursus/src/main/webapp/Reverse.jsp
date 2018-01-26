<jsp:useBean id="rb" class="eu.noelvaes.web.ReverseBean" scope="request"/>

<html>
<head><title>Reverse</title></head>
<body>
<jsp:setProperty name="rb" property="*"  />
The reverse of
<jsp:getProperty name="rb" property="text" />
 is 
<jsp:getProperty name="rb" property="reverse" />
</body>
</html>