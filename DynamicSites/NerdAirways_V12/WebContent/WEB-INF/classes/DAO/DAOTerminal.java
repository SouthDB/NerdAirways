package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import java.math.BigDecimal;
import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

public class DAOTerminal {
		private EntityManagerFactory emf = null;
		private EntityManager em = null;
		
		public DAOTerminal(ServletContext sc) {
			emf = (EntityManagerFactory)sc.getAttribute("emf");
			em = emf.createEntityManager();
		}
		
		
		public AwTerminal findTerminal(BigDecimal id) {
			AwTerminal o = em.find(AwTerminal.class, id.longValue());
	    	em.close();
	    	
	    	return o;
	    }
		
}
		