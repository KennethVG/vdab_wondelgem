package eu.noelvaes.web;

import java.io.*;

public class HelloBean implements Serializable{
   private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
}
