package Persistance;
import java.sql.Date;
import java.sql.SQLException;

import BusinessLogic.AbstractGeneralProject;
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

	@Override
	public int saveInsertFromGeneralProjectDB(int idGeneralProject, Date beginDate, Date endDate) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}



}
