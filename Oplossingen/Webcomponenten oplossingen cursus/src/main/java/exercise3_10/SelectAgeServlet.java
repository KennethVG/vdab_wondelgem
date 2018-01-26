package exercise3_10;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/SelectAge")
public class SelectAgeServlet extends HttpServlet {
   public void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

      String page = "exercise3_10/SelectAge.html";
      String consumption = req.getParameter("age");
      if (consumption != null) {
         int age;
         try {
            age = Integer.parseInt(consumption);
            if (age < 0) {
               page = "exercise3_10/Invalid.html";
            } else if (age <=9) {
               page = "exercise3_10/Child.html";
            } else  if (age <= 19){
               page = "exercise3_10/Teenager.html";
            } else {
               page = "exercise3_10/Adult.html";
            }            
         } catch (NumberFormatException ex) {
            page = "exercise3_10/Invalid.html";
         }
      }

      RequestDispatcher disp = req.getRequestDispatcher(page);
      disp.forward(req, resp);
   }
}
