package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerProduct {

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

	public ManagerProduct() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public ArrayList<ArrayList<String>> loadAllProduct() {
		ArrayList<ArrayList<String>> resShop = new ArrayList<ArrayList<String>>();
		AbstractProduct myProduct = this.myFactory.createProduct();
		try {
			resShop = myProduct.loadContentDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resShop.add(0, null);
		}
		return resShop;
	}

	public boolean updateProduct(int idProduct, String name, String description, float quantity, String reference,
			float price, int idCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProduct(int idProduct) {
		// TODO Auto-generated method stub
		return false;
	}
}
