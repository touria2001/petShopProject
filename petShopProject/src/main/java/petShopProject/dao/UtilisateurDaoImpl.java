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
	        }finally {
	            // Fermeture de la connexion
	            try {
	            
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
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
	        }finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	        return utilisateurs;
	    }
	    @Override
		 public  void ajouterCommande(Commande commande) {
	    	   Connection connexion = null;
		        PreparedStatement preparedStatement = null;

		        try {
		            connexion = daoFactory.getConnection();
		            preparedStatement = connexion.prepareStatement("INSERT INTO commande(email, item_pic, item_name, price, quantite,devise) VALUES(?, ?,?,?,?,?);");
		            preparedStatement.setString(1, commande.getEmail());
		            preparedStatement.setString(2, commande.getItem_pic());
		            preparedStatement.setString(3, commande.getItem_name());
		            preparedStatement.setFloat(4, commande.getPrice());
		            preparedStatement.setInt(5, commande.getQuantite());
		            preparedStatement.setString(6, commande.getDevise());


		            preparedStatement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
		            // Fermeture de la connexion
		            try {
		              
		                if (connexion != null)
		                    connexion.close();
		            } catch (SQLException ignore) {
		            }
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
	            resultat = statement.executeQuery("SELECT id, img, title,details,price, quantite,devise FROM products;");

	            while (resultat.next()) {
	            	int id = resultat.getInt("id");
	                String img = resultat.getString("img");
	                String title = resultat.getString("title");
	                String details = resultat.getString("details");
	                float price = resultat.getFloat("price");
	                int quantite = resultat.getInt("quantite");
	                String devise = resultat.getString("devise");



	                Products product = new Products();
	                product.setId(id);
	                product.setImage(img);
	                product.setTitle(title);
	                product.setDetails(details);
	                product.setPrice(price);
	                product.setQuantite(quantite);
	                product.setDevise(devise);

	                products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
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
		            resultat = statement.executeQuery("SELECT id, img, title,details,price, quantite,devise FROM products where id="+id+";");
		    	    
		    	    while (resultat.next()) {
		            int idd = resultat.getInt("id");
		            String img = resultat.getString("img");
	                String title = resultat.getString("title");
	                String details = resultat.getString("details");
	                float price = resultat.getFloat("price");
	                int quantite = resultat.getInt("quantite");
		            String devise = resultat.getString("devise");



	                product.setId(idd);
	                product.setImage(img);
	                product.setTitle(title);
	                product.setDetails(details);
	                product.setPrice(price);
	                product.setQuantite(quantite);
	                product.setDevise(devise);
		    	    }} catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
		            // Fermeture de la connexion
		            try {
		                if (resultat != null)
		                    resultat.close();
		                if (statement != null)
		                    statement.close();
		                if (connexion != null)
		                    connexion.close();
		            } catch (SQLException ignore) {
		            }
		        }
		        
                return product;

	  }
	    @Override
		public List<Commande> afficherCommande(String mail)  {
	    	  List<Commande> commandes = new ArrayList<Commande>();
		        Connection connexion = null;
		        Statement statement = null;
		        ResultSet resultat = null;

		        try {
		            connexion = daoFactory.getConnection();
		            statement = connexion.createStatement();
		            resultat = statement.executeQuery("SELECT id,item_pic,item_name,price, quantite,devise FROM commande where email='"+mail+"';");

		            while (resultat.next()) {
		            	int id = resultat.getInt("id");
		                
		                String item_pic = resultat.getString("item_pic");
		                String item_name = resultat.getString("item_name");
		                float price = resultat.getFloat("price");
		                int quantite = resultat.getInt("quantite");
		                String devise = resultat.getString("devise");


		                Commande commande = new Commande();
		                commande.setId(id);
		               
		                commande.setItem_pic(item_pic);
		                commande.setItem_name(item_name);
		                commande.setPrice(price);
		                commande.setQuantite(quantite);
		                commande.setDevise(devise);
		             

		                commandes.add(commande);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
		            // Fermeture de la connexion
		            try {
		                if (resultat != null)
		                    resultat.close();
		                if (statement != null)
		                    statement.close();
		                if (connexion != null)
		                    connexion.close();
		            } catch (SQLException ignore) {
		            }
		        }
		        return commandes;
	

	  }
	    @Override
	 		public String afficherEmail(String user)  {
	    	String email = "" ;
	 		        Connection connexion = null;
	 		        Statement statement = null;
	 		        ResultSet resultat = null;

	 		        try {
	 		            connexion = daoFactory.getConnection();
	 		            statement = connexion.createStatement();
	 		            resultat = statement.executeQuery("SELECT email  FROM users where username='"+user+"';");

	 		            while (resultat.next()) {
	 		            	
	 		                
	 		                 email = resultat.getString("email");
	 		            
	 		            }
	 		        } catch (SQLException e) {
	 		            e.printStackTrace();
	 		        }finally {
	 		            // Fermeture de la connexion
	 		            try {
	 		                if (resultat != null)
	 		                    resultat.close();
	 		                if (statement != null)
	 		                    statement.close();
	 		                if (connexion != null)
	 		                    connexion.close();
	 		            } catch (SQLException ignore) {
	 		            }
	 		        }
	 		        return email;
	 	

	 	  }
	    
	    @Override
	    public int nombreItems(String mail) {
	       int i =0;
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT COUNT(*)  AS total FROM commande WHERE email='"+mail+"';");

	            while (resultat.next()) {
	            	i = resultat.getInt("total");
	            
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        return i;
	    }
	    @Override
 		public void changerDeviseToGbp()  {
    	String dev= null;
 		        Connection connexion = null;
 		        Statement statement = null;
 		        ResultSet resultat = null;

 		        try {
 		            connexion = daoFactory.getConnection();
 		            statement = connexion.createStatement();
 		           resultat = statement.executeQuery("SELECT devise from products where 1  ;");
 		       
 		           while (resultat.next()) {
 		            	dev = resultat.getString("devise"); 		            
 		            }
 		         
 		           
 		          if(dev != null && dev.equals("$")) {
 		        	  
 	 		            statement.executeUpdate("UPDATE  products SET price = price/1.34 , devise = 'GBP';");
 	 		            statement.executeUpdate("UPDATE  commande SET price = price/1.34 , devise = 'GBP';");


 		          }else if(dev != null && dev.equals("EUR")) {
 	 		            statement.executeUpdate("UPDATE  products  SET price = price * 0.84, devise ='GBP';");
 	 		            statement.executeUpdate("UPDATE  products  SET price = price * 0.84, devise='GBP';");


 		          }
 		            	
 		            
 		         
 		        } catch (SQLException e) {
 		            e.printStackTrace();
 		        }finally {
 		            // Fermeture de la connexion
 		            try {
 		                if (resultat != null)
 		                    resultat.close();
 		                if (statement != null)
 		                    statement.close();
 		                if (connexion != null)
 		                    connexion.close();
 		            } catch (SQLException ignore) {
 		            }
 		        }     
 	

 	  }
	    @Override
 		public void changerDeviseToEur()  {
    	String dev= null;
 		        Connection connexion = null;
 		        Statement statement = null;
 		        ResultSet resultat = null;

 		        try {
 		            connexion = daoFactory.getConnection();
 		            statement = connexion.createStatement();
 		           resultat = statement.executeQuery("SELECT devise from products where 1  ;");
 		       
 		           while (resultat.next()) {
 		            	dev = resultat.getString("devise"); 		            
 		            }
 		         
 		           
 		          if(dev != null && dev.equals("$")) {
 		        	  
 	 		            statement.executeUpdate("UPDATE  products SET price = price*0.88 , devise = 'EUR';");
 	 		            statement.executeUpdate("UPDATE  commande SET price = price*0.88 , devise = 'EUR';");


 		          }else if(dev != null && dev.equals("GBP")) {
 	 		            statement.executeUpdate("UPDATE  products  SET price = price * 1.19, devise ='EUR';");
 	 		            statement.executeUpdate("UPDATE  products  SET price = price * 1.19, devise='EUR';");


 		          }
 		            	
 		            
 		         
 		        } catch (SQLException e) {
 		            e.printStackTrace();
 		        }finally {
 		            // Fermeture de la connexion
 		            try {
 		                if (resultat != null)
 		                    resultat.close();
 		                if (statement != null)
 		                    statement.close();
 		                if (connexion != null)
 		                    connexion.close();
 		            } catch (SQLException ignore) {
 		            }
 		        }     
 	

 	  }
	    @Override
 		public void changerDeviseToDollar()  {
    	String dev= null;
 		        Connection connexion = null;
 		        Statement statement = null;
 		        ResultSet resultat = null;

 		        try {
 		            connexion = daoFactory.getConnection();
 		            statement = connexion.createStatement();
 		           resultat = statement.executeQuery("SELECT devise from products where 1  ;");
 		       
 		           while (resultat.next()) {
 		            	dev = resultat.getString("devise"); 		            
 		            }
 		         
 		           
 		          if(dev != null && dev.equals("EUR")) {
 		        	  
 	 		            statement.executeUpdate("UPDATE  products SET price = price/0.88 , devise = '$';");
 	 		            statement.executeUpdate("UPDATE  commande SET price = price/0.88 , devise = '$';");


 		          }else if(dev != null && dev.equals("GBP")) {
 	 		            statement.executeUpdate("UPDATE  products  SET price = price * 1.34, devise ='$';");
 	 		            statement.executeUpdate("UPDATE  products  SET price = price * 1.34, devise='$';");


 		          }
 		            	
 		            
 		         
 		        } catch (SQLException e) {
 		            e.printStackTrace();
 		        }finally {
 		            // Fermeture de la connexion
 		            try {
 		                if (resultat != null)
 		                    resultat.close();
 		                if (statement != null)
 		                    statement.close();
 		                if (connexion != null)
 		                    connexion.close();
 		            } catch (SQLException ignore) {
 		            }
 		        }     
 	

 	  }
	    @Override
 		public String returnDevise()  {
    	String dev= null;
 		        Connection connexion = null;
 		        Statement statement = null;
 		        ResultSet resultat = null;

 		        try {
 		            connexion = daoFactory.getConnection();
 		            statement = connexion.createStatement();
 		           resultat = statement.executeQuery("SELECT devise from products where 1  ;");
 		       
 		           while (resultat.next()) {
 		            	dev = resultat.getString("devise"); 		            
 		            }
 		         
 		        
 		            	
 		            
 		         
 		        } catch (SQLException e) {
 		            e.printStackTrace();
 		        }finally {
 		            // Fermeture de la connexion
 		            try {
 		                if (resultat != null)
 		                    resultat.close();
 		                if (statement != null)
 		                    statement.close();
 		                if (connexion != null)
 		                    connexion.close();
 		            } catch (SQLException ignore) {
 		            }
 		        } 
 		        return dev;
 	

 	  }
	

}
