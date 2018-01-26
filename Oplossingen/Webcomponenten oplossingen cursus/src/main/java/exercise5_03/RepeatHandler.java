package exercise5_03;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class RepeatHandler extends SimpleTagSupport {
   private int count;

   public void setCount(int count) {
      this.count = count;
   }

   public void doTag() throws JspException, IOException {
      for (int i = 0; i < count; i++) {
         getJspBody().invoke(null);
      }
   }
}