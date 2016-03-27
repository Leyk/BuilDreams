package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.AbstractAdmin;
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
	
	private void remplissageAttributs (String [] tableAttributs) {
		this.setWording(tableAttributs[0]);
		this.setIdRole(Integer.parseInt(tableAttributs[1]));
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

	
	@Override
	public AbstractUsers loadDB(String pseudoIn){
		String[] res = new String [2];
		res[0] = "";
		String queryRole = "SELECT idRole FROM Role WHERE Role.nickname = '" + pseudoIn + "';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryRole);
		int role = 0;
	    while (rs.next()){
	    	try {
	    	role=rs.getInt(1);
	    	String queryUsers = "SELECT wording, idRole FROM Users WHERE Users.idRole = '" + role + "';";
	    	ResultSet rs2 = JDBCSingleton.getInstance().RequestWithResultSet(queryUsers);
	    	while (rs2.next()) {
	    		res[0] = rs2.getString("wording");
	    		res[1] = rs2.getString("idRole");
	    	}
	    	} catch (SQLException e) {
				System.out.println("Pas encore trouvé de role correspondant");
		    }
	    }
		}
	    catch (SQLException e) {
			System.out.println("Pas de role Users pour cette personne");
	    }
    	if (res[0] != ""){
			this.remplissageAttributs(res);
		}
	    return this;
    }

}
