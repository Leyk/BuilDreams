package BusinessLogic;

import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerOnlineShop {
	
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

	public ManagerOnlineShop() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public ArrayList<ArrayList<String>> loadShop() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArrayList<String>> loadShopSeller(int idSeller) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArrayList<String>> loadShopCategory(int idCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArrayList<String>> loadShopSellerCategory(int idSeller, int idCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addItemToBasket(int idProduct, float quantity, float price) {
		// TODO Auto-generated method stub
		return false;
	}
}
