package exercise3_06;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Visitors")
public class VisitorServlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      request.getSession();

      int total = (Integer) getServletContext().getAttribute(
            VisitorSessionListener.TOTAL);
      int active = (Integer) getServletContext().getAttribute(
            VisitorSessionListener.ACTIVE);
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html><head><title>");
         out.println("Visitors");
         out.println("</title></head>");
         out.println("<body>");
         out.println("Total visitors: " + total + "<br />");
         out.println("Current visitors: " + active + "<br/>");
         out.println("</body></html>");
      }
   }
}
