package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import java.util.*;

import model.XTable1;
import DAO.XTable1DAO;

public class XTable1DAO {

	public List<String> listAll(ServletContext sc){
		EntityManager em = (EntityManager)sc.getAttribute("em");
		
		
	    Query query = em.createQuery("SELECT x from XTable1 x ORDER BY x.id");
	    List<XTable1> list = (List<XTable1>)query.getResultList();
		ArrayList<String> slist = new ArrayList<>();
		
		for (XTable1 o : list) {
			System.out.println("\nXTable1 ::" + o);
			String newEle = "" + o;
			slist.add(newEle);
		}
	return slist;
	}
}

