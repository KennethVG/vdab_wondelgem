package eu.noelvaes.web;

import java.util.*;

public class BookServiceMemoryImpl implements BookService{
   private Map<String,Book> books = new HashMap<>();
   
   public BookServiceMemoryImpl() {
      books.put("0545139708",new Book("0545139708","Harry Potter and the Deathly Hallows","J.K. Rowling" ,15));
      books.put("0385504225",new Book("0545139708","The Lost Symbol","Dan Brown" ,18));
      books.put("015603297X",new Book("0545139708","Foucault's Pendulum","Umberto Ecco" ,12));   
   }   
   
   @Override
   public Book getBookByISBN(String isbn) {
      return books.get(isbn);
   }

   @Override
   public List<Book> getAllBooks() {      
      return new ArrayList<Book>(books.values()) ;
   }
}
