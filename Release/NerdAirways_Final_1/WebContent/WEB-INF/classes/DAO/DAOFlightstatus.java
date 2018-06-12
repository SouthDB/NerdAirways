package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import java.math.BigDecimal;
import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

public class DAOFlightstatus {
		private EntityManagerFactory emf = null;
		private EntityManager em = null;
		
		public DAOFlightstatus(EntityManagerFactory emf) {
			//emf = (EntityManagerFactory)sc.getAttribute("emf");
			//emf = Persistence.createEntityManagerFactory((String)sc.getAttribute("persUnit"));
			em = emf.createEntityManager();
		}
	
		
		public AwFlightstatus findStatus(BigDecimal id) {
	    	AwFlightstatus o = em.find(AwFlightstatus.class, id.longValue());
	    	em.close();
	    	
	    	return o;
	    }

}