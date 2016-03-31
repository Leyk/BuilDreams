package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerProductSeller {
	
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

	public ManagerProductSeller() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public ArrayList<ArrayList<String>> loadAllProductSeller() {
		ArrayList<ArrayList<String>> resShop = new ArrayList<ArrayList<String>>();
		AbstractProduct myProduct = this.myFactory.createProduct();
		try {
			resShop = myProduct.loadContentDB(this.myAbstractRoleArray.get(0).getIdRole());
		} catch (SQLException e) {
			e.printStackTrace();
			resShop.add(0, null);
		}
		return resShop;
	}

	public boolean addProductSeller(String name, String description, float quantity, String reference, float price,
			int idCategory) {
		AbstractProduct myProduct = this.myFactory.createProduct(0, name, description, quantity, reference, price, idCategory, this.myAbstractRoleArray.get(0).getIdRole());
		try {
		myProduct.saveInsertDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
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
