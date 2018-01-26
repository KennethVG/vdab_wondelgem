package eu.noelvaes.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/HelloMVC")
public class HelloMVCServlet extends HttpServlet {
   private HelloService service = new HelloService();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      request.getRequestDispatcher("/WEB-INF/pages/HelloForm.jsp").forward(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      HelloBean hb = new HelloBean();
      hb.setName(request.getParameter("name"));
      service.handleHello(hb);
      request.setAttribute("helloBean", hb);
      request.getRequestDispatcher("/WEB-INF/pages/HelloResult.jsp").forward(request, response);
   }   
}