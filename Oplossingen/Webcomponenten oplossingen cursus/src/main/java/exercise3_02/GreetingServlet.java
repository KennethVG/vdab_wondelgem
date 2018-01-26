package exercise3_02;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "GreetingServlet", value = "/Greeting", initParams = {
      @WebInitParam(name = "greeting", value = "Hello World"),
      @WebInitParam(name = "font-size", value = "12") }, loadOnStartup = 1)
public class GreetingServlet extends HttpServlet {
   private String text;
   private int fontSize;

   public void init() throws ServletException {
      log("init()");
      text = getInitParameter("greeting");
      if (text == null) {
         throw new ServletException("Parameter 'greeting' not found");
      }

      String size = getInitParameter("font-size");
      if (size == null) {
         throw new ServletException("Parameter 'font-size' not found");
      }
      fontSize = Integer.parseInt(size);
   }

   public void destroy() {
      log("destroy()");
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Greeting Servlet</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<div style='font-size:" + fontSize + "px'>");
         out.println(text);
         out.println("</div>");
         out.println("</body>");
         out.println("</html>");
      }
   }
}