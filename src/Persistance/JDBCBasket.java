package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
