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
	
}