package eu.noelvaes.web;

import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Addition")
public class AdditionServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.print("<html><head><title>Addition Servlet");
         out.print("</title></head><body>");
         out.print("<form method='POST' >");
         out.print("Enter two numbers:");
         out.print("<input type='number' name='number1'>");
         out.print("<input type='number' name='number2'>");
         out.print("<input type='submit' value='Calculate'>");
         out.print("</body></html>");
      }
   }

   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws IOException {
      String answer;
      try {
         int number1 = Integer.parseInt(request.getParameter("number1"));
         int number2 = Integer.parseInt(request.getParameter("number2"));
         answer = "The sum is " + (number1 + number2);
      } catch (NumberFormatException ex) {
         answer = "Invalid number";
      }
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");

      try (PrintWriter out = response.getWriter()) {
         out.print("<html><head><title>Addition Servlet");
         out.print("</title></head><body>");
         out.print(answer);
         out.print("</body></html>");
      }
   }
}