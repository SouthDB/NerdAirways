package DAO;

import javax.persistence.*;
import javax.servlet.ServletContext;

import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;
import java.math.BigDecimal;

public class DAOBooking {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOBooking(EntityManagerFactory emf) {
		//emf = (EntityManagerFactory)sc.getAttribute("emf");
		//emf = Persistence.createEntityManagerFactory((String)sc.getAttribute("persUnit"));
		em = emf.createEntityManager();
	}
	
	
	public AwBooking findBooking(BigDecimal id) {
		AwBooking o = em.find(AwBooking.class, id.longValue());
		em.close();
		
		return o;
	}
	
	public Collection<AwBooking> listByBookingnr(BigDecimal bookingnr){
		Query query = em.createQuery("SELECT b from AwBooking b where b.bookingnr like '" + bookingnr + "%' ORDER BY b.id");
		Collection<AwBooking> o = (Collection<AwBooking>)query.getResultList();
		em.close();
		
		return o;
	}
	
	public Collection<AwBooking> listByCustId(BigDecimal custid){
		Query query = em.createQuery("SELECT b from AwBooking b where b.custid like '" + custid + "%' ORDER BY b.id");
		Collection<AwBooking> o = (Collection<AwBooking>)query.getResultList();
		
		return o;
	}
	
	public Collection<AwBooking> listByFligId(BigDecimal fligId){
		Query query = em.createQuery("SELECT b from AwBooking b where b.fligid like '" + fligId + "%' ORDER BY b.id");
		Collection<AwBooking> o = (Collection<AwBooking>)query.getResultList();
		
		return o;
	}
	
	public void saveBooking(String checkin, BigDecimal clasid, BigDecimal custid, BigDecimal fligid, BigDecimal laggid, BigDecimal price){
		AwBooking newb = new AwBooking(checkin, clasid, custid, fligid, laggid, price);
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(newb);
		tx.commit();
		em.close();
	}
	
}