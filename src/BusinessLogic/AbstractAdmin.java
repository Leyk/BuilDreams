package BusinessLogic;

import java.sql.SQLException;

public abstract class AbstractAdmin extends AbstractRole{
	
	public AbstractAdmin(String wording, int idRole) {
		super(wording, idRole);
	}

	public AbstractAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract AbstractAdmin loadDB(String pseudoIn);

	

}
