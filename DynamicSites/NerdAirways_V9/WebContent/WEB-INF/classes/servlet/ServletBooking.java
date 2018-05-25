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
 * Servlet implementation class ServletBooking
 */
@WebServlet("/booking")
public class ServletBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-----Get request for /booking ---------");
		System.out.println("Request:" + request);
		
		String sfligid = request.getParameter("fligid");
		System.out.println("fligid:" + sfligid);
		BigDecimal fligid = new BigDecimal(sfligid);
		
		String jsnObj = "{\"sflight\":[";
		
		AwFlight o = (new DAOFlight()).findFlightnr(fligid, this.getServletContext());
		
		BigDecimal fromid 	= o.getFromid();
		BigDecimal toid 	= o.getToid();
		
		String fromcountry 	= (new DAOCountry()).findCountry(fromid, this.getServletContext()).getCountry();
		String tocountry 	= (new DAOCountry()).findCountry(toid, this.getServletContext()).getCountry();
		
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
				"\"}";
			System.out.println("Response Flights:" + jsn);
			jsnObj += jsn;
		
		jsnObj = jsnObj.substring(0, jsnObj.length());
		jsnObj += "]}";
		
		response.getWriter().append(jsnObj);
		response.setContentType("application/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("-----Post request for /review ---------");
		System.out.println("Request:" + request);
		
		BigDecimal custid = new BigDecimal(1);
		System.out.println("Session User:" + custid);
		
		String vprice = request.getParameter("price");
		System.out.println("Price: " + vprice);
		BigDecimal price = new BigDecimal(vprice);
		
		String vfligid = request.getParameter("fligid");
		System.out.println("Fligid: " + vfligid);
		BigDecimal fligid = new BigDecimal(vfligid);
		
		String vclassid = request.getParameter("vclass");
		//System.out.println("FlyClass: " + vclassid);
		//char cclasid = vclassid.charAt(6);
		String sclas = "" + vclassid.charAt(6);
		System.out.println("FlyClass: " + sclas);
		BigDecimal clasid = new BigDecimal(sclas);
		System.out.println("FlyClass: " + clasid);
		
		
		String vluggid = request.getParameter("vlugg");
		//System.out.println("Luggage: " + vluggid);
		String slaggid = "" + vluggid.charAt(6);
		System.out.println("Luggage ID: " + slaggid);
		BigDecimal laggid = new BigDecimal(slaggid);
		
		(new DAOBooking()).saveBooking("n", clasid, custid, fligid, laggid, price, this.getServletContext());
		
		
		response.sendRedirect("http://localhost:8080/NerdAirways/booking_confirm.html");
	}

}
