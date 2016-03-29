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
	    while (rs.next()){
	    	try {
	    	role=rs.getInt(1);
	    	String queryAdmin = "SELECT wording, idRole FROM Admin WHERE Admin.idRole = '" + role + "';";
	    	ResultSet rs2 = JDBCSingleton.getInstance().RequestWithResultSet(queryAdmin);
	    	while (rs2.next()) {
	    		res[0] = rs2.getString("wording");
	    		res[1] = rs2.getString("idRole");
	    	}
	    	} catch (SQLException e) {
	    		System.out.println("Pas encore trouv� de role correspondant");
	    	}
	    }
		}
	    catch (SQLException e) {
			System.out.println("Pas de role Admin pour cette personne");
	    }
		if (res[0] != ""){
			this.remplissageAttributs(res);
		}
		return this;
	}

	@Override
	public String[] returnYourAttributes() {
		String[] res = new String[2];
		res[0]=this.getWording();
		res[1]=String.valueOf(this.getIdRole());
		return res;
	}
	 
}
