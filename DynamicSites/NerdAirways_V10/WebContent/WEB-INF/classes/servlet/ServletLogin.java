package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import DAO.*;
import model.*;
import servlet.*;
import myfunction.*;
import java.math.BigDecimal;
/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		HttpSession session = request.getSession();
		
		System.out.println("-----Post request for /login ---------");
		System.out.println("Request:" + request);
		
		
		String username = request.getParameter("username");
		String pw = request.getParameter("pw");
		System.out.println("Try to login: username: " + username + " pw: " + pw);
		
		long custid = 0;
		
		Collection<AwCustomer> customercollection = (new DAOCustomer()).listByUsername(username, this.getServletContext());
		
		if(customercollection.size()==0){
			response.sendRedirect("http://localhost:8080/NerdAirways/loginwrong.html");
		}
		for (AwCustomer o : customercollection){
			custid = o.getId();
			
			
			System.out.println("CustomerID:" + custid);
			
			String rusername = o.getUsername();
			System.out.println("right username:" + rusername);
			if(username.equals(rusername)) {
				System.out.println("username ok");
			}
			else{response.sendRedirect("http://localhost:8080/NerdAirways/loginwrong.html"); }
			
			String rpw = o.getPw();
			System.out.println("right passwort:" + rpw);
			if(pw.equals(rpw)) {
				System.out.println("passwort ok");
				session.setAttribute("user", custid);
				response.sendRedirect("http://localhost:8080/NerdAirways/home.html");
				//response.sendRedirect(request.getRequestURI());
			}
			else{response.sendRedirect("http://localhost:8080/NerdAirways/loginwrong.html"); }
		}
		
	}

}
