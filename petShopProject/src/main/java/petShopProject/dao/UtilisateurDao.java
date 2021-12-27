package petShopProject.dao;

import java.util.List;

import petShopProject.beans.Commande;
import petShopProject.beans.Contact;
import petShopProject.beans.Products;
import petShopProject.beans.Utilisateur;

public interface UtilisateurDao {
	
	Contact afficherContact(String usr, String password);
	void ajouter( Utilisateur utilisateur );
    List<Utilisateur> lister();
    void ajouterCommande(Commande commande);
    List<Products> listerProducts();
    Products afficherProduit(int id);
    List<Commande> afficherCommande(String mail);
    String afficherEmail(String user);
    int nombreItems(String mail);


}
