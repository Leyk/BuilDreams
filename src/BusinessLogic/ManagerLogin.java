package BusinessLogic;

import java.sql.SQLException;

import Persistance.JDBCPerson;

public class ManagerLogin {
	private AbstractPerson myPerson;
	private AbstractFactory myFactory;
	private String [] resConnexion;
	
	public ManagerLogin () {
		this.myFactory = new JDBCFactory();
		resConnexion = new String[6];
	}
	
	/* Remplit le tableau avec les attributs de l'objet user, que l'on renvoie � la vue afin de les afficher */
	private String[] creationTableau(AbstractPerson personIn){		
		resConnexion [0] = personIn.getPseudo();
		resConnexion [1] = personIn.getName();
		resConnexion [2] = personIn.getSurname();
		resConnexion [3] = personIn.getEmail();
		resConnexion [4] = personIn.getPassword();
		resConnexion [5] = personIn.getPhoneNumber();
		
		return resConnexion;
	}
	
	/* M�thode qui appelle le loadDB du user stock�, s'il y a match (le user existe en base) alors ok on appelle la m�thode de remplissage, 
	 * sinon on traite l'erreur en renvoyant un tableau vide, la vue affichera le bon r�sultat */
	public String[] login(String pseudoIn, String passwordIn) {
		this.myPerson = this.myFactory.createPerson(pseudoIn, passwordIn);
		try {
			this.creationTableau(this.myPerson.loadDB());
		} catch (SQLException e) {
			resConnexion[0] = "";
		}
		
		return resConnexion;
	}
}
