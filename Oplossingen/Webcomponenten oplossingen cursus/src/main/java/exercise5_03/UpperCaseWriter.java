package exercise5_03;

import java.io.*;

public class UpperCaseWriter extends FilterWriter {
   public UpperCaseWriter(Writer out) {
      super(out);
   }

   @Override
   public void write(char[] cbuf, int off, int len) throws IOException {
      for(int i= 0; i < len; i++) {
         write(cbuf[off+i]);
      }
   }

   @Override
   public void write(String str, int off, int len) throws IOException {
      for(int i= 0; i < len; i++) {
         write(str.charAt(off+i));
      }
   }

   @Override
   public void write(int c) throws IOException {
      if (c != -1) {
         super.write(Character.toUpperCase(c));
      } else {
         super.write(c);
      }
   }
}
