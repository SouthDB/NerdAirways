package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import java.util.*;

import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

public class DAOArticle {
	
	public List<String> listAll(ServletContext sc){
		EntityManager em = (EntityManager)sc.getAttribute("em");
		
		
	    Query query = em.createQuery("SELECT x from AwArticle x ORDER BY x.id");
	    Collection<AwArticle> list = (Collection<AwArticle>)query.getResultList();
		ArrayList<String> alist = new ArrayList<>();
		
		for (AwArticle o : list) {
			System.out.println("\nArticle ::" + o);
			String newEle = "" + o;
			alist.add(newEle);
		}
	return alist;
	}
}