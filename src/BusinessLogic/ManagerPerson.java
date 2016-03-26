package BusinessLogic;

import java.sql.SQLException;

import Persistance.JDBCPerson;

public class ManagerPerson {
	private AbstractPerson myUser;
	private AbstractFactory myFactory;
	private String [] resConnexion;
	
	public ManagerPerson () {
		this.myFactory = new MyFactory ();
		resConnexion = new String[6];
	}
	
	/* Remplit le tableau avec les attributs de l'objet user, que l'on renvoie � la vue afin de les afficher */
	private String[] creationTableau(JDBCPerson userJDBCIn){		
		resConnexion [0] = userJDBCIn.getPseudo();
		resConnexion [1] = userJDBCIn.getPassword();
		resConnexion [2] = userJDBCIn.getFirstName();
		resConnexion [3] = userJDBCIn.getLastName();
		resConnexion [4] = userJDBCIn.getEmail();
		resConnexion [5] = userJDBCIn.getPhoneNumber();
		
		return resConnexion;
	}
	
	/* M�thode qui appelle le loadDB du user stock�, s'il y a match (le user existe en base) alors ok on appelle la m�thode de remplissage, 
	 * sinon on traite l'erreur en renvoyant un tableau vide, la vue affichera le bon r�sultat */
	public String[] loginJDBC (String nicknameIn, String passwordIn) {
		this.myUser = ((MyFactory)this.myFactory).createPersonJDBC(nicknameIn, passwordIn);
		try {
			this.creationTableau(((JDBCPerson)this.myUser).loadDB());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resConnexion[0] = "";
		}
		
		return resConnexion;
	}
}
