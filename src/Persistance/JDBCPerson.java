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
	
	/* M�thode permettant de remplir les attributs de l'objet user r�cup�r�s dans la base de donn�es */
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
	
	/* M�thode qui essaie de se connecter � la base de donn�es, si r�ussie, on "instancie compl�tement" l'objet, sinon on throw une erreur */
	public JDBCPerson loadDB () throws SQLException {
		String[] res = JDBCSingleton.getInstance().loadDB(this.getPseudo(),this.getPassword());
		
		if (res[0] != ""){
			this.remplissageAttributs(res);
		}
		else {
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
		}
		
		return this;
	}
}
