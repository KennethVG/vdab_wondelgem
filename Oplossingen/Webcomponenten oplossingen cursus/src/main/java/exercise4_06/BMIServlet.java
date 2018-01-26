package exercise4_06;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/exercise4_06/BMI")
public class BMIServlet extends HttpServlet {
   private BMIService service = new BMIService();

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      request.getRequestDispatcher("/WEB-INF/pages/exercise4_06/BMI.jsp").forward(request,
            response);
   }

   @Override
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws IOException, ServletException {
      float height = 0;
      float weight = 0;
      float bmi = 0;
      String errorHeight = null;
      String errorWeight = null;
      request.getSession().setAttribute("height", request.getParameter("height"));
      request.getSession().setAttribute("weight", request.getParameter("weight"));         
      request.getSession().removeAttribute("errorHeight");
      request.getSession().removeAttribute("errorWeight");         

      try {
         height = Float.parseFloat(request.getParameter("height")) / 100;
      } catch (NumberFormatException e) {
         errorHeight = "Invalid value";
      }
      try {
         weight = Float.parseFloat(request.getParameter("weight"));
      } catch (NumberFormatException e) {
         errorWeight = "Invalid value";
      }
      
      if(height < 0) {
         errorHeight = "Height must be > 0";
      }

      if(weight < 0) {
         errorWeight = "Weight must be > 0";
      }
      
      if(errorHeight == null && errorWeight == null) {
         bmi = service.calculateBMI(height, weight);
         request.getSession().setAttribute("bmi", bmi);         
      }
      else {
         request.getSession().setAttribute("errorHeight", errorHeight);
         request.getSession().setAttribute("errorWeight", errorWeight);         
      }
      //doGet(request,response);
      response.sendRedirect(request.getRequestURI());      
   }
}
