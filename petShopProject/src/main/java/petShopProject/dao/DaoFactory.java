package petShopProject.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import petShopProject.dao.DaoFactory;
import petShopProject.dao.UtilisateurDao;
import petShopProject.dao.UtilisateurDaoImpl;

public class DaoFactory {
	
	private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	System.out.print("driver");

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/users", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // R�cup�ration du Dao
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }

}
