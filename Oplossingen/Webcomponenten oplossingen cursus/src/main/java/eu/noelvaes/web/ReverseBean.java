package eu.noelvaes.web;

public class ReverseBean implements java.io.Serializable {
   private String text;

   public void setText(String text) {
      this.text = text;
   }

   public String getText() {
      return text;
   }

   public String getReverse() {
      StringBuilder sb = new StringBuilder(text);
      return sb.reverse().toString();
   }
}