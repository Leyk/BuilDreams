package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractCommand;
import BusinessLogic.AbstractRole;

public class JDBCCommand extends AbstractCommand{

	public JDBCCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCCommand(int idCommand, int idRole) {
		super(idCommand, idRole);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int saveInsertDB(int userIdRole) throws SQLException {
		String format = "yyyy-MM-dd"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		String queryCommand = "INSERT INTO Command (idRole, createdDate) VALUES ('" + String.valueOf(userIdRole) + "','" + (formater.format(date)) + "');";
		try {
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(queryCommand);
		int id_AutoIncrement = 0;
	    if (rs.next()){
	    	id_AutoIncrement=rs.getInt(1);
	    }
	    return id_AutoIncrement;
		} catch (SQLException e) {
			throw new SQLException("Erreur, ");
		}
	}

	@Override
	public void insertLinkedItems(ArrayList<String> listItemBasket) throws SQLException {
		try {
		for (int i = 0 ; i<listItemBasket.size() ; i++) {
			String queryCommand = "INSERT INTO itemCommand (idItem, idCommand) VALUES ('" + String.valueOf(listItemBasket.get(i)) + "','" + String.valueOf(this.getIdCommand()) + "');";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryCommand);
		}
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, ");
		}
		
		
	}

	@Override
	public void insertLinkedSellers(ArrayList<String> listSellerBasket) throws SQLException {
		try {
			for (int i = 0 ; i<listSellerBasket.size() ; i++) {
				String queryCommand = "INSERT INTO commandSeller (state, idRole, idCommand) VALUES ('en attente' , '" + String.valueOf(listSellerBasket.get(i)) + "','" + String.valueOf(this.getIdCommand()) + "');";
				JDBCSingleton.getInstance().UpdateWithoutResultSet(queryCommand);
			}
		} catch (SQLException e) {
			throw new SQLException("Erreur,");
		}
	}

	@Override
	public ArrayList<ArrayList<String>> loadOrderDB(ArrayList<AbstractRole> myAbstractArrayListRoleIn) throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryOrderContent = "Select C.idcommand, C.createdDate, P.nickname, CS.state from command C, Users U, Role R, Person P, commandSeller CS Where C.idRole = U.idRole and U.idRole = R.idRole and R.nickname = P.nickname and C.idCommand = CS.idCommand and CS.idRole = "+myAbstractArrayListRoleIn.get(0).getIdRole();
		try{
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryOrderContent);
		int i = 0;
		while (rs.next()) {
			ArrayList<String> temp = new ArrayList<String>();
	    	for (int j= 0; j<4; j++){
	    		temp.add(j,rs.getString(j+1));
	    	}
	    	res.add(i, temp);
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadContentDB");
		}
		return res;
	}
}
