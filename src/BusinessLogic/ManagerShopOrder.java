package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerShopOrder {
	
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

	public ManagerShopOrder() {
		super();
		this.myFactory = new JDBCFactory();
	}

	// Retrieve all the orders for the connected seller
	public ArrayList<ArrayList<String>> loadAllCommand() {
		ArrayList<ArrayList<String>> resOrder = new ArrayList<ArrayList<String>>();
		AbstractCommand myComm = this.myFactory.createCommand();
		try {
			resOrder = myComm.loadOrderDB(this.myAbstractRoleArray);
		} catch (SQLException e) {
			e.printStackTrace();
			resOrder.add(0, null);
		}
		return resOrder;
	}

	public ArrayList<ArrayList<String>> loadCommand(int idCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changeState(int idCommand, int state) {
		// TODO Auto-generated method stub
		return false;
	}
}
