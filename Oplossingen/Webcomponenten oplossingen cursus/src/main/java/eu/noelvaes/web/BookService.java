package eu.noelvaes.web;

import java.util.*;

public interface BookService {
   public Book getBookByISBN(String isbn);
   public List<Book> getAllBooks();

}
