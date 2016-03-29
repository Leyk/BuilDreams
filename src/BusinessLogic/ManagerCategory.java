package BusinessLogic;

import Persistance.JDBCFactory;

public class ManagerCategory {
	
	private AbstractFactory myFactory;

	public ManagerCategory() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String[][] loadAllProductCategory() {
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

	public String[][] loadAllProjectCategory() {
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

	public String[][] loadAllTaskCategory() {
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
