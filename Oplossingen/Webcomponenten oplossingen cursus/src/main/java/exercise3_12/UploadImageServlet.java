package exercise3_11;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UploadImage")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {      
      Part part = request.getPart("image");      
      InputStream in = part.getInputStream();      
      response.setContentType("image/jpeg");      
      OutputStream out = response.getOutputStream();
      int b = 0;
      while((b = in.read()) != -1) {
         out.write(b);
      }
      out.close();
      in.close();
   }
}
