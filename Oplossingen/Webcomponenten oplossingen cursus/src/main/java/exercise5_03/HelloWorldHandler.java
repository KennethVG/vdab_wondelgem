package exercise5_03;

import java.io.IOException;
import java.util.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class HelloWorldHandler extends SimpleTagSupport implements
      DynamicAttributes {
   private Map<String, String> atts = new HashMap<String, String>();

   public void setDynamicAttribute(String uri, String name, Object value)
         throws JspException {
      if (uri == null) {
         // Only tags from default namespace
         atts.put(name, (String) value);
      }
   }

   @Override
   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.print("<span ");
      for (String att : atts.keySet()) {
         out.print(att + "='" + atts.get(att) + "'");
      }
      out.print(">");
      out.print("Hello World");
      out.print("</span>");

   }
}