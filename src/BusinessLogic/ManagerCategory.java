package BusinessLogic;

import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerCategory {
	
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

	public ManagerCategory() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public ArrayList<ArrayList<String>> loadAllProductCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addProductCategory(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProductCategory(int idCategory, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProductCategory(int idCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ArrayList<String>> loadAllProjectCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addProjectCategory(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProjectCategory(int idProjectCategory, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProjectCategory(int idProjectCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ArrayList<String>> loadAllTaskCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addTaskCategory(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateTaskCategory(int idTaskCategory, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTaskCategory(int idTaskCategory) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
