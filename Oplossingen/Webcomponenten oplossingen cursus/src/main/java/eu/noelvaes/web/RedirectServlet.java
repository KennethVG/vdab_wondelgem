package eu.noelvaes.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/Redirect", initParams = @WebInitParam(name = "url", value = "http://www.noelvaes.eu"))
public class RedirectServlet extends HttpServlet {
   private String url;

   public void init() throws ServletException {
      url = getInitParameter("url");
      if (url == null) {
         throw new ServletException("url null");
      }
   }

   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      resp.sendRedirect(url);
   }
}
