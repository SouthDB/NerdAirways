package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
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
 * Servlet implementation class ServletCheckin
 */
@WebServlet("/checkin")
public class ServletCheckin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCheckin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory)request.getServletContext().getAttribute("emf");
		
		
		System.out.println("-----Get request for /checkin ---------");
		System.out.println("Request:" + request);
		
		String sbookid = request.getParameter("bookid");
		BigDecimal bookid = new BigDecimal(sbookid);
		System.out.println("bookid:" + bookid);
		
		AwBooking b = (new DAOBooking(emf)).findBooking(bookid);
		b.setCheckin("y");
		
		
		response.sendRedirect("http://localhost:8080/NerdAirways/checkin_confirm.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
