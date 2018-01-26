package exercise3_11;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/UploadDBImage", initParams = {
      @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
      @WebInitParam(name = "url", value = "jdbc:mysql://noelvaes.eu/StudentDB"),
      @WebInitParam(name = "user", value = "student"),
      @WebInitParam(name = "password", value = "student123") })
@MultipartConfig
public class UploadDBImageServlet extends HttpServlet {
   private String url;
   private String driver;
   private String user;
   private String password;
   private final static String QUERY = "INSERT INTO Images (image, name) VALUES(?,?)";

   public void init() throws ServletException {
      driver = getInitParameter("driver");
      url = getInitParameter("url");
      user = getInitParameter("user");
      password = getInitParameter("password");

      if (driver == null || url == null || user == null || password == null) {
         throw new ServletException("Init parameter missing");
      }

      try {
         Class.forName(driver);
      } catch (Exception ex) {
         throw new ServletException("Unable to load driver", ex);
      }
   }

   @Override
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      Part part = request.getPart("image");
      InputStream in = part.getInputStream();
      String fileName = request.getParameter("filename");
      try (Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(QUERY)) {
         stmt.setBinaryStream(1, in);
         stmt.setString(2, fileName);         
         stmt.executeUpdate();
      } catch (Exception e) {
         throw new ServletException(e);
      }

      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html><head><title>");
      out.println("Image Upload Servlet");
      out.println("</title></head>");
      out.println("<body>");
      out.println("Image uploaded!");
      out.println("</body></html>");
      out.close();
   }
}
