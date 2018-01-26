package exercise3_11;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/Images", initParams = {
      @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
      @WebInitParam(name = "url", value = "jdbc:mysql://noelvaes.eu/StudentDB"),
      @WebInitParam(name = "user", value = "student"),
      @WebInitParam(name = "password", value = "student123") })
@MultipartConfig
public class ImageServlet extends HttpServlet {
   private String url;
   private String driver;
   private String user;
   private String password;
   private final static String UPDATE_QUERY = "INSERT INTO Images (name, image) VALUES(?,?)";
   private final static String SELECT_ALL_QUERY = "SELECT id,name FROM Images";

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
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      String id = req.getParameter("id");
      Map<Integer,String> images = new TreeMap<Integer,String>();
      if(id == null) {
         try (Connection con = DriverManager.getConnection(url, user, password);
               PreparedStatement stmt = con.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               images.put(rs.getInt("id"), rs.getString("name"));
            }
         } catch (Exception e) {
            throw new ServletException(e);
         }
      }

      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");
      PrintWriter out = resp.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html><head><title>");
      out.println("Image Servlet");
      out.println("</title>");
      out.println("</head>");
      out.println("<body>");
      for(int i: images.keySet()) {
         out.println(i + " : ");
         out.println("<a href='ImageDisplay?id="+ i + "' >");
         out.println(images.get(i) + " </a><br /> ");         
      }
      out.println("<form method='POST' enctype='multipart/form-data' >");
      out.println("Select image to upload : <br />"); 
      out.println("<input type='file' id='image' name='image' accept='image/jpeg' /><br />");
      out.println("Image name: <br />"); 
      out.println("<input type='text' id='filename' name='filename' /><br/>");      
      out.println("<input type='submit' value='Submit' />");
      out.println("</form>");
      out.println("</body></html>");
      out.close();      
   }

   @Override
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      Part part = request.getPart("image");
      String fileName = request.getParameter("filename");
      
      InputStream in = part.getInputStream();
      try (Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
         stmt.setString(1, fileName);
         stmt.setBinaryStream(2, in);
         stmt.executeUpdate();
      } catch (Exception e) {
         throw new ServletException(e);
      }
      
      doGet(request,response);
   }
}
