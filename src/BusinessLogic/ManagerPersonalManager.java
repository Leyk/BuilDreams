package BusinessLogic;

import java.sql.Date;

import Persistance.JDBCFactory;

public class ManagerPersonalManager {
	
	private AbstractFactory myFactory;

	public ManagerPersonalManager() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public boolean addPersonalProjectFromGeneralProject(int idGeneralProject, Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addGeneralProject(String name, String description, Date beginDate, Date endDate,
			int idProjectCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[][] loadAllPersonalProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] loadPersonalProject(int idPersonalProject) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[][] loadAllTasksLinkedToPersonalProject(int idPersonalProject) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatePersonalProject(int idPersonalProject, String name, String description, Date beginDate,
			Date endDate, int idProjectCategory, String[] linkedPersonalTasks) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePersonalProject(int idGeneralProject) {
		// TODO Auto-generated method stub
		return false;
	}

	public String addPersonalTask(String name, String description, Date beginDate, Date endDate, int theoreticalLength,
			int idTaskCategory, String[][] linkedProductCategories) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveLinkedProductCategories(int idPersonalTask, String[][] linkedProductCategories) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] loadPersonalTask(int idPersonalTask) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[][] loadAllProductCategoriesLinkedToPersonalTask(int idPersonalTask) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updatePersonalTask(int idPersonalTask, String name, String description, Date beginDate, Date endDate,
			int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePersonalTask(int idPersonalTask) {
		// TODO Auto-generated method stub
		return false;
	}
}
