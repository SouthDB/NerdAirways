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

public class DAOFlightstatus {
	
		public AwFlightstatus findStatus(BigDecimal id, ServletContext sc) {
	    	EntityManager em = (EntityManager) sc.getAttribute("em");
	    	return em.find(AwFlightstatus.class, id.longValue());
	 
	    }

}
