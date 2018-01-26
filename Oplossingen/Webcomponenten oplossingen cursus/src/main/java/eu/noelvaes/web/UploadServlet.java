package eu.noelvaes.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      Part part = request.getPart("uploadfile");
      
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();      
      out.println("<html><head><title>Upload Servlet");
      out.println("</title></head><body>");
      out.println("File uploaded <br />");
      out.println("</body></html>");
      out.close();
   }

}
