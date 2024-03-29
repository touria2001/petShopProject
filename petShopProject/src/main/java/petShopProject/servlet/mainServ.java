package petShopProject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import petShopProject.beans.Commande;
import petShopProject.beans.Contact;
import petShopProject.beans.Utilisateur;
import petShopProject.dao.DaoFactory;
import petShopProject.dao.UtilisateurDao;
import petShopProject.login.Login;




public class mainServ extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	   private UtilisateurDao utilisateurDao;
	   HttpSession session;
	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.utilisateurDao = daoFactory.getUtilisateurDao();
	        
	    }


    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pour right content
		if(request.getSession().getAttribute("nameUser") != null) {
			if(request.getParameter("devise")!=null) {
				
		              	if(request.getParameter("devise").equals("GBP")) {
				              utilisateurDao.changerDeviseToGbp();
			              }else if(request.getParameter("devise").equals("EUR")) {
			            	  utilisateurDao.changerDeviseToEur();
			              }else if(request.getParameter("devise").equals("$")) {
			            	  utilisateurDao.changerDeviseToDollar();
			              }          	
			
			}
			
			
			
			//--------------------------------------------------
			
		    List<Commande> commandes = new ArrayList<Commande>();
            float total= 0.0f;
            commandes =  utilisateurDao.afficherCommande(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser"))));
            for(Commande cmd : commandes) {
            	total+=cmd.getPrice();
            }
            request.setAttribute("devise", utilisateurDao.returnDevise());
            request.setAttribute("total",total);	
		request.setAttribute("nbrItems",String.valueOf(utilisateurDao.nombreItems(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser"))))));
		}
        //---------------------------------------------------------
		
		
		
		if(!String.valueOf(request.getParameter("cart")).equals("null")) {
		   
			if(request.getSession().getAttribute("nameUser") != null) {           	
           
             
	        request.setAttribute("commandes", utilisateurDao.afficherCommande(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser")))));
	        
	    
	        this.getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	        }
		}
		
	if(	!String.valueOf(request.getParameter("productId")).equals("null"))
	{
	    request.setAttribute("produit", utilisateurDao.afficherProduit(Integer.parseInt(request.getParameter("productId"))));
		this.getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
	}
	
	
		
		request.setAttribute("products",utilisateurDao.listerProducts());
        this.getServletContext().getRequestDispatcher("/ourObjects.jsp").forward(request, response);

		
	}

	//------------------------------------------------post-----------------------------------------------
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------------------------------------------------------------------------------------------
		//pour forwroder un contact to jsp 
		
	     Contact contact = new Contact();
	     contact = utilisateurDao.afficherContact(request.getParameter("user"),request.getParameter("pass"));
	     request.setAttribute("contact",contact);
	     
		//this.getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
		
		request.setAttribute("products",utilisateurDao.listerProducts());
		if(request.getSession().getAttribute("nameUser") != null) {
		    List<Commande> commandes = new ArrayList<Commande>();
            float total= 0.0f;
            commandes =  utilisateurDao.afficherCommande(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser"))));
            for(Commande cmd : commandes) {
            	total+=cmd.getPrice();
            }
            request.setAttribute("total",total);	
		request.setAttribute("nbrItems",String.valueOf(utilisateurDao.nombreItems(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser"))))));
		}
        //-----------------------------------------------------------------------
		if(!String.valueOf(request.getParameter("username")).equals("null")) {
		 Utilisateur utilisateur = new Utilisateur();
	        utilisateur.setUsername(request.getParameter("username"));
	        utilisateur.setPassword(request.getParameter("password"));
	        utilisateur.setEmail(request.getParameter("email"));
	        utilisateur.setPhone(request.getParameter("phone"));
	        utilisateur.setCompany(request.getParameter("company"));
	        utilisateur.setAddress(request.getParameter("address"));
	        utilisateurDao.ajouter(utilisateur);}

	        //----------------------------------------------------------------------------------------
	        Login login = new Login();
	        login.verifierIdentifiants(request);
	        request.setAttribute("resultat", login.getResultat());	        
	        if(login.getResultat().equals("you are connected") ) {
	        	  
	        	
	        	  request.getSession().setAttribute("nameUser",request.getParameter("user"));
	        	  List<Commande> commandes = new ArrayList<Commande>();
	              float total= 0.0f;
	              commandes =  utilisateurDao.afficherCommande(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser"))));
	              for(Commande cmd : commandes) {
	              	total+=cmd.getPrice();
	              }
	              request.setAttribute("devise", utilisateurDao.returnDevise());
	              request.setAttribute("total",total);	
	  		request.setAttribute("nbrItems",String.valueOf(utilisateurDao.nombreItems(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser"))))));
	        	  
	        	this.getServletContext().getRequestDispatcher("/ourObjects.jsp").forward(request, response);
	        }
	        
	        //----------------------------------------------------------------------------------------
			if(!String.valueOf(request.getParameter("item_name")).equals("null")) {
	        Commande commande = new Commande();
	        
	        commande.setEmail(utilisateurDao.afficherEmail(request.getParameter("emaill")));
	        commande.setItem_name(request.getParameter("item_name"));
	        commande.setItem_pic(request.getParameter("item_pic"));
	        commande.setPrice(100);
	        commande.setQuantite(Integer.parseInt(request.getParameter("quantite")));
	        utilisateurDao.ajouterCommande(commande);
	        if(request.getSession().getAttribute("nameUser") != null) {              	
	        
		        request.setAttribute("commandes", utilisateurDao.afficherCommande(utilisateurDao.afficherEmail(String.valueOf(request.getSession().getAttribute("nameUser")))));	        
		     
		        this.getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);}}
	        
        //-------------------------------------------------------------------
	        
	        //------------------------------------------------------------------------------------------
	        this.getServletContext().getRequestDispatcher("/ourObjects.jsp").forward(request, response);
	        
	        

		
		
	}
	

}
