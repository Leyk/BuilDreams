package BusinessLogic;

public class ManagerProductSeller {
	
	private AbstractFactory myFactory;

	public ManagerProductSeller() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String[][] loadAllProductSeller() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addProductSeller(String name, String description, float quantity, String reference, float price,
			int idCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProductSeller(int idProduct, String name, String description, float quantity, String reference,
			float price, int idCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProductSeller(int idProduct) {
		// TODO Auto-generated method stub
		return false;
	}
}
