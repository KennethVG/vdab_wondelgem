package exercise3_11;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/ImageDisplay", initParams = {
      @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
      @WebInitParam(name = "url", value = "jdbc:mysql://noelvaes.eu/StudentDB"),
      @WebInitParam(name = "user", value = "student"),
      @WebInitParam(name = "password", value = "student123") })
@MultipartConfig
public class ImageDisplayServlet extends HttpServlet {
   private String url;
   private String driver;
   private String user;
   private String password;
   private final static String QUERY = "SELECT image FROM Images WHERE id=?";

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
      int id = Integer.parseInt(req.getParameter("id"));
      resp.setContentType("image/jpeg");
      OutputStream out = resp.getOutputStream();

      try (Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(QUERY)) {
         stmt.setInt(1, id);
         ResultSet rs = stmt.executeQuery();
         if (rs.next()) {
            InputStream in = rs.getBinaryStream(1);
            int c = 0;
            while ((c = in.read()) != -1) {
               out.write(c);
            }
         }
      } catch (Exception e) {
         throw new ServletException(e);
      }
      out.close();
   }
}
