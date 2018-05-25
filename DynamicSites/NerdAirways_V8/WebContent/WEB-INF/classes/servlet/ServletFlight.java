package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;

/**
 * Servlet implementation class ServletFlight
 */
@WebServlet("/flight")
public class ServletFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("-----Get request for /flight ---------");
		System.out.println("Request:" + request);
		
		String jsnObj = "{\"flight\":[";
		
		String bookUrl = "http://localhost:8080/NerdAirways/booking.html?fligid=";
		
		Collection<AwFlight> flightcollect = (new DAOFlight()).listAll(this.getServletContext());
		for (AwFlight o : flightcollect) {
			
			BigDecimal fromid 	= o.getFromid();
			BigDecimal toid 	= o.getToid();
			
			int capacity = (new DAOBooking()).listByFligId((new BigDecimal(o.getId())),this.getServletContext()).size();
			
			String fromcountry 	= (new DAOCountry()).findCountry(fromid, this.getServletContext()).getCountry();
			String tocountry 	= (new DAOCountry()).findCountry(toid, this.getServletContext()).getCountry();
			
			
			String genBookUrl = bookUrl + o.getId();
			
			String jsn = 
				"{\"id\":\"" 			+ o.getId() 			+ 
				"\",\"flightnr\":\"" 	+ o.getFlightnr() 		+
				"\",\"fromid\":\"" 		+ o.getFromid() 		+
				"\",\"toid\":\"" 		+ o.getToid() 			+
				"\",\"takeoff\":\"" 	+ o.getTakeoff()		+
				"\",\"arrival\":\"" 	+ o.getArrival()		+
				"\",\"price\":\""		+ o.getPrice()			+
				"\",\"fromcountry\":\"" + fromcountry 			+  
				"\",\"tocountry\":\"" 	+ tocountry 			+
				"\",\"capacity\":\"" 	+ capacity 				+
				"\",\"booklink\":\"" 	+ genBookUrl 				+
				"\"},";
			System.out.println("Response Flights:" + jsn);
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
