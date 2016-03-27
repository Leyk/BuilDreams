package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.AbstractUsers;

public class JDBCUsers extends AbstractUsers{

	public JDBCUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCUsers(String wording, int idRole) {
		super(wording, idRole);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int saveInsertDB(String pseudo) throws SQLException {
		String queryRole = "INSERT INTO Role(nickname) VALUES ('" + pseudo + "');";
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(queryRole);
		int id_AutoIncrement = 0;
	    if (rs.next()){
	    	id_AutoIncrement=rs.getInt(1);
	    }
	    String queryUsers = "INSERT INTO Users (wording, idRole) VALUES ('users'," + String.valueOf(id_AutoIncrement) + ");";
	    JDBCSingleton.getInstance().UpdateWithoutResultSet(queryUsers);
		return id_AutoIncrement;
	}

}
