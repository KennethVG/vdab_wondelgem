package eu.noelvaes.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Books")
public class BookServlet extends HttpServlet {
   private BookService service = new BookServiceMemoryImpl();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      String isbn = req.getParameter("isbn");
      if (isbn == null) {
         List<Book> books = service.getAllBooks();
         req.setAttribute("books", books);
         req.getRequestDispatcher("/BookList.jsp").forward(req, resp);
      } else {
         Book book = service.getBookByISBN(isbn);
         req.setAttribute("book", book);
         req.getRequestDispatcher("/BookDetail.jsp").forward(req, resp);
      }
   }
}
