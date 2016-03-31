package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractProductCategory;

public class JDBCProductCategory extends AbstractProductCategory{

	public JDBCProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCProductCategory(int idCategory, String name, int idSuperCategory) {
		super(idCategory, name, idSuperCategory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ArrayList<String>> loadAllDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String query = "Select idCategory, name From ProductCategory;";
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
		String query = "INSERT INTO ProductCategory (name) VALUES ('" + this.getName() + "');";
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
		String queryGeneralTask = "UPDATE ProductCategory Set name = '" + this.getName() + "' WHERE idCategory = '" + this.getIdCategory() + "');";
		try {
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

	@Override
	public void deleteDB() throws SQLException {
		String queryGeneralTask = "Delete from ProductCategory where idCategory = '" + this.getIdCategory() + "';";
		try {
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

}
