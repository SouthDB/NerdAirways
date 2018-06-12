package servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EntityManagerLoader
 *
 */
@WebListener
public class ServletListener implements ServletContextListener {
	 

    /**
     * Default constructor. 
     */
    public ServletListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	//String persistenceUnit = "NerdAirways";
    	//sce.getServletContext().setAttribute("persUnit", persistenceUnit);
      
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("NerdAirways");
        sce.getServletContext().setAttribute("emf", emf);	
          
    	//EntityManager em = emf.createEntityManager();
    	//sce.getServletContext().setAttribute("em", em);	
    }
	
}
