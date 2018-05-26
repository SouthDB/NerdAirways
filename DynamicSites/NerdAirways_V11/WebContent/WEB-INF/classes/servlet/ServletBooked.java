package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
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
		HttpSession session = request.getSession();

		System.out.println("-----Get request for /booked ---------");
		System.out.println("Request:" + request);
		
		long luser = (long) session.getAttribute("user");
		System.out.println("User Account:" + luser);
		BigDecimal custid = new BigDecimal(luser);
		
		
		String jsnObj = "{\"booked\":[";
		

		
		Collection<AwBooking> bookedcollect = (new DAOBooking()).listByCustId(custid, this.getServletContext());
		for (AwBooking o : bookedcollect) {
			BigDecimal fligid = o.getFligid();
			BigDecimal laggid = o.getLaggid();
			BigDecimal clasid = o.getClasid();
			
			AwFlight f = (new DAOFlight()).findFlightnr(fligid, this.getServletContext());
			BigDecimal fromid 	= f.getFromid();
			BigDecimal toid 	= f.getToid();
				
			String fromcountry 	= (new DAOCountry()).findCountry(fromid, this.getServletContext()).getCountry();
			String tocountry 	= (new DAOCountry()).findCountry(toid, this.getServletContext()).getCountry();
			
			String fclass = (new DAOClass()).findClass(clasid, this.getServletContext()).getClass_();
			String mass = (new DAOLuggage()).findLuggage(laggid, this.getServletContext()).getMass();
			
			String checkinUrl = "http://localhost:8080/NerdAirways/checkin?bookid=" + o.getId() + "\"";
			
			String jsn = 
					"{\"id\":\"" 			+ o.getId() 		+
					"\",\"bookingnr\":\"" 	+ o.getBookingnr() 	+
					"\",\"flightnr\":\"" 	+ f.getFlightnr() 	+
					"\",\"fromid\":\"" 		+ fromid 			+
					"\",\"toid\":\"" 		+ toid				+
					"\",\"takeoff\":\"" 	+ f.getTakeoff()	+
					"\",\"arrival\":\"" 	+ f.getArrival()	+
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
