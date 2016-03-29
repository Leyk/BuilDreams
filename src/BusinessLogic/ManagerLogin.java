package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;
import Persistance.JDBCPerson;

public class ManagerLogin {
	private AbstractFactory myFactory;
	private String [] resConnexion;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray = new ArrayList<AbstractRole>();
	
	
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
		AbstractPerson myPerson = this.myFactory.createPerson(pseudoIn, passwordIn);
		AbstractAdmin myAdmin = this.myFactory.createAdmin();
		AbstractUsers myUsers = this.myFactory.createUsers();
		AbstractSeller mySeller = this.myFactory.createSeller();
		try {
		myPerson.loadDB();
		myAdmin.loadDB(pseudoIn);
		myUsers.loadDB(pseudoIn);
		mySeller.loadDB(pseudoIn);
		creationTableau(myPerson);
		if (myAdmin.hasExistence()) {
			this.myAbstractRoleArray.add((AbstractRole)myAdmin);
		}
		if (myUsers.hasExistence()) {
			this.myAbstractRoleArray.add((AbstractRole)myUsers);
		}
		if (mySeller.hasExistence()) {
			this.myAbstractRoleArray.add((AbstractRole)mySeller);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			resConnexion[0] = "";
		}
		System.out.println(resConnexion[0]);
		System.out.println(resConnexion[1]);
		System.out.println(resConnexion[2]);
		System.out.println(resConnexion[3]);
		System.out.println(resConnexion[4]);
		System.out.println(resConnexion[5]);
		System.out.println(myAdmin.getWording());
		System.out.println(myAdmin.getIdRole());
		System.out.println(myUsers.getWording());
		System.out.println(myUsers.getIdRole());
		System.out.println(mySeller.getWording());
		System.out.println(mySeller.getSiret());
		System.out.println(mySeller.getWebSite());
		System.out.println(mySeller.getDomainActivity());
		System.out.println(mySeller.getIdRole());
		System.out.println(this.myAbstractRoleArray.size());
		System.out.println(this.myAbstractRoleArray.get(0).getWording());
		System.out.println(this.myAbstractRoleArray.get(0).getIdRole());
		
		return resConnexion;
	}
}
