package eu.noelvaes.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

//@WebFilter(value = "/Contact.xml", initParams = @WebInitParam(name = "stylesheet", value = "Contact2Html.xsl"))
public class XsltFilter implements Filter {
   private FilterConfig config;
   private Transformer transformer;
   private String contentType;

   public void init(FilterConfig config) throws ServletException {
      this.config = config;
      String xsl = config.getInitParameter("stylesheet");

      // Create transform
      try (InputStream xsltStream = config.getServletContext()
            .getResourceAsStream(xsl)) {
         TransformerFactory tf = TransformerFactory.newInstance();

         StreamSource xsltSrc = new StreamSource(xsltStream);

         // Create transformer to apply stylesheet
         transformer = tf.newTransformer(xsltSrc);

         // Get contenttype
         contentType = "text/" + transformer.getOutputProperty("method");
      } catch (Exception ex) {
         config.getServletContext().log("Error in XsltFilter.init()", ex);
         throw new ServletException("Error initializeing XsltFilter", ex);
      }
   }

   public void destroy() {
   }

   public void doFilter(ServletRequest req, ServletResponse res,
         FilterChain chain) throws IOException, ServletException {
      HttpServletRequest request = (HttpServletRequest) req;
      HttpServletResponse response = (HttpServletResponse) res;

      XsltRequestWrapper requestWrapper = new XsltRequestWrapper(request);
      XsltResponseWrapper responseWrapper = new XsltResponseWrapper(response);

      /* We get the document from the chain */
      chain.doFilter(requestWrapper, responseWrapper);

      /* We now transform it with the stylesheet */
      try (OutputStream out = response.getOutputStream();
      // Create input source
            InputStream inStream = responseWrapper.getInputStream();) {
         StreamSource inSrc = new StreamSource(inStream);

         // Create result object
         StreamResult result = new StreamResult(out);

         synchronized (transformer) {
            // Set content-type
            response.setContentType(contentType);

            // Transform
            transformer.transform(inSrc, result);
         }
      } catch (Exception ex) {
         config.getServletContext().log("Error in XsltFilter.doFilter()", ex);
         throw new ServletException(ex);
      }
   }
}

class XsltResponseWrapper extends HttpServletResponseWrapper {
   private ByteArrayOutputStream baos = new ByteArrayOutputStream(20000);

   private PrintWriter pw = new PrintWriter(baos);

   private ByteArrayServletOutputStream basos = new ByteArrayServletOutputStream(
         baos);

   XsltResponseWrapper(HttpServletResponse response) {
      super(response);
   }

   public PrintWriter getWriter() {
      return pw;
   }

   public ServletOutputStream getOutputStream() {
      return basos;
   }

   public void setContentLength(int length) {
      // ignore this
   }

   InputStream getInputStream() {
      return new ByteArrayInputStream(baos.toByteArray());
   }

}

class XsltRequestWrapper extends HttpServletRequestWrapper {
   XsltRequestWrapper(HttpServletRequest request) {
      super(request);
   }

   public long getDateHeader(String name) {
      if (name.equalsIgnoreCase("if-modified-since"))
         return -1;
      return super.getDateHeader(name);
   }

   public String getHeader(String name) {
      if (name.equalsIgnoreCase("if-none-match"))
         return null;
      return super.getHeader(name);
   }

}

class ByteArrayServletOutputStream extends ServletOutputStream {
   ByteArrayOutputStream baos;

   public ByteArrayServletOutputStream(ByteArrayOutputStream baos) {
      this.baos = baos;
   }

   public void write(int c) throws IOException {
      baos.write(c);
   }

   @Override
   public boolean isReady() {
      return true;
   }

   @Override
   public void setWriteListener(WriteListener writeListener) {
   }

}