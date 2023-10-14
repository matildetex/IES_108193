package pt.deti.ies;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.servlet.ServletHandler;
 
public class EmbeddedJettyExample {
 
    public static void main(String[] args) throws Exception {
         
        Server server = new Server(8680);       
         
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
                 
        servletHandler.addServletWithMapping(HelloServlet.class, "/");
         
        server.start();
        server.join();
 
    }
     
    public static class HelloServlet extends HttpServlet 
    {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            String messageParam = request.getParameter("msg");
            if(messageParam == null){
              String messageDefault= "Mensagem Default: Hello World";
              response.setContentType("text/html");
              response.setStatus(HttpServletResponse.SC_OK);
              response.getWriter().println("<h1>"+ messageDefault + "</h1>"); 
            }
            else{
              response.setContentType("text/html");
              response.setStatus(HttpServletResponse.SC_OK);
              response.getWriter().println("<h1>"+ messageParam + "</h1>"); 
            }
        } 
    }
 }