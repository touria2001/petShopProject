package petShopProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import petShopProject.beans.Commande;
import petShopProject.beans.Utilisateur;
import petShopProject.dao.DaoFactory;
import petShopProject.dao.UtilisateurDao;
import petShopProject.login.Login;




public class mainServ extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	   private UtilisateurDao utilisateurDao;

	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.utilisateurDao = daoFactory.getUtilisateurDao();
	    }


    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	if(String.valueOf(request.getParameter("page")).equals("home")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		} else if(String.valueOf(request.getParameter("page")).equals("cart")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
			
		}else if(String.valueOf(request.getParameter("page")).equals("category")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
			
		}else if(String.valueOf(request.getParameter("page")).equals("contact")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp").forward(request, response);
			
		}else if(String.valueOf(request.getParameter("page")).equals("details")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);
			
		}else if(String.valueOf(request.getParameter("page")).equals("myaccount")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/myaccount.jsp").forward(request, response);
			
		}else if(String.valueOf(request.getParameter("page")).equals("register")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			
		}else if(String.valueOf(request.getParameter("page")).equals("specials")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/specials.jsp").forward(request, response);
			
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/about.jsp").forward(request, response);
		}*/
		
	if(	!String.valueOf(request.getParameter("productId")).equals("null"))
	{
	    request.setAttribute("produit", utilisateurDao.afficherProduit(Integer.parseInt(request.getParameter("productId"))));
		this.getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
	}
	
	
		
		request.setAttribute("products",utilisateurDao.listerProducts());
        this.getServletContext().getRequestDispatcher("/specials.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products",utilisateurDao.listerProducts());
        //-----------------------------------------------------------------------
		 Utilisateur utilisateur = new Utilisateur();
	        utilisateur.setUsername(request.getParameter("username"));
	        utilisateur.setPassword(request.getParameter("password"));
	        utilisateur.setEmail(request.getParameter("email"));
	        utilisateur.setPhone(request.getParameter("phone"));
	        utilisateur.setCompany(request.getParameter("company"));
	        utilisateur.setAddress(request.getParameter("address"));
	        utilisateurDao.ajouter(utilisateur);

	        //----------------------------------------------------------------------------------------
	        Login login = new Login();
	        login.verifierIdentifiants(request);
	        request.setAttribute("resultat", login.getResultat());
	        if(login.getResultat().equals("you are connected") ) {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("nameUser",request.getParameter("user"));
	        	this.getServletContext().getRequestDispatcher("/myaccount.jsp").forward(request, response);
	        }
	        
	        //----------------------------------------------------------------------------------------
	        Commande commande = new Commande();
	        commande.setEmail(request.getParameter("emaill"));
	        commande.setItem_name(request.getParameter("item_name"));
	        commande.setItem_pic(request.getParameter("item_pic"));
	        commande.setPrice(100);
	        commande.setQuantite(1);
	        utilisateurDao.ajouterCommande(commande);
	        request.setAttribute("commandes", utilisateurDao.afficherCommande());
	        
	     //   if(!commande.equals(null)) {
	        this.getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);//}

	        //------------------------------------------------------------------------------------------
	        this.getServletContext().getRequestDispatcher("/myaccount.jsp").forward(request, response);
	}

}
