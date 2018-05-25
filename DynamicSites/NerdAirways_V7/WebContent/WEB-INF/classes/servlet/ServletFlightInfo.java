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
 * Servlet implementation class ServletFlightStatus
 */
@WebServlet("/flightinfo")
public class ServletFlightInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFlightInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-----Get request for /flightinfo ---------");
		System.out.println("Request:" + request);

		String jsnObj = "{\"flightinfo\":[";
		
		Collection<AwFlight> flightcollect = (new DAOFlight()).listAll(this.getServletContext());
		for (AwFlight o : flightcollect) {
			BigDecimal fromid 	= o.getFromid();
			BigDecimal toid 	= o.getToid();
			BigDecimal statid 	= o.getStatid();
			
			String fromcountry 	= (new DAOCountry()).findCountry(fromid, this.getServletContext()).getCountry();
			String tocountry 	= (new DAOCountry()).findCountry(toid, this.getServletContext()).getCountry();
			String statustext 	= (new DAOFlightstatus()).findStatus(statid, this.getServletContext()).getStatustext();
			
			String jsn = 
				"{\"id\":\"" 			+ o.getId() 			+ 
				"\",\"flightnr\":\"" 	+ o.getFlightnr() 		+
				"\",\"fromid\":\"" 		+ o.getFromid() 		+
				"\",\"toid\":\"" 		+ o.getToid() 			+
				"\",\"takeoff\":\"" 	+ o.getTakeoff()		+
				"\",\"arrival\":\"" 	+ o.getArrival()		+
				"\",\"statid\":\"" 		+ o.getStatid() 		+
				"\",\"price\":\""		+ o.getPrice()			+
				"\",\"fromcountry\":\"" + fromcountry 	+  
				"\",\"tocountry\":\"" 	+ tocountry 	+
				"\",\"statustext\":\""	+ statustext 	+ 
				"\"},";
			System.out.println(jsn);
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
