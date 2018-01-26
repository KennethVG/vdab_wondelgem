package exercise3_09;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Including")
public class IncludingServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.getSession();
      response.setContentType("text/html");
      try (PrintWriter out = response.getWriter()) {
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Including Servlet</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<div>Including another servlet</div>");

         RequestDispatcher disp = getServletContext().getNamedDispatcher(
               "VisitorIncludeServlet");
         disp.include(request, response);

         disp = request.getRequestDispatcher("exercise3_09/included.html");
         disp.include(request, response);

         out.println("</body>");
         out.println("</html>");
      }
   }
}
