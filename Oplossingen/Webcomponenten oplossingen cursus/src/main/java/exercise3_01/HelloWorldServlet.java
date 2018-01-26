package exercise3_01;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/HelloWorld")
public class HelloWorldServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Hello World Servlet</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("Hello World");
         out.println("</body>");
         out.println("</html>");
      } 
   }
}