package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.AbstractPerson;

public class JDBCPerson extends AbstractPerson {
	private Parametres myDBParameters;
	
	/* Construction du USER JDBC */
	public JDBCPerson(String pseudoIn, String passwordIn) {
		super(pseudoIn, passwordIn);
		this.myDBParameters = new Parametres();
	}
	
	/* Méthode permettant de remplir les attributs de l'objet user récupérés dans la base de données */
	private void remplissageAttributs (String [] tableAttributs) {
		if (tableAttributs[2] != "") {
			this.setFirstName(tableAttributs[2]);
		}
		if (tableAttributs[3] != "") {
			this.setLastName(tableAttributs[3]);
		}
		if (tableAttributs[4] != "") {
			this.setEmail(tableAttributs[4]);
		}
		if (tableAttributs[5] != "") {
			this.setPhoneNumber(tableAttributs[5]);
		}
	}
	
	/* Méthode qui essaie de se connecter à la base de données, si réussie, on "instancie complètement" l'objet, sinon on throw une erreur */
	public JDBCPerson loadDB () throws SQLException {
		String[] res = new String [6];
		res[0] = "";
		String query = "Select * From Person Where nickname = '" + this.getPseudo() + "' and password = '" + this.getPassword() + "';";
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(query);
		

	    while (rs.next()) {
	    	res[0] = rs.getString("nickname");
	        res[1] = rs.getString("name");
	        res[2] = rs.getString("surname");
	        res[3] = rs.getString("email");
	        res[4] = rs.getString("password");
	        res[5] = rs.getString("phoneNumber");
	        //System.out.println(res[0] + "|" + res[1] + "|" + res[2] + "|" + res[3] + "|" + res[4] + "|" + res[5]);
	    }
	    
		
		if (res[0] != ""){
			this.remplissageAttributs(res);
		}
		else {
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de données");
		}
		
		if (res[0] == ""){
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de données");
		}
		
		return this;
	}
}
