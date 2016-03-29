package BusinessLogic;

import Persistance.JDBCFactory;

public class ManagerShopOrder {
	
	private AbstractFactory myFactory;

	public ManagerShopOrder() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String[][] loadAllCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[][] loadCommand(int idCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changeState(int idCommand, int state) {
		// TODO Auto-generated method stub
		return false;
	}
}
