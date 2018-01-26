package eu.noelvaes.web;

import java.io.*;

public class Book implements Serializable {
   private String isbn;
   private String title;
   private String author;
   private int price;

   public Book() {
   }

   public Book(String isbn, String title, String author, int price) {
      this.isbn = isbn;
      this.title = title;
      this.author = author;
      this.price = price;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getIsbn() {
      return isbn;
   }

   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
   }

   public int getPrice() {
      return price;
   }

   public String toString() {
      return isbn + " " + title + " " + author + " " + price;
   }
}
