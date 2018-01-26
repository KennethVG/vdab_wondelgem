package exercise5_13;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/GuestBookMVC", initParams = {
      @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
      @WebInitParam(name = "url", value = "jdbc:mysql://noelvaes.eu/GuestBookDB"),
      @WebInitParam(name = "user", value = "student"),
      @WebInitParam(name = "password", value = "student123"),
      @WebInitParam(name = "page", value = "/WEB-INF/pages/exercise5_13/GuestBook.jsp"), })
public class GuestBookServlet extends HttpServlet {
   private GuestBookDao dao;
   private String page;

   public void init() throws ServletException {
      try {
         String driver = getInitParameter("driver");
         String url = getInitParameter("url");
         String user = getInitParameter("user");
         String password = getInitParameter("password");
         page = getInitParameter("page");
         if (driver == null || url == null || user == null || password == null
               || page == null) {
            throw new ServletException("Init parameter missing");
         }
         dao = new GuestBookDao();
         dao.setDriver(driver);
         dao.setUser(user);
         dao.setPassword(password);
         dao.setUrl(url);
      } catch (ClassNotFoundException ex) {
         throw new ServletException("Unable to load driver", ex);
      }
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      try {
         List<GuestBookBean> messages = dao.getGuestBookItems(); 
         request.setAttribute("messages", messages);
         request.getRequestDispatcher(page).forward(request, response);
      } catch (SQLException e) {
         throw new ServletException(e);
      }
   }

   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      try {
         String name = request.getParameter("name");
         String message = request.getParameter("message");
         GuestBookBean item = new GuestBookBean(LocalDateTime.now(),name,message);
         dao.addGuestBookItem(item);
         response.sendRedirect(request.getRequestURI());
      } catch (SQLException ex) {
         throw new ServletException(ex);
      }
   }
}