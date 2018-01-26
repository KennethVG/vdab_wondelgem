package exercise5_01;

import java.io.IOException;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldHandler extends SimpleTagSupport {
   @Override
   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.print("Hello World");
   }
}