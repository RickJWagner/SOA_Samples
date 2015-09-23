package sampleservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
 


public class SampleServlet extends HttpServlet {
 
  private String message;
  static final Logger LOGGER =  Logger.getLogger(SampleServlet.class);

  public void init() throws ServletException
  {
      message = "Hello World";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {

      LOGGER.info("this is a debug log message");
      System.out.println("System.out.println here!"); 
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
  }
  
  public void destroy()
  {
      // do nothing.
  }
}
