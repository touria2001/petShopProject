package petShopProject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import petShopProject.dao.DaoFactory;
import petShopProject.dao.UtilisateurDao;
import petShopProject.login.Login;


public class servletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  private UtilisateurDao utilisateurDao;
	   HttpSession session;
	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.utilisateurDao = daoFactory.getUtilisateurDao();
	        
	    }
    
    public servletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String user = request.getParameter("user") ;
		 String pass = request.getParameter("pass") ;

		 if((user=="Admin")&& (pass=="admin"))
				 {
			 this.getServletContext().getRequestDispatcher("register.jsp").forward(request, response);
			 
				 }
	
	
	
		
	}

}
