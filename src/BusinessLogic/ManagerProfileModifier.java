package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerProfileModifier {
	
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

	public ManagerProfileModifier() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public boolean modifyProfileSeller(String name, String surname, String email, String password, String phoneNumber,
			int siret, String webSite, String domainActivity) {
		// TODO Auto-generated method stub
		Boolean res = true;
		
		try{
			this.myPerson.updateDB(name, surname, email, password, phoneNumber);
		}
		catch(SQLException e){
			System.out.print(e.getMessage());
			res = false;
		}
		return res;
	}

	public boolean modifyProfileUsers(String name, String surname, String email, String password, String phoneNumber) {
		// TODO Auto-generated method stub
		Boolean res = true;
		
		try{
			this.myPerson.updateDB(name, surname, email, password, phoneNumber);
		}
		catch(SQLException e){
			System.out.print(e.getMessage());
			res = false;
		}
		
		return res;
	}
}
