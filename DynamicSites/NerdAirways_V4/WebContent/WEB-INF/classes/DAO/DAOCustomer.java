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

public class DAOCustomer {
	
	
		public void saveCustomer(String adress, Date birthdate, BigDecimal counid, String email, String fname, String gender, String place, String plz, String pw, String sname, String username, ServletContext sc){
			EntityManager em = (EntityManager)sc.getAttribute("em");
			
			//Letzte generierte ID aus AwCreditcard abfragen
			Query q = em.createNativeQuery("SELECT aw_cred_seq.nextval FROM DUAL");
			BigDecimal credid = (java.math.BigDecimal)q.getSingleResult();
			BigDecimal eins = new BigDecimal("1");
			BigDecimal credid2 = credid.subtract(eins);
			System.out.println("Credid: " + credid2);
			
			AwCustomer newcust = new AwCustomer(adress, birthdate, counid, credid2, email, fname, gender, place, plz, pw, sname, username);
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(newcust);
			tx.commit();
		}
		
}
