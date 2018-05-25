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
	
	
		public void saveCreditcard(String cardnr, String cardtype, String holder, ServletContext sc){
			EntityManager em = (EntityManager)sc.getAttribute("em");
			
			AwCreditcard newcred = new AwCreditcard(cardnr, cardtype, holder);
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(newcred);
			tx.commit();
		}
		
}
