package BusinessLogic;

import Persistance.JDBCFactory;

public class ManagerPersonManager {
	
	private AbstractFactory myFactory;

	public ManagerPersonManager() {
		super();
		this.myFactory = new JDBCFactory();
	}
	
	public String updateSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn,
			String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn,
			String textFieldWebIn, String textFieldDomainActivityIn) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn,
			String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deletePerson(String textFieldPseudoIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
