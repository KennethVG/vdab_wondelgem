package exercise5_02;

import java.io.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CalculateHandler extends SimpleTagSupport {
   private int number1;
   private int number2;

   public void setNumber1(int value) {
      number1 = value;
   }

   public int getNumber1() {
      return number1;
   }

   public void setNumber2(int value) {
      number2 = value;
   }

   public int getNumber2() {
      return number2;
   }

   public void doTag() throws JspException, IOException {
      @SuppressWarnings("resource")
      JspWriter out = getJspContext().getOut();
      out.print(number1 * number2);
   }
}