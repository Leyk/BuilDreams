package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;
import Persistance.JDBCPerson;

public class ManagerLogin {
	private AbstractFactory myFactory;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray = new ArrayList<AbstractRole>();


	public AbstractPerson getMyPerson() {
		return myPerson;
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myPerson = myPerson;
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return myAbstractRoleArray;
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myAbstractRoleArray = myAbstractRoleArray;
	}
	
	
	public ManagerLogin () {
		this.myFactory = new JDBCFactory();
	}
	

	/* M�thode qui appelle le loadDB du user stock�, s'il y a match (le user existe en base) alors ok on appelle la m�thode de remplissage, 
	 * sinon on traite l'erreur en renvoyant un tableau vide, la vue affichera le bon r�sultat */
	public boolean login(String pseudoIn, String passwordIn) {
		myPerson = this.myFactory.createPerson(pseudoIn, passwordIn);
		AbstractAdmin myAdmin = this.myFactory.createAdmin();
		AbstractUsers myUsers = this.myFactory.createUsers();
		AbstractSeller mySeller = this.myFactory.createSeller();
		try {
		myPerson.loadDB();
		myAdmin.loadDB(pseudoIn);
		myUsers.loadDB(pseudoIn);
		mySeller.loadDB(pseudoIn);
		
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
			System.out.println("La connexion s'est pas passée, identifiants erronés sûrement");
			return false;
		}
		
		return true;
	}
}
