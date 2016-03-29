package BusinessLogic;

import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerOnlineShop {
	
	private AbstractFactory myFactory;

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
