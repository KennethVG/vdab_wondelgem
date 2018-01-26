package exercise3_03;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Square")
public class SquareServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      String answer;
      try {
         int number = Integer.parseInt(request.getParameter("number"));
         answer = "The square of " + number + " is " + (number * number);
      } catch (NumberFormatException ex) {
         answer = "Invalid number";
      }
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html><head><title>Square Servlet</title></head>");
         out.println("<body>");
         out.println(answer);
         out.println("</body></html>");
      }
   }
}