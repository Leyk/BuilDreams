package BusinessLogic;

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
