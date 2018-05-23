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
		List<String> slist = (new DAOReview()).listAll(this.getServletContext());
		
		String jsnObj = (new makeJSNOBJ("review", slist).getJsnObj());
		System.out.println(jsnObj);
		
		response.getWriter().append(jsnObj);
		response.setContentType("application/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request:" + request);
		
		String text 		= request.getParameter("text");
		System.out.println("Text:" + text);
		String srating 	= request.getParameter("rating");
		BigDecimal rating = new BigDecimal(srating);
		System.out.println("Rating:" + rating);
		String sflightnr = request.getParameter("flightnr");
		BigDecimal flightnr = new BigDecimal(sflightnr);
		long lbookingid = 0;
		
		Collection<AwBooking> bookingcollection = (new DAOBooking()).listId(flightnr, this.getServletContext());
		for (AwBooking o : bookingcollection){
			lbookingid = o.getId();
			System.out.println("BookingID:" + lbookingid);
		
		}
		
		BigDecimal bookingid = new BigDecimal(lbookingid);
		
		(new DAOReview()).saveReview(bookingid,rating, text, this.getServletContext());
		
		
		
		
		
		
	}

}
