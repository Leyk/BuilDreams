package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractGeneralTask;

public class JDBCGeneralTask extends AbstractGeneralTask{

	public JDBCGeneralTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength,
			int idTaskCategory) {
		super(idGeneralTask, name, description, theoreticalLength, idTaskCategory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ArrayList<String>> loadAllDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryGeneralTaskAll = "Select GT.idGeneraltask, GT.name, TC.name, GT.theoreticallength From GeneralTask GT, TaskCategory TC where TC.idTaskCategory = GT.idTaskCategory";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryGeneralTaskAll);
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
			throw new SQLException("Erreur, loadAllDB");
		}
		return res;
	}

	@Override
	public int saveInsertDB() throws SQLException {
		String queryGeneralTask = "INSERT INTO GeneralTask (name, description, theoreticalLength, idTaskCategory) VALUES ('" + this.getName() + "','" + this.getDescription() + "','" + this.getTheoreticalLength() + "','" + this.getIdTaskCategory() + "');";
		try {
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(queryGeneralTask);
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
	public void saveLinkedProductCategoriesForNewTask(int id, String[][] linkedProductCategories) throws SQLException {
		try {
			for (int i = 0 ; i<linkedProductCategories.length ; i++) {
				String queryInsert = "INSERT INTO hasQuantityGT (quantity, unit, idGeneralTask, idCategory) VALUES ('" + String.valueOf(linkedProductCategories[i][0]) + "','" + String.valueOf(linkedProductCategories[i][1]) + "','" + String.valueOf(id) + "','" + String.valueOf(linkedProductCategories[i][0]) + "');";
				JDBCSingleton.getInstance().UpdateWithoutResultSet(queryInsert);
			}
			}
			catch (SQLException e) {
				throw new SQLException("Erreur, l'insertion s'est pas faite");
			}	
		
	}

	@Override
	public void saveLinkedProductCategoriesForExistingTask(String[][] linkedProductCategories) throws SQLException {
		try {
			String queryDelete = "DELETE FROM hasQuantityGT Where idGeneralTask = '" + this.getIdGeneralTask() + "';";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete);
			for (int i = 0 ; i<linkedProductCategories.length ; i++) {
				String queryInsert = "INSERT INTO hasQuantityGT (quantity, unit, idGeneralTask, idCategory) VALUES ('" + String.valueOf(linkedProductCategories[i][0]) + "','" + String.valueOf(linkedProductCategories[i][1]) + "','" + String.valueOf(this.getIdGeneralTask()) + "','" + String.valueOf(linkedProductCategories[i][0]) + "');";
				JDBCSingleton.getInstance().UpdateWithoutResultSet(queryInsert);
			}
			}
			catch (SQLException e) {
				throw new SQLException("Erreur, l'insertion s'est pas faite");
			}	
		
	}

	@Override
	public ArrayList<String> loadDB() throws SQLException {
		ArrayList<String> res = new ArrayList<String>();
		String queryGeneralTask = "Select idGeneralTask, name, description, theoreticalLenght, idProjectCategory from GeneralProject where idGeneralTask = '" + this.getIdGeneralTask() +"';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryGeneralTask);
		while (rs.next()) {
	    	for (int i= 0; i<5; i++){
	    		res.add(i,rs.getString(i+1));
	    	}
	    }
		return res;
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadDB");
		}
	}

	@Override
	public ArrayList<ArrayList<String>> loadAllProductLinked() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryProductLinked = "Select ProductCategory.idCategory, ProductCategory.name From ProductCategory, hasQualityGT where hasQualityGT.idGeneralTask = '" + this.getIdGeneralTask() + "' and hasQualityGT.idCategory = ProductCategory.idCategory;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryProductLinked);
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
	public void saveUpdateDB() throws SQLException {
		String queryGeneralTask = "UPDATE GeneralTask Set name = '" + this.getName() + "', description = '" + this.getDescription() + "', theoreticalLength = '" + this.getTheoreticalLength() + "', idTaskCategory = '" + this.getIdTaskCategory() + "' WHERE idGeneralTask = '" + this.getIdGeneralTask() + "');";
		try {
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

	@Override
	public void deleteTask() throws SQLException {
		try {
			String queryDelete1 = "Delete from GeneralTask where idGeneralTask = '" + this.getIdGeneralTask() + "';";
			String queryDelete2 = "Delete from hasQuantityGT where idGeneralTask = '" + this.getIdGeneralTask() + "';";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete1);
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete2);
		} catch (SQLException e) {
			throw new SQLException("Erreur, deleteProject");
		}
	}

}
