package BusinessLogic;

import Persistance.JDBCFactory;

public class ManagerProfileModifier {
	
	private AbstractFactory myFactory;

	public ManagerProfileModifier() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public boolean modifyProfileSeller(String name, String surname, String email, String password, String phoneNumber,
			int siret, String webSite, String domainActivity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyProfileUsers(String name, String surname, String email, String password, String phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}
}
