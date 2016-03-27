package Persistance;
import BusinessLogic.AbstractGeneralTask;

public class JDBCGeneralTask extends AbstractGeneralTask{

	public JDBCGeneralTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength,
			int idTaskCategory) {
		super(idGeneralTask, name, description, theoreticalLength, idTaskCategory);
		// TODO Auto-generated constructor stub
	}

}
