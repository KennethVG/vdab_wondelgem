package exercise3_07;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebListener
public class VisitorSessionListener implements HttpSessionListener, ServletContextListener {
   public static final String TOTAL = "visitorsTotal";
   public static final String ACTIVE = "visitorsActive";

   public void sessionCreated(HttpSessionEvent se) {
      System.out.println("Session created");

      ServletContext sc = se.getSession().getServletContext();

      synchronized (TOTAL) {
         Integer total = (Integer) sc.getAttribute(TOTAL);
         sc.setAttribute(TOTAL, total + 1);
      }

      synchronized (ACTIVE) {
         Integer active = (Integer) sc.getAttribute(ACTIVE);
         sc.setAttribute(ACTIVE, active + 1);
      }
   }

   public void sessionDestroyed(HttpSessionEvent se) {
      System.out.println("Session destroyed");
      ServletContext sc = se.getSession().getServletContext();
      synchronized (ACTIVE) {
         Integer active = (Integer) sc.getAttribute(ACTIVE);
         sc.setAttribute(ACTIVE, active - 1);
      }
   }

   public void contextInitialized(ServletContextEvent sce) {
      System.out.println("Context initialized");
      sce.getServletContext().setAttribute(ACTIVE, 0);
      sce.getServletContext().setAttribute(TOTAL, 0);
   }

   public void contextDestroyed(ServletContextEvent sce) {
      System.out.println("Context destroyed");
   }
}