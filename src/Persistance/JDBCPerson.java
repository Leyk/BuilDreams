package Persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractPerson;

public class JDBCPerson extends AbstractPerson {
	/* Construction du USER JDBC */
	
	public JDBCPerson(String pseudoIn, String passwordIn) {
		super(pseudoIn, passwordIn);
	}
	
	public JDBCPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCPerson(String pseudo, String name, String surname, String email, String password, String phoneNumber) {
		super(pseudo, name, surname, email, password, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	/* M�thode permettant de remplir les attributs de l'objet user r�cup�r�s dans la base de donn�es */
	private void remplissageAttributs (String [] tableAttributs) {
		if (tableAttributs[1] != "") {
			this.setName(tableAttributs[1]);
		}
		if (tableAttributs[2] != "") {
			this.setSurname(tableAttributs[2]);
		}
		if (tableAttributs[3] != "") {
			this.setEmail(tableAttributs[3]);
		}
		if (tableAttributs[5] != "") {
			this.setPhoneNumber(tableAttributs[5]);
		}
	}
	
	/* M�thode qui essaie de se connecter � la base de donn�es, si r�ussie, on "instancie compl�tement" l'objet, sinon on throw une erreur */
	public AbstractPerson loadDB () throws SQLException {
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
	    }
	    
		
		if (res[0] != ""){
			this.remplissageAttributs(res);
		}
		else {
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
		}
		return this;
	}

	@Override
	public String saveInsertDB() throws SQLException {
		 String queryPerson = "INSERT INTO Person(nickname, name, surname, email, password, phoneNumber) VALUES ('" + this.getPseudo() + "','" + this.getName() + "','" + this.getSurname() + "','" + this.getEmail() + "','" + this.getPassword() + "','" + this.getPhoneNumber() + "');";
		 JDBCSingleton.getInstance().UpdateWithoutResultSet(queryPerson);
		 return this.getPseudo();
	}

	@Override
	public void updateDB(String name, String surname, String email, String password, String phoneNumber) throws SQLException {
		String queryUpdate = "Update Person set name = '"+name+"', surname = '"+surname+"', email = '"+email+"', password = '"+password+"', phonenumber = '" + phoneNumber + "' where nickname = '" + this.getPseudo() + "';";
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryUpdate);
	}

	@Override
	public ArrayList<ArrayList<String>> loadAllPersonDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryPersonContent = "select nickname, name, surname, email, phonenumber from person";
		try{
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryPersonContent);
		int i = 0;
		while (rs.next()) {
			ArrayList<String> temp = new ArrayList<String>();
		    for (int j= 0; j<5; j++){
		    	temp.add(j,rs.getString(j+1));
		    }
		    res.add(i, temp);
		    i++;
		   }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadContentDB");
		}
		return res;
	}

}
