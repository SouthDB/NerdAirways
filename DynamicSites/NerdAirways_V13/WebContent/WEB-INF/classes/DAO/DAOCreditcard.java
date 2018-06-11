package DAO;

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
		//emf = (EntityManagerFactory)sc.getAttribute("emf");
		emf = Persistence.createEntityManagerFactory((String)sc.getAttribute("persUnit"));
		em = emf.createEntityManager();
	}
	
	
	public AwCreditcard findCreditcard(long id) {
		AwCreditcard o =  em.find(AwCreditcard.class, id);
		em.close();
		
	   	return o;
	}
	
	public void saveCreditcard(String cardnr, String cardtype, String holder){
		AwCreditcard newcred = new AwCreditcard(cardnr, cardtype, holder);
			
		EntityTransaction tx = em.getTransaction();
			
		tx.begin();
		em.persist(newcred);
		tx.commit();
		em.close();
	}
	
	public void updateCreditcard(AwCreditcard cred, String cardnr, String cardtype, String holder){
		//neue Kreditkarten daten speichern
		cred.setCardtype(cardtype);
		cred.setHolder(holder);
		cred.setCardnr(cardnr);
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.merge(cred);
		tx.commit();
		em.close();
	}
		
		
}
