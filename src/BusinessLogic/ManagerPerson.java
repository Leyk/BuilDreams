package BusinessLogic;

import java.sql.SQLException;

import Persistance.JDBCPerson;

public class ManagerPerson {
	private AbstractPerson myUser;
	private AbstractFactory myFactory;
	private String [] resConnexion;
	
	public ManagerPerson (String nicknameIn, String passwordIn) {
		this.myFactory = new MyFactory ();
		this.myUser = ((MyFactory)this.myFactory).createUserJDBC(nicknameIn, passwordIn);
		resConnexion = new String[6];
	}
	
	/* Remplit le tableau avec les attributs de l'objet user, que l'on renvoie à la vue afin de les afficher */
	private String[] creationTableau(JDBCPerson userJDBCIn){		
		resConnexion [0] = userJDBCIn.getPseudo();
		resConnexion [1] = userJDBCIn.getPassword();
		resConnexion [2] = userJDBCIn.getFirstName();
		resConnexion [3] = userJDBCIn.getLastName();
		resConnexion [4] = userJDBCIn.getEmail();
		resConnexion [5] = userJDBCIn.getPhoneNumber();
		
		return resConnexion;
	}
	
	/* Méthode qui appelle le loadDB du user stocké, s'il y a match (le user existe en base) alors ok on appelle la méthode de remplissage, 
	 * sinon on traite l'erreur en renvoyant un tableau vide, la vue affichera le bon résultat */
	public String[] loginJDBC () {
		try {
			this.creationTableau(((JDBCPerson)this.myUser).loadDB());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resConnexion[0] = "";
		}
		
		return resConnexion;
	}
}
