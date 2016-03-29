package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractBasket;
public class JDBCBasket extends AbstractBasket {

	public JDBCBasket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCBasket(int idBasket, int idRole) {
		super(idBasket, idRole);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int saveInsertDB(int role) throws SQLException {
		String queryBasket = "INSERT INTO Basket(idRole) VALUES ('" + String.valueOf(role) + "');";
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(queryBasket);
		int id_AutoIncrement = 0;
	    if (rs.next()){
	    	id_AutoIncrement=rs.getInt(1);
	    }
	    return id_AutoIncrement;
	}

	@Override
	public void loadDB() throws SQLException {
		String queryBasket = "Select * From Basket Where idRole = '" + "// METTRE ICI LE ROLE RECUPERER DANS LA LISTE D'INSTANCE DU MANAGER" + "';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryBasket);
	    while (rs.next()) {
	    	this.setIdRole(Integer.parseInt(rs.getString("idRole")));
	    	this.setIdBasket(Integer.parseInt(rs.getString("idBasket")));
	        }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
		}
		
	}

	@Override
	public String[][] loadContentDB() throws SQLException {
		String[][] res;
		int count = 0;
		String queryBasketContent = "Select * From Basket Where idRole = '" + "" + "';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryBasketContent);
		while (rs.next()) {
			count++;
		}
		rs.beforeFirst();
		res = new String[count][10];
		int i = 0;
		while (rs.next()) {
	    	for (int j= 0; j<10; j++){
	    		res[i][j] = rs.getString(j);
	    	}
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
		}
		return res;
	}
	
	
}
