package BusinessLogic;

import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerPersonManager {
	
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

	public ManagerPersonManager() {
		super();
		this.myFactory = new JDBCFactory();
	}
	
	public boolean updateSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn,
			String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn,
			String textFieldWebIn, String textFieldDomainActivityIn) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn,
			String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePerson(String textFieldPseudoIn) {
		// TODO Auto-generated method stub
		return false;
	}

}
