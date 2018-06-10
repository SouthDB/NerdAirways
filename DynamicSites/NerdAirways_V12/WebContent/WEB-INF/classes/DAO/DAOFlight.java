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

public class DAOFlight {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOFlight(ServletContext sc) {
		emf = (EntityManagerFactory)sc.getAttribute("emf");
		em = emf.createEntityManager();
	}
	
	
	public AwFlight findFlightnr(BigDecimal id) {
		AwFlight o = em.find(AwFlight.class, id.longValue());
		em.close();
		
		return o;
	}
	
	public Collection<AwFlight> listAll() {
		Query query =  em.createNamedQuery("AwFlight.findAll");
		Collection<AwFlight> o = (Collection<AwFlight>)query.getResultList();
		em.close();
		
		return o;
	}

}