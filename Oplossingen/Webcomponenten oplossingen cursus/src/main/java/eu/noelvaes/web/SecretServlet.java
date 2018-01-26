package eu.noelvaes.web;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Secret")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="Administrators"))
public class SecretServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws IOException {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html><head><title>Secret Servlet");
      out.println("</title></head><body>");
      out.println("This is a secret! Don't tell anybody.");
      out.println("</body></html>");
      out.close();
   }
}