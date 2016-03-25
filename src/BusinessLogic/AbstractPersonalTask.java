package BusinessLogic;

import java.sql.Date;

public abstract class AbstractPersonalTask {
	private String name;
	private String description;
	private Date beginDate;
	private Date endDate;
	private int theoreticalLength;
	private int idEntry; //PrimarKey //ForeignKey
	private int idPersonalProject; //ForeignKey
	private int idTaskCategory; //ForeignKey
	
	public AbstractPersonalTask(String name, String description, Date beginDate, Date endDate, int theoreticalLength,
			int idEntry, int idPersonalProject, int idTaskCategory) {
		super();
		this.name = name;
		this.description = description;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.theoreticalLength = theoreticalLength;
		this.idEntry = idEntry;
		this.idPersonalProject = idPersonalProject;
		this.idTaskCategory = idTaskCategory;
	}

	public AbstractPersonalTask() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTheoreticalLength() {
		return theoreticalLength;
	}

	public void setTheoreticalLength(int theoreticalLength) {
		this.theoreticalLength = theoreticalLength;
	}

	public int getIdEntry() {
		return idEntry;
	}

	public void setIdEntry(int idEntry) {
		this.idEntry = idEntry;
	}

	public int getIdPersonalProject() {
		return idPersonalProject;
	}

	public void setIdPersonalProject(int idPersonalProject) {
		this.idPersonalProject = idPersonalProject;
	}

	public int getIdTaskCategory() {
		return idTaskCategory;
	}

	public void setIdTaskCategory(int idTaskCategory) {
		this.idTaskCategory = idTaskCategory;
	}
	
	
}
