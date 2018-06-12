package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.math.BigDecimal;
import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

public class DAOFlight {
	private EntityManager em = null;
	
	public DAOFlight(EntityManagerFactory emf) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
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