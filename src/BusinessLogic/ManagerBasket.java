package BusinessLogic;

public class ManagerBasket {
	
	private AbstractFactory myFactory;

	public ManagerBasket() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String[][] loadBasket() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteItemFromBasket(int idItem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyQuantityForItem(int idItem, float newQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveBasketQuantities() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passCommand(String cbInfos) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
