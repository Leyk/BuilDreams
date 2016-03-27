package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.AbstractAdmin;

public class JDBCAdmin extends AbstractAdmin{

	public JDBCAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCAdmin(String wording, int idRole) {
		super(wording, idRole);
		// TODO Auto-generated constructor stub
	}
	
	private void remplissageAttributs (String [] tableAttributs) {
			this.setWording(tableAttributs[0]);
			this.setIdRole(Integer.parseInt(tableAttributs[1]));
	}

	@Override
	public AbstractAdmin loadDB(String pseudoIn){
		String[] res = new String [2];
		res[0] = "";
		String queryRole = "SELECT idRole FROM Role WHERE Role.nickname = '" + pseudoIn + "';";
		try{
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryRole);
		int role = 0;
	    if (rs.next()){
	    	role=rs.getInt(1);
	    }
	    rs = null;
	    String queryAdmin = "SELECT wording, idRole FROM Admin WHERE Admin.idRole = '" + role + "';";
	    rs = JDBCSingleton.getInstance().RequestWithResultSet(queryAdmin);
	    
	    while (rs.next()) {
	    	res[0] = rs.getString("wording");
	        res[1] = rs.getString("idRole");
	    }
	    if (res[0] != ""){
			this.remplissageAttributs(res);
		}
		}
	    catch (SQLException e) {
			System.out.println("Pas de role Admin pour cette personne");
	    }
		return this;
	}
	 
}
