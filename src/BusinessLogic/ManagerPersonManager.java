package BusinessLogic;

import Persistance.JDBCFactory;

public class ManagerPersonManager {
	
	private AbstractFactory myFactory;

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
