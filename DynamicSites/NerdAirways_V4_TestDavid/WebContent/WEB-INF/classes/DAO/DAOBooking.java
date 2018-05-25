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

	/* laut https://stackoverflow.com/questions/8342572/retrieving-single-value-using-jpa#8342658 wird ein long Wert zurückgegeben
	alternativ: ohne Count die ResultList zurückgeben lassen */
	public long getFlightBookings(BigDecimal flightId, ServletContext sc){
		EntityManager em = (EntityManager)sc.getAttribute("em");
		
		/* von oben abgeändert, nicht sicher ob nicht where FLIGID= besser */
		Query query = em.createQuery("SELECT COUNT(b.FLIGID) from AwBooking b where b.FLIGID like '" + flightId + "%'");
		return query.getSingleResult().longValue();
	}	
	
}