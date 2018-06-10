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

public class DAOReview {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOReview(ServletContext sc) {
		emf = (EntityManagerFactory)sc.getAttribute("emf");
		em = emf.createEntityManager();
	}
	
	
	public List<String> listAll(){		
	    Query query = em.createQuery("SELECT x from AwReview x ORDER BY x.id");
	    Collection<AwReview> list = (Collection<AwReview>)query.getResultList();
		ArrayList<String> slist = new ArrayList<>();
		em.close();
		
		for (AwReview o : list) {
			System.out.println("\nReview ::" + o);
			String newEle = "" + o;
			slist.add(newEle);
		}
		
		return slist;
	}
	
	public void saveReview(BigDecimal bookingid, BigDecimal rating, String text){
		AwReview newrev = new AwReview(bookingid, rating, text);
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(newrev);
		tx.commit();
		em.close();
	}

}
