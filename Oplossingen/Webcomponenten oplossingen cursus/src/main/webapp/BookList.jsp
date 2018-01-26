<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Book List</title>
</head>
<body>
   <h1>Book List</h1>
   <table>
      <c:forEach items="${books}" var="book" varStatus="status">
         <tr>
            <td>${status.index}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td><a href="Books?isbn=${book.isbn}">Show details</a></td>            
         </tr>
      </c:forEach>
   </table>
</body>
</html>
