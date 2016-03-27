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
	    while (rs.next()){
	    	try {
	    	role=rs.getInt(1);
		    String querySeller = "SELECT wording, siret, webSite, domainActivity, idRole FROM Seller WHERE Seller.idRole = '" + role + "';";
		    ResultSet rs2 = JDBCSingleton.getInstance().RequestWithResultSet(querySeller);
		    while (rs2.next()) {
		    	res[0] = rs2.getString("wording");
		    	res[1] = rs2.getString("siret");
		    	res[2] = rs2.getString("webSite");
		    	res[3] = rs2.getString("domainActivity");
		        res[4] = rs2.getString("idRole");
		    }
	    	} catch (SQLException e) {
				System.out.println("Pas encore trouvé de role correspondant");
		    }
	    }
		}
	    catch (SQLException e) {
			System.out.println("Pas de role Seller pour cette personne");
	    }
	    if (res[0] != ""){
			this.remplissageAttributs(res);
		}
	    return this;
    }
}
