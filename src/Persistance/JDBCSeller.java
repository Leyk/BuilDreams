package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.AbstractSeller;
import BusinessLogic.AbstractUsers;

public class JDBCSeller extends AbstractSeller{

	public JDBCSeller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCSeller(String wording, int siret, String webSite, String domainActivity, int idRole) {
		super(wording, siret, webSite, domainActivity, idRole);
		// TODO Auto-generated constructor stub
	}
	
	private void remplissageAttributs (String [] tableAttributs) {
		this.setWording(tableAttributs[0]);
		this.setSiret(Integer.parseInt(tableAttributs[1]));
		this.setWebSite(tableAttributs[2]);
		this.setDomainActivity(tableAttributs[3]);
		this.setIdRole(Integer.parseInt(tableAttributs[4]));
	}
	
	@Override
	public int saveInsertDB(String pseudo) throws SQLException {
		String queryRole = "INSERT INTO Role (nickname) VALUES ('" + pseudo + "');";
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(queryRole);
		int id_AutoIncrement = 0;
	    if (rs.next()){
	    	id_AutoIncrement=rs.getInt(1);
	    }
	    String querySeller = "INSERT INTO Seller (wording, siret, webSite, domainActivity, idRole) VALUES ('seller'," + this.getSiret() + ",'" + this.getWebSite() + "','" + this.getDomainActivity() + "'," + String.valueOf(id_AutoIncrement) + ");";
	    JDBCSingleton.getInstance().UpdateWithoutResultSet(querySeller);
		return id_AutoIncrement;
	}

	@Override
	public AbstractSeller loadDB(String pseudoIn){
		String[] res = new String [5];
		res[0] = "";
		String queryRole = "SELECT idRole FROM Role WHERE Role.nickname = '" + pseudoIn + "';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryRole);
		int role = 0;
	    if (rs.next()){
	    	role=rs.getInt(1);
	    }
	    rs = null;
	    String querySeller = "SELECT wording, siret, webSite, domainActivity, idRole FROM Seller WHERE Seller.idRole = '" + role + "';";
	    rs = JDBCSingleton.getInstance().RequestWithResultSet(querySeller);
	    
	    while (rs.next()) {
	    	res[0] = rs.getString("wording");
	    	res[1] = rs.getString("siret");
	    	res[2] = rs.getString("webSite");
	    	res[3] = rs.getString("domainActivity");
	        res[4] = rs.getString("idRole");
	    }
	    if (res[0] != ""){
			this.remplissageAttributs(res);
		}
		}
	    catch (SQLException e) {
			System.out.println("Pas de role Seller pour cette personne");
	    }
	    return this;
    }
}
