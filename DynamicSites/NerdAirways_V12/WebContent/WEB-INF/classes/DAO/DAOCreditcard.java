package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.*;
import javax.servlet.ServletContext;

import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;
import java.math.BigDecimal;

public class DAOCreditcard {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOCreditcard(ServletContext sc) {
		emf = (EntityManagerFactory)sc.getAttribute("emf");
		em = emf.createEntityManager();
	}
	
	
	public void saveCreditcard(String cardnr, String cardtype, String holder){
		AwCreditcard newcred = new AwCreditcard(cardnr, cardtype, holder);
			
		EntityTransaction tx = em.getTransaction();
			
		tx.begin();
		em.persist(newcred);
		tx.commit();
		em.close();
		}
		
}
