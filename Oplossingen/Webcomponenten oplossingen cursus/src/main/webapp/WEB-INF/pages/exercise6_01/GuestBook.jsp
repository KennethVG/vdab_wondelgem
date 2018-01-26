<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/MyTagLib.tld" prefix="mtl"%>

<html>
<head>
<title>Guestbook</title>
</head>
<body>
   <div>
      Guestbook
      <table>
         <c:forEach items="${messages}" var="msg">
            <tr>
               <td>
                  <fmt:formatDate value="${mtl:toDate(msg.date)}" pattern="dd/MM/yyyy HH:mm " />
               </td>
               <td>${msg.name}</td>
               <td>${fn:escapeXml(msg.message)}</td>
            </tr>
         </c:forEach>
      </table>
      <form method="POST">
         Name<br />
         <input type='text' name='name' />
         <br /> Message<br />
         <textarea cols='50' rows='10' name='message'></textarea>
         <br />
         <input type='submit' value='Versturen' />
      </form>
   </div>
</body>
</html>
