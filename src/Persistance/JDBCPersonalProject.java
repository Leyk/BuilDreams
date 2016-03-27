package Persistance;
import java.sql.Date;

import BusinessLogic.AbstractPersonalProject;

public class JDBCPersonalProject extends AbstractPersonalProject{

	public JDBCPersonalProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCPersonalProject(int idPersonalProject, String name, String description, Date beginDate, Date endDate,
			int idRole, int idProjectCategory) {
		super(idPersonalProject, name, description, beginDate, endDate, idRole, idProjectCategory);
		// TODO Auto-generated constructor stub
	}

}
