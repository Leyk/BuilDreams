package BusinessLogic;

import java.sql.SQLException;
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
		ArrayList<ArrayList<String>> resProductCategory = new ArrayList<ArrayList<String>>();
		AbstractProductCategory myProductCategory = this.myFactory.createProductCategory();
		try {	
		resProductCategory = myProductCategory.loadAllDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resProductCategory.add(0, null);
		}
		return resProductCategory;
	}

	public boolean addProductCategory(String name) {
		AbstractProductCategory myProductCategory = this.myFactory.createProductCategory(0, name, 0);
		try {
		int id = myProductCategory.saveInsertDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateProductCategory(int idCategory, String newName) {
		AbstractProductCategory myProductCategory = this.myFactory.createProductCategory(idCategory, newName, 0);
		try {
		myProductCategory.saveUpdateDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean deleteProductCategory(int idCategory) {
		AbstractProductCategory myProductCategory = this.myFactory.createProductCategory(idCategory, "", 0);
		try {
		myProductCategory.deleteDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public ArrayList<ArrayList<String>> loadAllProjectCategory() {
		ArrayList<ArrayList<String>> resProjectCategory = new ArrayList<ArrayList<String>>();
		AbstractProjectCategory myProjectCategory = this.myFactory.createProjectCategory();
		try {	
		resProjectCategory = myProjectCategory.loadAllDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resProjectCategory.add(0, null);
		}
		return resProjectCategory;
	}

	public boolean addProjectCategory(String name) {
		AbstractProjectCategory myProjectCategory = this.myFactory.createProjectCategory(0, name, 0);
		try {
		int id = myProjectCategory.saveInsertDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateProjectCategory(int idProjectCategory, String newName) {
		AbstractProjectCategory myProjectCategory = this.myFactory.createProjectCategory(idProjectCategory, newName, 0);
		try {
		myProjectCategory.saveUpdateDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean deleteProjectCategory(int idProjectCategory) {
		AbstractProjectCategory myProjectCategory = this.myFactory.createProjectCategory(idProjectCategory, "", 0);
		try {
		myProjectCategory.deleteDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public ArrayList<ArrayList<String>> loadAllTaskCategory() {
		ArrayList<ArrayList<String>> resTaskCategory = new ArrayList<ArrayList<String>>();
		AbstractTaskCategory myTaskCategory = this.myFactory.createTaskCategory();
		try {	
		resTaskCategory = myTaskCategory.loadAllDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resTaskCategory.add(0, null);
		}
		return resTaskCategory;
	}

	public boolean addTaskCategory(String name) {
		AbstractTaskCategory myTaskCategory = this.myFactory.createTaskCategory(0, name, 0);
		try {
		int id = myTaskCategory.saveInsertDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateTaskCategory(int idTaskCategory, String newName) {
		AbstractTaskCategory myTaskCategory = this.myFactory.createTaskCategory(idTaskCategory, newName, 0);
		try {
		myTaskCategory.saveUpdateDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean deleteTaskCategory(int idTaskCategory) {
		AbstractTaskCategory myTaskCategory = this.myFactory.createTaskCategory(idTaskCategory, "", 0);
		try {
		myTaskCategory.deleteDB();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
}
