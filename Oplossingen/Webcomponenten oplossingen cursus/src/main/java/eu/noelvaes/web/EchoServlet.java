package eu.noelvaes.web;

import java.io.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Echo")
public class EchoServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      // Stap 1: retrieve parameters
      request.setCharacterEncoding("UTF-8");
      String text = request.getParameter("text");
      log(text);
      // Stap 2: generate content

      // Stap 3: set headers for response
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");

      // Stap 4: get PrintWriter
      try (PrintWriter out = response.getWriter()) {

         // Stap 5: write content
         out.println("<html><head><title>Echo Servlet");
         out.println("</title></head><body>");
         out.println(text);
         out.println("</body></html>");
      }
   }
}