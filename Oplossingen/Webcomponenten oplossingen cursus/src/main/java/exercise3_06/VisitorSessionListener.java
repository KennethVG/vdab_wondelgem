package exercise3_06;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

//@WebListener
public class VisitorSessionListener implements HttpSessionListener {
   public static final String TOTAL = "visitorsTotal";
   public static final String ACTIVE = "visitorsActive";

   public void sessionCreated(HttpSessionEvent se) {
      ServletContext sc = se.getSession().getServletContext();
      int visitorsTotal = 1;
      int visitorsActive = 1;

      Integer total = (Integer) sc.getAttribute(TOTAL);
      if (total != null) {
         visitorsTotal = total + 1;
      }
      sc.setAttribute(TOTAL, visitorsTotal);

      Integer active = (Integer) sc.getAttribute(ACTIVE);
      if (active != null) {
         visitorsActive = active + 1;
      }
      sc.setAttribute(ACTIVE, visitorsActive);

   }

   public void sessionDestroyed(HttpSessionEvent se) {
      ServletContext sc = se.getSession().getServletContext();
      Integer active = (Integer) sc.getAttribute(ACTIVE);

      int visitorsActive = 0;
      if (active != null) {
         visitorsActive = active - 1;
      }
      sc.setAttribute(ACTIVE, visitorsActive);
   }
}