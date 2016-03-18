package Persistance;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSingleton implements Serializable {

	private Parametres myParam;
	
	/** Constructeur privé */
	private JDBCSingleton() {
		myParam = new Parametres();
	}
	
	/** Instance unique pré-initialisée */
	private static JDBCSingleton INSTANCE = new JDBCSingleton();
	
	/** Point d'accès pour l'instance unique du singleton */
	public static JDBCSingleton getInstance(){
		return INSTANCE;
	}
	
	/** Sécurité anti-désérialisation */
	private Object readResolve() {
		return INSTANCE;
	}
	
	public String[] loadDB (String nicknameIn, String passwordIn) throws SQLException {
		String[] res = new String [6];
		res[0] = "";
		
		String url = this.myParam.getURL();
		String username = this.myParam.getUsername();
		String password = this.myParam.getPassword();
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    //System.out.println("Database connected!");
		    
		    Statement st = (Statement) connection.createStatement();
		    String query = "Select * From Person Where nickname = '" + nicknameIn + "' and password = '" + passwordIn + "';";
		    //System.out.println("query + " + query);
		    ResultSet rs = st.executeQuery(query);
		    
		    /* à améliorer */
		    
		   
	    	
		    while (rs.next()) {
		    	res[0] = rs.getString("nickname");
		        res[1] = rs.getString("name");
		        res[2] = rs.getString("surname");
		        res[3] = rs.getString("email");
		        res[4] = rs.getString("password");
		        res[5] = rs.getString("phoneNumber");
		        //System.out.println(res[0] + "|" + res[1] + "|" + res[2] + "|" + res[3] + "|" + res[4] + "|" + res[5]);
		    }
		    
		    
		    rs.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		if (res[0] == ""){
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de données");
		}
		
		return res;
	}
}
