package exercise5_02;

import java.io.IOException;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReverseHandler extends SimpleTagSupport {
   private StringBuffer text;

   public void setText(String value) {
      text = new StringBuffer(value);
   }

   public String getText() {
      return text.toString();
   }

   @Override
   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.print(text.reverse());
   }
}