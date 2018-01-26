package exercise3_14;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebFilter(filterName = "encodingFilter", urlPatterns = "/*",
           initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
public class EncodingFilter implements Filter {
   private String encoding;

   public void init(FilterConfig config) throws ServletException {
      encoding = config.getInitParameter("encoding");
   }

   public void destroy() {
   }

   public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain chain) throws IOException, ServletException {
      request.setCharacterEncoding(encoding);
      response.setCharacterEncoding(encoding);
      chain.doFilter(request, response);
   }
}
