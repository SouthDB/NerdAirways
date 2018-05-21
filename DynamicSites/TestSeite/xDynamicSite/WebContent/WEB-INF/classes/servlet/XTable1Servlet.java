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
/**
 * Servlet implementation class XTable1Servlet
 */
@WebServlet("/XTable1Servlet")
public class XTable1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XTable1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> slist = (new XTable1DAO()).listAll(this.getServletContext());
		
		String jsntest = "{\"id\":\"1\",\"atri1\":\"hallo\"}";
		String jsn1 = slist.get(0);
		String jsn2 = slist.get(1);
		String jsn3 = slist.get(2);
		String jsnObj = "{\"table1\":[" + jsn1 + "," + jsn2 + "," + jsn3 + "]}"; 
		//System.out.println("Zeile2: " + jsn2);

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
