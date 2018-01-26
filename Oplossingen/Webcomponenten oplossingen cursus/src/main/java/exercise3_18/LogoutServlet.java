package exercise3_18;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      request.logout(); 
      response.sendRedirect(request.getServletContext().getContextPath());
   }
}
