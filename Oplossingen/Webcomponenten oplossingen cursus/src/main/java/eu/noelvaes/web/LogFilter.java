package eu.noelvaes.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebFilter(urlPatterns="/*")
public class LogFilter implements Filter {
   public void init(FilterConfig fConfig) throws ServletException {
   }

   public void destroy() {
   }

   public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain chain) throws IOException, ServletException {
      HttpServletRequest req = (HttpServletRequest) request;
      Date now = new Date();
      String message = String.format("%td/%<tm/%<tY %<tH:%<tM:%<tS %s %s\n",
            now, req.getRequestURL(), req.getRemoteHost());
      req.getServletContext().log(message);
      chain.doFilter(request, response);
   }

}
