package petShopProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import petShopProject.dao.UtilisateurDao;
import petShopProject.beans.Commande;
import petShopProject.beans.Products;
import petShopProject.beans.Utilisateur;

import petShopProject.dao.DaoFactory;

public class UtilisateurDaoImpl implements UtilisateurDao {
	 private DaoFactory daoFactory;

	    UtilisateurDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }
	    
	    @Override
	    public void ajouter(Utilisateur utilisateur) {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO users(username, password, email, phone, company, address) VALUES(?, ?,?,?,?,?);");
	            preparedStatement.setString(1, utilisateur.getUsername());
	            preparedStatement.setString(2, utilisateur.getPassword());
	            preparedStatement.setString(3, utilisateur.getEmail());
	            preparedStatement.setString(4, utilisateur.getPhone());
	            preparedStatement.setString(5, utilisateur.getCompany());
	            preparedStatement.setString(6, utilisateur.getAddress());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	    @Override
	    public List<Utilisateur> lister() {
	        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT username, password FROM users;");

	            while (resultat.next()) {
	                String user = resultat.getString("username");
	                String pass = resultat.getString("password");

	                Utilisateur utilisateur = new Utilisateur();
	                utilisateur.setUsername(user);
	                utilisateur.setPassword(pass);

	                utilisateurs.add(utilisateur);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return utilisateurs;
	    }
	    @Override
		 public  void ajouterCommande(Commande commande) {
	    	   Connection connexion = null;
		        PreparedStatement preparedStatement = null;

		        try {
		            connexion = daoFactory.getConnection();
		            preparedStatement = connexion.prepareStatement("INSERT INTO commande(email, item_pic, item_name, price, quantite) VALUES(?, ?,?,?,?);");
		            preparedStatement.setString(1, commande.getEmail());
		            preparedStatement.setString(2, commande.getItem_pic());
		            preparedStatement.setString(3, commande.getItem_name());
		            preparedStatement.setFloat(4, commande.getPrice());
		            preparedStatement.setInt(5, commande.getQuantite());
		            

		            preparedStatement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	
	    	
	    	
	    }
	    
	    @Override
	    public List<Products> listerProducts() {
	        List<Products> products = new ArrayList<Products>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT id, img, title,details,price, quantite FROM products;");

	            while (resultat.next()) {
	            	int id = resultat.getInt("id");
	                String img = resultat.getString("img");
	                String title = resultat.getString("title");
	                String details = resultat.getString("details");
	                float price = resultat.getFloat("price");
	                int quantite = resultat.getInt("quantite");


	                Products product = new Products();
	                product.setId(id);
	                product.setImage(img);
	                product.setTitle(title);
	                product.setDetails(details);
	                product.setPrice(price);
	                product.setQuantite(quantite);

	                products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return products;
	    }
	    @Override
		public Products afficherProduit(int id)  {
	    	Products product = new Products();
	    	 Connection connexion = null;
		        Statement statement = null;
		        ResultSet resultat = null;

		        try {
		            connexion = daoFactory.getConnection();
		            statement = connexion.createStatement();
		            resultat = statement.executeQuery("SELECT id, img, title,details,price, quantite FROM products where id="+id+";");
		    	    
		    	    while (resultat.next()) {
		            int idd = resultat.getInt("id");
		            String img = resultat.getString("img");
	                String title = resultat.getString("title");
	                String details = resultat.getString("details");
	                float price = resultat.getFloat("price");
	                int quantite = resultat.getInt("quantite");


	                product.setId(idd);
	                product.setImage(img);
	                product.setTitle(title);
	                product.setDetails(details);
	                product.setPrice(price);
	                product.setQuantite(quantite);
		    	    }} catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
                return product;

	  }
	    @Override
		public List<Commande> afficherCommande()  {
	    	  List<Commande> commandes = new ArrayList<Commande>();
		        Connection connexion = null;
		        Statement statement = null;
		        ResultSet resultat = null;

		        try {
		            connexion = daoFactory.getConnection();
		            statement = connexion.createStatement();
		            resultat = statement.executeQuery("SELECT id, email,item_pic,item_name,price, quantite FROM commande;");

		            while (resultat.next()) {
		            	int id = resultat.getInt("id");
		                String email = resultat.getString("email");
		                String item_pic = resultat.getString("item_pic");
		                String item_name = resultat.getString("item_name");
		                float price = resultat.getFloat("price");
		                int quantite = resultat.getInt("quantite");


		                Commande commande = new Commande();
		                commande.setId(id);
		                commande.setEmail(email);
		                commande.setItem_pic(item_pic);
		                commande.setItem_name(item_name);
		                commande.setPrice(price);
		                commande.setQuantite(quantite);
		             

		                commandes.add(commande);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return commandes;
	

	  }
	

}
