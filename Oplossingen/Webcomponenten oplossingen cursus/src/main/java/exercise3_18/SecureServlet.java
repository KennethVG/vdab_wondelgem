package exercise3_18;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value="/SecuredServlet",name="SecureServlet")
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"Administrators","Guests"}))
public class SecureServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      // if (request.authenticate(response)) {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html><head><title>Secret Servlet");
      out.println("</title></head><body>");
      out.println("Hello " + request.getRemoteUser() + "<br />");
      if (request.isUserInRole("Admin")) {
         out.println("You are an administrator so I can tell you more ... <br />");
      } else if (request.isUserInRole("User")) {
         out.println("You are guest so I can't tell you all the details.<br />");
      }
      out.println("</body></html>");
      out.close();
      // }
   }
}
