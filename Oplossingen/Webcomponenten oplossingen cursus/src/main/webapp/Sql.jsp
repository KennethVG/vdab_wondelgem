<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>SQL</title>
</head>
<body>
   <h1>SQL</h1>
   <form>
      Query:
      <input type='text' name='query' size='50' value='${param.query}' />
      <input type='submit' value='Submit' />
   </form>
   ${error}
   <c:if test="${not empty result}">
      <table>
         <c:forEach items="${result}" var="row">
            <tr>
               <c:forEach items="${row}" var="el">
               <td>${el}</td>
               </c:forEach>
            </tr>
         </c:forEach>
      </table>
   </c:if>
</body>
</html>
