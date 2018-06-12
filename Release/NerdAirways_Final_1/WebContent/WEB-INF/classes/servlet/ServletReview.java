package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
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
import java.math.BigDecimal;

/**
 * Servlet implementation class ServletReview
 */
@WebServlet("/review")
public class ServletReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory)request.getServletContext().getAttribute("emf");
		
		
		System.out.println("-----Get request for /review ---------");
		System.out.println("Request:" + request);
		
		
		
		List<String> slist = (new DAOReview(emf)).listAll();
		
		String jsnObj = (new makeJSNOBJ("review", slist).getJsnObj());
		System.out.println(jsnObj);
		
		response.getWriter().append(jsnObj);
		response.setContentType("application/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory)request.getServletContext().getAttribute("emf");
		
		
		System.out.println("-----Post request for /review ---------");
		System.out.println("Request:" + request);
		
		String text 		= request.getParameter("text");
		System.out.println("Text:" + text);
		String srating 	= request.getParameter("rating");
		BigDecimal rating = new BigDecimal(srating);
		System.out.println("Rating:" + rating);
		String sbookingnr = request.getParameter("bookingnr");
		BigDecimal bookingnr = new BigDecimal(sbookingnr);
		long lbookingid = 0;
		
		Collection<AwBooking> bc = (new DAOBooking(emf)).listByBookingnr(bookingnr);
		if(bc.size() == 0){
			response.sendRedirect("http://localhost:8080/NerdAirways/booknrwrong.html");
		}
		else{
			for (AwBooking o : bc){
				lbookingid = o.getId();
				System.out.println("BookingID:" + lbookingid);
			
			}
			
			BigDecimal bookingid = new BigDecimal(lbookingid);
			
			(new DAOReview(emf)).saveReview(bookingid,rating, text);
			
			
			response.sendRedirect("http://localhost:8080/NerdAirways/review.html");
		}
		
	}

}
