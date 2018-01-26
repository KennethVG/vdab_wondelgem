package eu.noelvaes.web;

import java.io.*;
import java.net.URLDecoder;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/SelectLanguage")
public class LanguageServlet extends HttpServlet {
   public static final String LANGUAGE = "language";

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF8");
      String language = null;
      // Get language from cookie
      Cookie cookies[] = request.getCookies();
      if (cookies != null) {
         Optional<String> ol = Stream.of(cookies)
                                     .filter(c -> c.getName().equals(LANGUAGE))
                                     .map(Cookie::getValue)
                                     .findAny();
         if(ol.isPresent()) {
            language = URLDecoder.decode(ol.get(), "UTF-8");            
         }
      }
      
      // Get language from request parameter
      if (language == null) {
         language = request.getParameter(LANGUAGE);
         if (language != null) {
            // Create new cookie
            Cookie cookie = new Cookie(LANGUAGE, language);
            cookie.setMaxAge(60);
            response.addCookie(cookie);
         }
      }
      try (PrintWriter out = response.getWriter()) {
         out.println("<html><header>");
         out.println("<title>Language Selection</title>");
         out.println("</header><body>");
         if (language == null) {
            // Print choices
            out.print("<a href='SelectLanguage?language=en'>");
            out.print("English</a><br/>");
            out.print("<a href='SelectLanguage?language=nl'>");
            out.print("Nederlands</a><br/>");
            out.print("<a href='SelectLanguage?language=fr'>");
            out.print("Français</a><br/>");
         } else {
            switch (language) {
            case "en":
               out.println("English version");
               break;
            case "nl":
               out.println("Nederlandse versie");
               break;
            case "fr":
               out.println("Version française");
               break;
            }
         }
         out.println("</body></html>");
      }
   }
}