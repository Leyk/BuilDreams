package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerBasket {
	
	private AbstractFactory myFactory;
	private ArrayList<ArrayList<String>> myBasketContent;
	private AbstractBasket myBasket;

	public ManagerBasket() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public ArrayList<ArrayList<String>> loadBasket() {
		ArrayList<ArrayList<String>> resBasket = new ArrayList<ArrayList<String>>();
		AbstractBasket myBasket = this.myFactory.createBasket();
		try {
		myBasket.loadDB();
		resBasket = myBasket.loadContentDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resBasket.set(0, null);
		}
		this.myBasketContent = resBasket;
		return resBasket;
	}

	public boolean deleteItemFromBasket(int idItem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyQuantityForItem(int idItem, float newQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	// Peut etre pas 
	public boolean saveBasketQuantities() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passCommand(String cbInfos) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
