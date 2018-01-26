package exercise6_01;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/GuestBookMVCDS", initParams = {
      @WebInitParam(name = "page", value = "/WEB-INF/pages/exercise6_01/GuestBook.jsp") })
public class GuestBookServlet extends HttpServlet {
   private String page;
   private GuestBookDao dao;

   public void init() throws ServletException {
      page = getInitParameter("page");
      if (page == null) {
         throw new ServletException("Init parameter missing");
      }
      dao = (GuestBookDao) getServletContext().getAttribute(ApplicationListener.GUESTBOOK_DAO);
      if (dao == null) {
         throw new ServletException("Dao missing");
      }  
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      try {
         List<GuestBookBean> messages = dao.getGuestBookItems();
         request.setAttribute("messages", messages);
         request.getRequestDispatcher(page).forward(request, response);

      } catch (SQLException e) {
         throw new ServletException(e);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {
         String name = request.getParameter("name");
         String message = request.getParameter("message");
         GuestBookBean item = new GuestBookBean(LocalDateTime.now(), name, message);
         dao.addGuestBookItem(item);
         response.sendRedirect(request.getRequestURI());
      } catch (SQLException ex) {
         throw new ServletException(ex);
      }
   }
}