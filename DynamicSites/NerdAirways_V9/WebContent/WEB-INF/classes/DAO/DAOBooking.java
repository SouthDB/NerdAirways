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

public class DAOBooking {
	
	public Collection<AwBooking> listId(BigDecimal bookingnr, ServletContext sc){
		EntityManager em = (EntityManager)sc.getAttribute("em");
		
		
		Query query = em.createQuery("SELECT b from AwBooking b where b.bookingnr like '" + bookingnr + "%' ORDER BY b.id");
		return(Collection<AwBooking>)query.getResultList();
	}
	
	
	public Collection<AwBooking> listByCustId(BigDecimal custid, ServletContext sc){
		
		EntityManager em = (EntityManager)sc.getAttribute("em");
		Query query = em.createQuery("SELECT b from AwBooking b where b.custid like '" + custid + "%' ORDER BY b.id");
		return(Collection<AwBooking>)query.getResultList();
		
	}
	
	
	public Collection<AwBooking> listByFligId(BigDecimal fligId, ServletContext sc){
		EntityManager em = (EntityManager)sc.getAttribute("em");
		
		
		Query query = em.createQuery("SELECT b from AwBooking b where b.fligid like '" + fligId + "%' ORDER BY b.id");
		return(Collection<AwBooking>)query.getResultList();
	}
	
	
	public void saveBooking(String checkin, BigDecimal clasid, BigDecimal custid, BigDecimal fligid, BigDecimal laggid, BigDecimal price, ServletContext sc){
		EntityManager em = (EntityManager)sc.getAttribute("em");

		AwBooking newb = new AwBooking(checkin, clasid, custid, fligid, laggid, price);
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(newb);
		tx.commit();
	}
	
}