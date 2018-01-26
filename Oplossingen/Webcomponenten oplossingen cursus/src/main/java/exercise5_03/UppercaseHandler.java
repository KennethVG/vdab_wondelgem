package exercise5_03;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class UppercaseHandler extends SimpleTagSupport {
   @Override
   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      //StringWriter sw = new StringWriter();
      UpperCaseWriter ucw = new UpperCaseWriter(out);
      getJspBody().invoke(ucw);
      //getJspBody().invoke(sw);
      //out.print(sw.toString().toUpperCase());
   }
}