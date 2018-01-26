package exercise5_04;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import exercise4_04.*;

@WebServlet("/exercise5_04/Address")
public class AddressServlet extends HttpServlet {
   private static final String BEAN_NAME = "address";
   private AddressService service;
   
   @Override
   public void init() throws ServletException {
      service = (AddressService) getServletContext().getAttribute(ApplicationListener.ADDRESS_SERVICE);
      if(service == null) {
         throw new ServletException("Service not available");
      }
   }
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      if (request.getSession().getAttribute(BEAN_NAME) != null) {
         request.getRequestDispatcher("/exercise5_04/AddressResult.jsp").forward(
               request, response);

      } else {
         request.getRequestDispatcher("/exercise5_04/AddressForm.jsp").forward(
               request, response);
      }
   }

   @Override
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws IOException, ServletException {
      AddressBean ab = new AddressBean();
      ab.setFirstName(request.getParameter("firstName"));
      ab.setLastName(request.getParameter("lastName"));
      ab.setStreet(request.getParameter("street"));
      ab.setNumber(request.getParameter("number"));
      ab.setZipCode(request.getParameter("zipCode"));
      ab.setCity(request.getParameter("city"));
      ab.setCountry(request.getParameter("country"));
      ab.setPhone(request.getParameter("phone"));
      ab.setEmail(request.getParameter("email"));
      service.registerAddress(ab);
      request.getSession().setAttribute(BEAN_NAME, ab);
      request.getRequestDispatcher("/exercise4_04/AddressResult.jsp").forward(
            request, response);
   }
}