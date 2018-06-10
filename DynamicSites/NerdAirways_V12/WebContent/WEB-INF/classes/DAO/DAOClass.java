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

public class DAOClass {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOClass(ServletContext sc) {
		emf = (EntityManagerFactory)sc.getAttribute("emf");
		em = emf.createEntityManager();
	}
	
	
	public AwClass findClass(BigDecimal id) {
		AwClass o = em.find(AwClass.class, id.longValue());
		em.close();
		
		return o;
	}
	
}
