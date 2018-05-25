package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.util.concurrent.TimeUnit;

import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;
import java.math.BigDecimal;
import java.text.*;

/**
 * Servlet implementation class ServletAccount
 */
@WebServlet("/account")
public class ServletAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("-----Get request for /account ---------");
		System.out.println("Request:" + request);
		
		AwCustomer user = (new DAOCustomer()).findCustomer((new BigDecimal("1")), this.getServletContext());
		String country = (new DAOCountry()).findCountry(user.getCounid(), this.getServletContext()).getCountry();
		
		String jsnObj =
			"{\"account\":[" +
			"{\"id\":\"" 			+ user.getId() 				+ 
			"\",\"username\":\"" 	+ user.getUsername() 		+
			"\",\"gender\":\"" 		+ user.getGender() 			+
			"\",\"fname\":\"" 		+ user.getFname() 			+
			"\",\"sname\":\"" 		+ user.getSname()			+
			"\",\"adress\":\"" 		+ user.getAdress()			+
			"\",\"plz\":\"" 		+ user.getPlz() 			+
			"\",\"place\":\""		+ user.getPlace()			+
			"\",\"birthdate\":\""	+ user.getBirthdate()		+
			"\",\"email\":\""		+ user.getEmail()			+
			"\",\"country\":\"" 	+ country 	+  
			"\"}]}";	
		System.out.println("Response user:" + jsnObj);
		
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
