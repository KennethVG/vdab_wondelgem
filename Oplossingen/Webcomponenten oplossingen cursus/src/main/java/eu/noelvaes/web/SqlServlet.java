package eu.noelvaes.web;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.annotation.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
   @Resource(name = "jdbc/StudentDS")
   private DataSource ds;

   private SqlService service;

   @Override
   public void init() throws ServletException {
      service = new SqlService(ds);
   }

   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
         throws ServletException, IOException {
      try {
         String query = request.getParameter("query");
         if (query != null) {
            List<String[]> result = service.getResult(query);
            request.setAttribute("result", result);
         }
      } catch (SQLException ex) {
         request.setAttribute("error", ex.getMessage());
      }
      request.getRequestDispatcher("/Sql.jsp").forward(request,
                                                       response);
   }
}
