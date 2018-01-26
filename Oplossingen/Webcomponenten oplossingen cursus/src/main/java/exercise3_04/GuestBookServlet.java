package exercise3_04;
import java.io.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/GuestBook", initParams = {
   @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
   @WebInitParam(name = "url", value = "jdbc:mysql://noelvaes.eu/GuestBookDB"),
   @WebInitParam(name = "user", value = "student"),
   @WebInitParam(name = "password", value = "student123") })
public class GuestBookServlet extends HttpServlet {
   private GuestBookDao dao;

   public void init() throws ServletException {
      try {
         String driver = getInitParameter("driver");
         String url = getInitParameter("url");
         String user = getInitParameter("user");
         String password = getInitParameter("password");
         if (driver == null || url == null || user == null
            || password == null) {
            throw new ServletException("Init parameter missing");
         }
         dao = new GuestBookDao();
         dao.setDriver(driver);
         dao.setUrl(url);
         dao.setUser(user);
         dao.setPassword(password);
      } catch (ClassNotFoundException ex) {
         throw new ServletException("Unable to initialize DAO ",
            ex);
      }
   }

   protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws IOException,
      ServletException {
      try (PrintWriter out = response.getWriter()) {
         List<GuestBookBean> items = dao.getGuestBookItems();
         response.setContentType("text/html");
         response.setCharacterEncoding("UTF-8");
         out.println("<html><head>");
         out.println("<title>Guestbook</title>");
         out.println("</head><body>");
         items.forEach(i -> out.format(
            "<p>[%td/%<tm/%<tY %<tT] %s:%s</p>", i.getDate(), i
               .getName(), i.getMessage().replaceAll("&", "&amp;")
                  .replaceAll("<", "&lt;")));
         out.print("<form method='POST' >");
         out.print("Name: ");
         out.print("<input type='text' name='name' /><br />");
         out.print(
            "<textarea cols='50' rows='10' name='message'>");
         out.print("</textarea>");
         out.print("<br/><input type='submit' value='Submit' />");
         out.print("</form></body></html>");
      } catch (SQLException e) {
         throw new ServletException(e);
      }
   }

   protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
      try {
         request.setCharacterEncoding("UTF-8");
         String name = request.getParameter("name");
         String message = request.getParameter("message");
         GuestBookBean item = new GuestBookBean();
         item.setDate(LocalDateTime.now());
         item.setMessage(message);
         item.setName(name);
         dao.addGuestBookItem(item);
         log("Message added: " + name + " : " + message);
         doGet(request, response);
      } catch (SQLException ex) {
         throw new ServletException(ex);
      }
   }
}
