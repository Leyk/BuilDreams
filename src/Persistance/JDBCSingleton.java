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
	private Connection myConnection;
	
	/** Constructeur privé 
	 * @throws SQLException */
	private JDBCSingleton() {
		myParam = new Parametres();
		try {
			myConnection = this.connection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private Connection connection() throws SQLException{
		String url = this.myParam.getURL();
		String username = this.myParam.getUsername();
		String password = this.myParam.getPassword();
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public ResultSet RequestWithResultSet (String query) throws SQLException {
		try {
		    Statement st = (Statement) myConnection.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    return rs;
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void RequestWithoutResultSet (String query) throws SQLException {
		try {
		    Statement st = (Statement) myConnection.createStatement();
		    st.executeQuery(query);  
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
	
	public ResultSet UpdateWithResultSet(String query) throws SQLException {		
		try {
			PreparedStatement pstmt = myConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
		    ResultSet rs = pstmt.getGeneratedKeys();
		    return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException("Erreur, cet objet existe déjà dans cette table");
		}
	}
	
	public void UpdateWithoutResultSet(String query) throws SQLException {
		try {
			Statement st = (Statement) myConnection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException("Erreur, cet objet existe déjà dans cette table");
		}
	}

	
	
	
	/*public String registrationUser (String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) throws SQLException {		
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
	}*/
	
}
