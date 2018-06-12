package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

/**
 * Servlet implementation class ServletBooked
 */
@WebServlet("/booked")
public class ServletBooked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBooked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory)request.getServletContext().getAttribute("emf");
		HttpSession session = request.getSession();

		
		System.out.println("-----Get request for /booked ---------");
		System.out.println("Request:" + request);
		
		long luser = (long) session.getAttribute("user");
		System.out.println("User Account:" + luser);
		BigDecimal custid = new BigDecimal(luser);
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
		
		String jsnObj = "{\"booked\":[";
		

		
		Collection<AwBooking> bookedcollect = (new DAOBooking(emf)).listByCustId(custid);
		for (AwBooking o : bookedcollect) {
			BigDecimal fligid = o.getFligid();
			BigDecimal laggid = o.getLaggid();
			BigDecimal clasid = o.getClasid();
			
			AwFlight f = (new DAOFlight(emf)).findFlightnr(fligid);
			BigDecimal fromid 	= f.getFromid();
			BigDecimal toid 	= f.getToid();
				
			String fromcountry 	= (new DAOTerminal(emf)).findTerminal(fromid).getPlace();
			String tocountry 	= (new DAOTerminal(emf)).findTerminal(toid).getPlace();
			
			String fclass = (new DAOClass(emf)).findClass(clasid).getClass_();
			String mass = (new DAOLuggage(emf)).findLuggage(laggid).getMass();
			
			String checkinUrl = "http://localhost:8080/NerdAirways/checkin?bookid=" + o.getId() + "\"";
			
			String jsn = 
					"{\"id\":\"" 			+ o.getId() 		+
					"\",\"bookingnr\":\"" 	+ o.getBookingnr() 	+
					"\",\"flightnr\":\"" 	+ f.getFlightnr() 	+
					"\",\"fromid\":\"" 		+ fromid 			+
					"\",\"toid\":\"" 		+ toid				+
					"\",\"takeoff\":\"" 	+ dateFormat.format((java.util.Date)f.getTakeoff())		+
					"\",\"arrival\":\"" 	+ dateFormat.format((java.util.Date)f.getArrival())		+
					"\",\"price\":\""		+ o.getPrice()		+
					"\",\"fromcountry\":\"" + fromcountry 		+  
					"\",\"tocountry\":\"" 	+ tocountry 		+
					"\",\"class\":\"" 		+ fclass 			+
					"\",\"mass\":\"" 		+ mass 				+
					"\",\"checkinlink\":\""	+ checkinUrl 		+
					"},";
				System.out.println("Response booked:" + jsn);
				jsnObj += jsn;
			
		}
		
		jsnObj = jsnObj.substring(0, jsnObj.length()-1);
		jsnObj += "]}";
		
		
		response.getWriter().append(jsnObj);
		response.setContentType("application/json");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
