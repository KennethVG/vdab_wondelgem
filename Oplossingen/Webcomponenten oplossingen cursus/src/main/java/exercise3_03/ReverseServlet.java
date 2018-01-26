package exercise3_03;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Reverse")
public class ReverseServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      String param = request.getParameter("text");
      StringBuilder text = new StringBuilder(param);
      text.reverse();
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html><head><title>Reverse Servlet</title></head>");
         out.println("<body>");
         out.println(text);
         out.println("</body></html>");
      }
   }
}