package exercise6_01;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ApplicationListener implements ServletContextListener {
   public static final String GUESTBOOK_DAO = "GUESTBOOK_DAO";
   @Resource(name = "jdbc/GuestBookDS")
   private DataSource ds;

   public void contextInitialized(ServletContextEvent sce) {
      GuestBookDao dao = new GuestBookDao();
      dao.setDataSource(ds);
      sce.getServletContext().setAttribute(GUESTBOOK_DAO, dao);
   }

   public void contextDestroyed(ServletContextEvent sce) {
   }

}
