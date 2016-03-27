package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.AbstractSeller;

public class JDBCSeller extends AbstractSeller{

	public JDBCSeller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCSeller(String wording, int siret, String webSite, String domainActivity, int idRole) {
		super(wording, siret, webSite, domainActivity, idRole);
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
	    String querySeller = "INSERT INTO Seller (wording, siret, webSite, domainActivity, idRole) VALUES ('seller'," + this.getSiret() + ",'" + this.getWebSite() + "','" + this.getDomainActivity() + "'," + String.valueOf(id_AutoIncrement) + ");";
	    JDBCSingleton.getInstance().UpdateWithoutResultSet(querySeller);
		return id_AutoIncrement;
	}

}
