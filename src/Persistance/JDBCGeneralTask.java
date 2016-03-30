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
		String queryGeneralTaskAll = "Select idGeneraltask, name From GeneralTask;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryGeneralTaskAll);
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

}
