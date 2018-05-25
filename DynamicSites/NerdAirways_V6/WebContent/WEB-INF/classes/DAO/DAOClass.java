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

public class DAOClass {
	
	public AwClass findClass(BigDecimal id, ServletContext sc) {
		EntityManager em = (EntityManager) sc.getAttribute("em");
		return em.find(AwClass.class, id.longValue());
	}

}
