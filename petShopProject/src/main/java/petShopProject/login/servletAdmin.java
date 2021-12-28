package petShopProject.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import petShopProject.dao.DaoFactory;
import petShopProject.dao.UtilisateurDao;


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
		
		  Login login = new Login();
	        login.verifierIdentifiants(request);
	        request.setAttribute("resultat", login.getResultat());
	        
	        if(login.getResultat().equals("you are connected") ) {
	        	 session = request.getSession();
	        	
	        	session.setAttribute("nameUser",request.getParameter("user"));
	        	this.getServletContext().getRequestDispatcher("/ourObjects.jsp").forward(request, response);
	        }
		
	}

}
