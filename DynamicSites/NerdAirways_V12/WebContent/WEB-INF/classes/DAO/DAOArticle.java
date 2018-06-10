package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

public class DAOArticle {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public DAOArticle(ServletContext sc) {
		emf = (EntityManagerFactory)sc.getAttribute("emf");
		em = emf.createEntityManager();
	}
	
	
	public List<String> listAll(){		
	    Query query = em.createQuery("SELECT x from AwArticle x ORDER BY x.id");
	    Collection<AwArticle> list = (Collection<AwArticle>)query.getResultList();
		ArrayList<String> slist = new ArrayList<>();
		em.close();
		
		for (AwArticle o : list) {
			System.out.println("Response article: " + o);
			String newEle = "" + o;
			slist.add(newEle);
		}
		
		return slist;
	}
	
}