package exercise3_05;
import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Calculator")
public class CalculatorServlet extends HttpServlet {
   private final String RESULT = "CalculatorServlet.result";

   public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
      int result = 0;
      String message = "";
      HttpSession session = request.getSession();
      synchronized (session) {
         Object o = session.getAttribute(RESULT);
         String number = request.getParameter("number");
         String button = request.getParameter("button");
         if (o != null) {
            result = (Integer) o;
         }
         if (number != null) {
            try {
               if (button.equals("CE"))
                  result = 0;
               else {
                  int n = Integer.parseInt(number);
                  switch (button) {
                  case "+":
                     result += n;
                     break;
                  case "-":
                     result -= n;
                     break;
                  case "*":
                     result *= n;
                     break;
                  case "/":
                     result /= n;
                     break;
                  }
               }
            } catch (NumberFormatException ex) {
               message = "Invalid number";
            }
         }
         session.setAttribute(RESULT, result);
      }
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html><head><title>Calculator");
         out.println("</title></head><body>");
         out.print("<form method='get' action='" + response
            .encodeURL(request.getServletPath().substring(1))
            + "'>");
         out.print(message + "<br />");
         out.println("Result: " + result + "<br/>");
         out.println("<input type='number' name='number'><br />");
         out.println(
            "<input type='submit' value='+' name='button'>");
         out.println(
            "<input type='submit' value='-' name='button'>");
         out.println(
            "<input type='submit' value='*' name='button'>");
         out.println(
            "<input type='submit' value='/' name='button'>");
         out.println(
            "<input type='submit' value='CE' name='button'>");
         out.println("</form></body></html>");
      }
   }
}