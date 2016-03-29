package Persistance;
import BusinessLogic.AbstractProduct;

public class JDBCProduct extends AbstractProduct{

	public JDBCProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCProduct(int idProduct, String name, String description, float quantity, String reference, float price,
			int idCategory, int idRole) {
		super(idProduct, name, description, quantity, reference, price, idCategory, idRole);
		// TODO Auto-generated constructor stub
	}




}
