package exercise4_04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    public static final String ADDRESS_SERVICE = "ADDRESS_SERVICE";

 
    public void contextInitialized(ServletContextEvent sce)  { 
         AddressService service = new AddressServiceImpl();
         sce.getServletContext().setAttribute(ADDRESS_SERVICE, service);
    }	

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

}
