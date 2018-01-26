package exercise5_03;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class FormatHandler extends SimpleTagSupport implements
      DynamicAttributes {
   private Map<String, String> atts = new HashMap<String, String>();

   public void setDynamicAttribute(String ns, String name,
         Object value) throws JspException {
      atts.put(name,(String) value);
   }

   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.print("<div ");
      for (String att : atts.keySet()) {
         out.print(att + "='" + atts.get(att) + "'");
      }
      out.print(">");
      getJspBody().invoke(out);
      out.print("</div>");
   }
}