package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import java.math.BigDecimal;
import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

public class DAOFlight {
	
	public Collection<AwFlight> listAll(ServletContext sc) {
		EntityManager em = (EntityManager)sc.getAttribute("em");
		return em.createNamedQuery("AwFlight.findAll").getResultList();
	}

	public AwFlight findFlightnr(BigDecimal id, ServletContext sc) {
		EntityManager em = (EntityManager) sc.getAttribute("em");
		return em.find(AwFlight.class, id.longValue());
	}
	
}