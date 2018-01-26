package exercise3_13;
import java.io.*;
import java.net.*;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Cookie")
public class CookieServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
      // if (cookies != null) {
      // for (Cookie cookie : cookies) {
      // switch (cookie.getName()) {
      // case "firstname":
      // firstname = URLDecoder.decode(cookie.getValue(), "UTF-8");
      // break;
      // case "lastname":
      // lastname = URLDecoder.decode(cookie.getValue(), "UTF-8");
      // break;
      // }
      // }
      // }
      
      String lastname = "";
      String firstname = "";
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
         Optional<String> fn = Stream.of(cookies)
                                     .filter(c -> c.getName().equals("firstname"))
                                     .map(Cookie::getValue)
                                     .findAny();
         if(fn.isPresent()) {
            firstname = URLDecoder.decode(fn.get(), "UTF-8");            
         }
         Optional<String> ln = Stream.of(request.getCookies())
                                     .filter(c -> c.getName().equals("lastname"))
                                     .map(Cookie::getValue)
                                     .findAny();
         if(ln.isPresent()) {
            lastname = URLDecoder.decode(ln.get(), "UTF-8");            
         }
      };
      
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<title>Cookie Servlet</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<form method='post' >");
         out.println("Lastname: ");
         out.println("<input name='lastname' type='text' value='"
            + lastname + "'/><br />");
         out.println("Firstname: ");
         out.println("<input name='firstname' type='text' value='"
            + firstname + "'/><br />");
         out.println(
            "<input type='submit' value='Submit'/><br />");
         out.println("</form>");
         out.println("</body></html>");
      }
   }

   protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      String firstName = request.getParameter("firstname");
      String lastName = request.getParameter("lastname");
      Cookie firstnameCookie = new Cookie("firstname", URLEncoder
         .encode(firstName, "UTF-8"));
      Cookie lastnameCookie = new Cookie("lastname", URLEncoder
         .encode(lastName, "UTF-8"));
      firstnameCookie.setMaxAge(60);
      lastnameCookie.setMaxAge(60);
      response.addCookie(firstnameCookie);
      response.addCookie(lastnameCookie);
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.format("Hello %s %s", firstName, lastName);
      out.println("</body>");
      out.println("</html>");
      out.close();
   }
}
