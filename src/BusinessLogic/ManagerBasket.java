package BusinessLogic;

import java.sql.SQLException;

public class ManagerBasket {
	
	private AbstractFactory myFactory;
	private String[][] myBasketContent;
	private AbstractBasket myBasket;

	public ManagerBasket() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String[][] loadBasket() {
		String[][] resBasket = new String[1][1];
		AbstractBasket myBasket = this.myFactory.createBasket();
		try {
		myBasket.loadDB();
		resBasket = myBasket.loadContentDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resBasket[0][0] = "";
		}
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
