package exercise3_07;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener{
   public final static String GUESTBOOK_DAO = "GuestBook";
   
   @Override
   public void contextDestroyed(ServletContextEvent sce) {
   }

   @Override
   public void contextInitialized(ServletContextEvent sce) {
      ServletContext sc = sce.getServletContext();
      try {
         String driver = sc.getInitParameter("driver");
         String url = sc.getInitParameter("url");
         String user = sc.getInitParameter("user");
         String password = sc.getInitParameter("password");

         if (driver == null || url == null || user == null || password == null) {
            throw new RuntimeException("Init parameter missing");
         }

         GuestBookDao dao = new GuestBookDao();
         dao.setDriver(driver);
         dao.setUrl(url);
         dao.setUser(user);
         dao.setPassword(password);
         sc.setAttribute(GUESTBOOK_DAO, dao);
      } catch (ClassNotFoundException ex) {
         throw new RuntimeException("Unable to initialize DAO ", ex);
      }
      sc.log("GuestBookDao initialized");
   }

}
