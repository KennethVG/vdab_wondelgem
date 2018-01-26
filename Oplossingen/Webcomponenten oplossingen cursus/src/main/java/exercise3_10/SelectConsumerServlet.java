package exercise3_10;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/SelectConsumer")
public class SelectConsumerServlet extends HttpServlet {
   public void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

      String page = "exercise3_10/SelectConsumer.html";
      String consumption = req.getParameter("consumption");
      if (consumption != null) {
         int cons;
         try {
            cons = Integer.parseInt(consumption);
            if (cons < 2000) {
               page = "exercise3_10/SmallConsumer.html";
            } else {
               page = "exercise3_10/BigConsumer.html";
            }
         } catch (NumberFormatException ex) {
            page = "exercise3_10/Invalid.html";
         }
      }

      RequestDispatcher disp = req.getRequestDispatcher(page);
      disp.forward(req, resp);
   }
}
