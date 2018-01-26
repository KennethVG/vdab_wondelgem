package exercise3_08;

import java.io.*;
import java.util.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Resource")
public class ResourceServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      InputStream in = getServletContext().getResourceAsStream(
            "/WEB-INF/web.properties");
      Properties props = new Properties();
      props.load(in);
      in.close();
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      try (PrintWriter out = response.getWriter()) {
         out.println("<html><head><title>");
         out.println("Resource Servlet");
         out.println("</title></head>");
         out.println("<body><h1>");
         out.println(props.getProperty("header"));
         out.println("</h1></body></html>");
      }
   }
}
