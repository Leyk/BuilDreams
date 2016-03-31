package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractGeneralProject;

public class JDBCGeneralProject extends AbstractGeneralProject{

	public JDBCGeneralProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory) {
		super(idGeneralProject, name, description, idProjectCategory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ArrayList<String>> loadAllDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryGeneralProjectAll = "Select idGeneralProject, name From GeneralProject;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryGeneralProjectAll);
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
		String queryGeneralTask = "INSERT INTO GeneralProject (name, description, idProjectCategory) VALUES ('" + this.getName() + "','" + this.getDescription() + "','" + this.getIdProjectCategory() + "');";
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
	public void saveLinkedGeneralTasksForNewProject(int id, String[] linkedGeneralTasks) throws SQLException {
		try {
			for (int i = 0 ; i<linkedGeneralTasks.length ; i++) {
				String queryInsert = "INSERT INTO isBelongGeneral (idGeneralProject, idGeneralTask) VALUES ('" + String.valueOf(id) + "','" + String.valueOf(linkedGeneralTasks[i]) + "');";
				JDBCSingleton.getInstance().UpdateWithoutResultSet(queryInsert);
			}
			}
			catch (SQLException e) {
				throw new SQLException("Erreur, l'insertion s'est pas faite");
			}	
	}

	@Override
	public void saveLinkedGeneralTasksForExistingProject(String[] linkedGeneralTasks) throws SQLException {
		try {
			String queryDelete = "DELETE FROM isBelongGeneral Where idGeneralProject = '" + this.getIdGeneralProject() + "';";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete);
			for (int i = 0 ; i<linkedGeneralTasks.length ; i++) {
				String queryInsert = "INSERT INTO isBelongGeneral (idGeneralProject, idGeneralTask) VALUES ('" + this.getIdGeneralProject() + "','" + String.valueOf(linkedGeneralTasks[i]) + "');";
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
		String queryGeneralProject = "Select idGeneralProject, name, description, idProjectCategory from GeneralProject where idGeneralProject = '" + this.getIdGeneralProject() +"';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryGeneralProject);
		while (rs.next()) {
	    	for (int i= 0; i<4; i++){
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
	public ArrayList<ArrayList<String>> loadAllTaskLinked() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryTaskLinked = "Select generalTask.idGeneralTask , generalTask.name, description, theoreticalLength, idTaskCategory From GeneralTask, isBelongGeneral where isBelongGeneral.idGeneralProject = '" + this.getIdGeneralProject() + "' and isBelongGeneral.idGeneralTask = GeneralTask.idGeneralTask;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryTaskLinked);
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
		String queryGeneralTask = "UPDATE GeneralProject Set name = '" + this.getName() + "', description = '" + this.getDescription() + "', idProjectCategory = '" + this.getIdProjectCategory() + "' WHERE idGeneralProject = '" + this.getIdGeneralProject() + "');";
		try {
		JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

	@Override
	public void deleteProject() throws SQLException {
		try {
			String queryDelete1 = "Delete from GeneralProject where idGeneralProject = '" + this.getIdGeneralProject() + "';";
			String queryDelete2 = "Delete from isBelongGeneral where idGeneralProject = '" + this.getIdGeneralProject() + "';";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete1);
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete2);
		} catch (SQLException e) {
			throw new SQLException("Erreur, deleteProject");
		}
	}

}
