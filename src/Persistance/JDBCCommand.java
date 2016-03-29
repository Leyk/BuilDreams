package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractCommand;

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
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
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
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
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
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
		}
	}

}
