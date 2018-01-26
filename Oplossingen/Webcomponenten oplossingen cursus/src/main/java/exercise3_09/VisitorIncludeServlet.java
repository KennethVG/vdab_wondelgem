package exercise3_09;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

import exercise3_06.*;

@WebServlet(name = "VisitorIncludeServlet", value="/VisitorInclude")
public class VisitorIncludeServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      int total = (Integer) getServletContext().getAttribute(
            VisitorSessionListener.TOTAL);
      int active = (Integer) getServletContext().getAttribute(
            VisitorSessionListener.ACTIVE);
      @SuppressWarnings("resource")
      PrintWriter out = response.getWriter();
      out.println("Total visitors: " + total + "<br />");
      out.println("Current visitors: " + active + "<br/>");
   }
}