package Persistance;
import BusinessLogic.AbstractProduct;

public class JDBCProduct extends AbstractProduct{

	public JDBCProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCProduct(int idProduct, String name, String description, float quantity, int idCategory, int idRole) {
		super(idProduct, name, description, quantity, idCategory, idRole);
		// TODO Auto-generated constructor stub
	}

}
