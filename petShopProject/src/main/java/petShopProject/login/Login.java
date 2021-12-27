package petShopProject.login;

import petShopProject.dao.UtilisateurDao;

import petShopProject.dao.DaoFactory;
import petShopProject.beans.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import petShopProject.dao.UtilisateurDaoImpl;

public class Login {
	
	private String resultat;
	private UtilisateurDao utilisateurDao;
	public void verifierIdentifiants(HttpServletRequest request) {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        utilisateurs = utilisateurDao.lister();
        for(Utilisateur usr1 : utilisateurs) {
        	if(usr1.getUsername().equals(user) && usr1.getPassword().equals(pass)) {
        		resultat = "you are connected";
        		
        	}else {
        		resultat="incorrect username or password";
        		
        	}
        	}
        }
        	
        	public String getResultat() {
        		return resultat;
        	}
}
        
        
        
        
		
		
		
		