package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractProjectCategory {
	private int idProjectCategory; //PrimarKey
	private String name;
	private int idSuperProjectCategory; //ForeignKey
	
	public AbstractProjectCategory(int idProjectCategory, String name, int idSuperProjectCategory) {
		super();
		this.idProjectCategory = idProjectCategory;
		this.name = name;
		this.idSuperProjectCategory = idSuperProjectCategory;
	}
	public AbstractProjectCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdProjectCategory() {
		return idProjectCategory;
	}
	public void setIdProjectCategory(int idProjectCategory) {
		this.idProjectCategory = idProjectCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdSuperProjectCategory() {
		return idSuperProjectCategory;
	}
	public void setIdSuperProjectCategory(int idSuperProjectCategory) {
		this.idSuperProjectCategory = idSuperProjectCategory;
	}
	public abstract ArrayList<ArrayList<String>> loadAllDB() throws SQLException;
	
	public abstract int saveInsertDB() throws SQLException;
	
	public abstract void saveUpdateDB() throws SQLException;
	
	public abstract void deleteDB() throws SQLException;
	
	
	
}
