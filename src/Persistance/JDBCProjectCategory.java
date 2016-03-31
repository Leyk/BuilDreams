package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractProjectCategory;

public class JDBCProjectCategory extends AbstractProjectCategory{

	public JDBCProjectCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCProjectCategory(int idProjectCategory, String name, int idSuperProjectCategory) {
		super(idProjectCategory, name, idSuperProjectCategory);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<ArrayList<String>> loadAllDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String query = "Select idProjectCategory, name From ProjectCategory;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(query);
		int i = 0;
		while (rs.next()) {
			ArrayList<String> temp = new ArrayList<String>();
	    	for (int j= 0; j<2; j++){
	    		temp.add(j,rs.getString(j+1));
	    	}
	    	res.add(i, temp);
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadAllDB");
		}
		return res;
	}

	@Override
	public int saveInsertDB() throws SQLException {
		String query = "INSERT INTO ProjectCategory (name) VALUES ('" + this.getName() + "');";
		try {
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(query);
		int id_AutoIncrement = 0;
	    if (rs.next()){
	    	id_AutoIncrement=rs.getInt(1);
	    }
	    return id_AutoIncrement;
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

	@Override
	public void saveUpdateDB() throws SQLException {
		String queryGeneralTask = "UPDATE ProjectCategory Set name = '" + this.getName() + "' WHERE idProjectCategory = '" + this.getIdProjectCategory() + "');";
		try {
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

	@Override
	public void deleteDB() throws SQLException {
		String queryGeneralTask = "Delete from ProjectCategory where idProjectCategory = '" + this.getIdProjectCategory() + "';";
		try {
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}
}
