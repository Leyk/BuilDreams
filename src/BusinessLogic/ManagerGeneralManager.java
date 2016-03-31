package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerGeneralManager {
	
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

	public ManagerGeneralManager() {
		super();
		this.myFactory = new JDBCFactory();
	}

	
	public ArrayList<ArrayList<String>> loadAllGeneralTask() {
		ArrayList<ArrayList<String>> resGeneralTask = new ArrayList<ArrayList<String>>();
		AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask();
		try {	
		resGeneralTask = myGeneralTask.loadAllDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resGeneralTask.add(0, null);
		}
		return resGeneralTask;
	}

	public boolean addGeneralProject(String name, String description, int idProjectCategory,
		String[] linkedGeneralTasks) {
		AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject(0, name, description, idProjectCategory);
		try {
		int id = myGeneralProject.saveInsertDB();
		myGeneralProject.saveLinkedGeneralTasksForNewProject(id, linkedGeneralTasks);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean saveLinkedGeneralTask(int idGeneralProject, String[] linkedGeneralTasks) {
		AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject(idGeneralProject, "", "", 0);
		try {
		myGeneralProject.saveLinkedGeneralTasksForExistingProject(linkedGeneralTasks);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public ArrayList<ArrayList<String>> loadAllGeneralProject() {
		ArrayList<ArrayList<String>> resGeneralProject = new ArrayList<ArrayList<String>>();
		AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject();
		try {	
		resGeneralProject = myGeneralProject.loadAllDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resGeneralProject.add(0, null);
		}
		return resGeneralProject;
	}

	public ArrayList<String> loadGeneralProject(int idGeneralProject) {
		ArrayList<String> resGeneralProject = new ArrayList<String>();
		AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject(idGeneralProject, "", "", 0);
		try {
		resGeneralProject = myGeneralProject.loadDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resGeneralProject.add(0, null);
		}
		return resGeneralProject;
	}

	public ArrayList<ArrayList<String>> loadAllTasksLinkedToGeneralProject(int idGeneralProject) {
		ArrayList<ArrayList<String>> resTaskLinked = new ArrayList<ArrayList<String>>();
		AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject(idGeneralProject, "", "", 0);
		try {	
		resTaskLinked = myGeneralProject.loadAllTaskLinked();
		} catch (SQLException e) {
			e.printStackTrace();
			resTaskLinked.add(0, null);
		}
		return resTaskLinked;
	}

	public boolean updateGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory,
			String[] linkedGeneralTasks) {
		AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject(idGeneralProject, name, description, idProjectCategory);
		try {
		myGeneralProject.saveUpdateDB();
		myGeneralProject.saveLinkedGeneralTasksForExistingProject(linkedGeneralTasks);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean deleteGeneralProject(int idGeneralProject) {
		try {
			AbstractGeneralProject myGeneralProject = this.myFactory.createGeneralProject(idGeneralProject, "","",0);
			myGeneralProject.deleteProject();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addGeneralTask(String name, String description, int theoreticalLength, int idTaskCategory,
			String[][] linkedProductCategories) {
			AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask(0, name, description, theoreticalLength, idTaskCategory);
			try {
			int id = myGeneralTask.saveInsertDB();
			myGeneralTask.saveLinkedProductCategoriesForNewTask(id, linkedProductCategories);
			} catch (SQLException e) {
				return false;
			}
			return true;
	}

	public boolean saveLinkedProductCategories(int idGeneralTask, String[][] linkedProductCategories) {
		AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask(idGeneralTask, "", "",0,0);
		try {
		myGeneralTask.saveLinkedProductCategoriesForExistingTask(linkedProductCategories);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public ArrayList<String> loadGeneralTask(int idGeneralTask) {
		ArrayList<String> resGeneralTask = new ArrayList<String>();
		AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask(idGeneralTask, "", "",0, 0);
		try {
		resGeneralTask = myGeneralTask.loadDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resGeneralTask.add(0, null);
		}
		return resGeneralTask;
	}

	public ArrayList<ArrayList<String>> loadAllProductCategoriesLinkedToGeneralTask(int idGeneralTask) {
		ArrayList<ArrayList<String>> resProductLinked = new ArrayList<ArrayList<String>>();
		AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask(idGeneralTask, "", "",0, 0);
		try {	
		resProductLinked = myGeneralTask.loadAllProductLinked();
		} catch (SQLException e) {
			e.printStackTrace();
			resProductLinked.add(0, null);
		}
		return resProductLinked;
	}

	public boolean updateGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength,
			int idTaskCategory, String[][] linkedProductCategories) {
		AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask(idGeneralTask, name, description,theoreticalLength, idTaskCategory);
		try {
		myGeneralTask.saveUpdateDB();
		myGeneralTask.saveLinkedProductCategoriesForExistingTask(linkedProductCategories);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean deleteGeneralTask(int idGeneralTask) {
		try {
			AbstractGeneralTask myGeneralTask = this.myFactory.createGeneralTask(idGeneralTask, "","",0,0);
			myGeneralTask.deleteTask();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
