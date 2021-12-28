package petShopProject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class Adminservlet
 */
public class Adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	try {
			String u ="Admin";
			String p="admin";

			 if(request.getAttribute("user").equals(u) && request.getAttribute("pass").equals(p))
					{
				 RequestDispatcher dispat = 
						 request.getRequestDispatcher("/ajouterAdmin.jsp");
						 dispat.forward(request,response);
				 
				 }
			 else {
				 RequestDispatcher dispat = 
						 request.getRequestDispatcher("/admin.jsp");
						 dispat.forward(request,response);
			 }
			}
			catch(Exception e){
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request,response);

	}

}
