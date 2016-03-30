package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractGeneralTask {
	private int idGeneralTask; //PrimarKey
	private String name;
	private String description;
	private int theoreticalLength;
	private int idTaskCategory; //ForeignKey
	
	public AbstractGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength,
			int idTaskCategory) {
		super();
		this.idGeneralTask = idGeneralTask;
		this.name = name;
		this.description = description;
		this.theoreticalLength = theoreticalLength;
		this.idTaskCategory = idTaskCategory;
	}

	public AbstractGeneralTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdGeneralTask() {
		return idGeneralTask;
	}

	public void setIdGeneralTask(int idGeneralTask) {
		this.idGeneralTask = idGeneralTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTheoreticalLength() {
		return theoreticalLength;
	}

	public void setTheoreticalLength(int theoreticalLength) {
		this.theoreticalLength = theoreticalLength;
	}

	public int getIdTaskCategory() {
		return idTaskCategory;
	}

	public void setIdTaskCategory(int idTaskCategory) {
		this.idTaskCategory = idTaskCategory;
	}

	public abstract ArrayList<ArrayList<String>> loadAllDB() throws SQLException;
	
	
	
}
