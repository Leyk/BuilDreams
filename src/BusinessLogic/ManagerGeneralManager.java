package BusinessLogic;

public class ManagerGeneralManager {
	
	private AbstractFactory myFactory;

	public ManagerGeneralManager() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String[][] loadAllGeneralTask() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addGeneralProject(String name, String description, int idProjectCategory,
			String[] linkedGeneralTasks) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveLinkedGeneralTask(int idGeneralProject, String[] linkedGeneralTasks) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[][] loadAllGeneralProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] loadGeneralProject(int idGeneralProject) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[][] loadAllTasksLinkedToGeneralProject(int idGeneralProject) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory,
			String[] linkedGeneralTasks) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteGeneralProject(int idGeneralProject) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addGeneralTask(String name, String description, int theoreticalLength, int idTaskCategory,
			String[][] linkedProductCategories) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveLinkedProductCategories(int idGeneralTask, String[][] linkedProductCategories) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] loadGeneralTask(int idGeneralTask) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[][] loadAllProductCategoriesLinkedToGeneralTask(int idGeneralTask) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength,
			int idTaskCategory, String[][] linkedProductCategories) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteGeneralTask(int idGeneralTask) {
		// TODO Auto-generated method stub
		return false;
	}
}