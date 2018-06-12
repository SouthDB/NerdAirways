package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.util.concurrent.TimeUnit;

import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;
import java.math.BigDecimal;
import java.text.*;

/**
 * Servlet implementation class ServletAccountUpdate
 */
@WebServlet("/accountupdate")
public class ServletAccountUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccountUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory)request.getServletContext().getAttribute("emf");
		HttpSession session = request.getSession();
		
		
		System.out.println("-----Post request for /account update ---------");
		System.out.println("Request:" + request);
		
		
		//Benutzer von Session abfragen
		long luser = (long) session.getAttribute("user");
		System.out.println("User Account:" + luser);
		
		
		//Benutzer Objekt abrufen
		AwCustomer c = (new DAOCustomer(emf).findCustomer(luser));
		
		
		//neue account daten von post-parametern auslesen
		System.out.println("-----Post values for costomer for /account update ---------");
		String username		= request.getParameter("username");
		System.out.println("username:" + username);
		String pw	 		= request.getParameter("pw");
		System.out.println("pw:" + pw);
		String gender 		= request.getParameter("gender");
		System.out.println("gender:" + gender);
		String fname 		= request.getParameter("fname");
		System.out.println("fname:" + fname);
		String sname 		= request.getParameter("sname");
		System.out.println("sname:" + sname);
		String adress 		= request.getParameter("adress");
		System.out.println("adress:" + adress);
		String plz 			= request.getParameter("plz");
		System.out.println("plz:" + plz);
		String place 		= request.getParameter("place");
		System.out.println("place:" + place);
		String scounid 		= request.getParameter("country");
		System.out.println("country:" + scounid);
		BigDecimal counid = new BigDecimal(scounid);
		String email 		= request.getParameter("email");
		System.out.println("email:" + email);
		String sbirthdate 		= request.getParameter("birthdate");
		System.out.println("birthdate:" + sbirthdate);
		
		
		Date birthdate = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			birthdate = format.parse(sbirthdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("new birthdate type:" + birthdate);
		
		
		//neue account daten speichern
		(new DAOCustomer(emf)).updateCustomer(c, adress, birthdate, counid, email, fname, gender, place, plz, pw, sname, username);
		
		
		
		//neue Kreditkarten daten von post-parametern auslesen
		System.out.println("-----Post values for credicard for /signup ---------");
		String cardtype 		= request.getParameter("cardtype");
		System.out.println("cardtype:" + cardtype);
		String holder 		= request.getParameter("holder");
		System.out.println("holder:" + holder);
		String cardnr 		= request.getParameter("cardnr");
		System.out.println("cardnr:" + cardnr);
		
		
		//Kredikarten Objekt abrufen
		long credid = c.getCredid().longValue();
		System.out.println("credid:" + credid);
		AwCreditcard cred = (new DAOCreditcard(emf).findCreditcard(credid));
		
		
		//neue Kreditkarten daten speichern
		(new DAOCreditcard(emf)).updateCreditcard(cred, cardnr, cardtype, holder);
		
		
		response.sendRedirect("http://localhost:8080/NerdAirways/account.html");
	}

}
