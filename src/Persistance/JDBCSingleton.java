package Persistance;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public String registrationUser (String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) throws SQLException {		
		String url = this.myParam.getURL();
		String username = this.myParam.getUsername();
		String password = this.myParam.getPassword();
		
		String res = "";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement st = (Statement) connection.createStatement();
		    String queryPerson = "INSERT INTO Person(nickname, name, surname, email, password, phoneNumber) VALUES ('" + textFieldSurnameIn + "','" + textFieldNameIn + "','" + textFieldNameIn + "','" + textFieldEmailIn + "','" + textFieldPasswordIn + "','" + textFieldPhoneIn + "');";
		    String queryRole = "INSERT INTO Role(nickname) VALUES ('" + textFieldSurnameIn + "');";
		    
		    st.executeUpdate(queryPerson);
		    
		    PreparedStatement pstmt = connection.prepareStatement(queryRole, Statement.RETURN_GENERATED_KEYS);  
		    int numero = pstmt.executeUpdate();  
		    ResultSet keys = pstmt.getGeneratedKeys();    
		    
		    
		    int id_AutoIncrement = 0;
	    
		    if (keys.next()){
		    	id_AutoIncrement=keys.getInt(1);
		    }
		    
		   
		    String queryUser = "INSERT INTO Users (wording, idRole) VALUES ('users'," + String.valueOf(id_AutoIncrement) + ");"; 
		    st.executeUpdate(queryUser);
		    
		    res = "OK";

		    connection.close();
		    
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException("Erreur, l'identifiant existe dans la base de données");
		}
		
		return res;
	}
	
	
}
