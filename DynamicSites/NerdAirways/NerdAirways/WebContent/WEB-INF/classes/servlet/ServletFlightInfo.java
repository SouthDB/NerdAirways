package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*List<String> filist = (new DAOFlightInfo()).listAll(this.getServletContext());
		
		String jsnObj = (new makeJSNOBJ("flightinfo", filist).getJsnObj());
		System.out.println(jsnObj);
		
		response.getWriter().append(jsnObj);
		response.setContentType("application/json");
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
