package exercise4_05;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/exercise4_05/BMI")
public class BMIServlet extends HttpServlet {
   private BMIService service = new BMIService();

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      request.getRequestDispatcher("/WEB-INF/pages/exercise4_05/BMI.jsp").forward(request,
            response);
   }

   @Override
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws IOException, ServletException {
      float height = Float.parseFloat(request.getParameter("height")) /100;
      float weight = Float.parseFloat(request.getParameter("weight"));
      float bmi = service.calculateBMI(height, weight);
      
      //request.setAttribute("bmi",bmi);
      //doGet(request,response);

      // or
      
      request.getSession().setAttribute("bmi",bmi);
      response.sendRedirect(request.getRequestURI());      
   }
}
