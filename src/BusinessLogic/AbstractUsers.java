package BusinessLogic;

import java.sql.SQLException;

public abstract class AbstractUsers extends AbstractRole{

	public AbstractUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractUsers(String wording, int idRole) {
		super(wording, idRole);
		// TODO Auto-generated constructor stub
	}

	public abstract int saveInsertDB(String pseudo) throws SQLException;

	public abstract AbstractUsers loadDB(String pseudoIn);
	
	
}
