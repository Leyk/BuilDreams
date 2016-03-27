package Persistance;
import java.sql.Date;

import BusinessLogic.AbstractPersonalTask;

public class JDBCPersonalTask extends AbstractPersonalTask{

	public JDBCPersonalTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCPersonalTask(String name, String description, Date beginDate, Date endDate, int theoreticalLength,
			int idEntry, int idPersonalProject, int idTaskCategory) {
		super(name, description, beginDate, endDate, theoreticalLength, idEntry, idPersonalProject, idTaskCategory);
		// TODO Auto-generated constructor stub
	}

}
