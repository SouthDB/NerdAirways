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

public class DAOLuggage {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOLuggage(ServletContext sc) {
		emf = (EntityManagerFactory)sc.getAttribute("emf");
		em = emf.createEntityManager();
	}
	
	
	public AwLuggage findLuggage(BigDecimal id) {
		AwLuggage o = em.find(AwLuggage.class, id.longValue());
		em.close();
		
		return o;
	}

}
