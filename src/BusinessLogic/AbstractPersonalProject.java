package BusinessLogic;
import java.sql.Date;
import java.sql.SQLException;

public abstract class AbstractPersonalProject {
	private int idPersonalProject; //PrimarKey
	private String name;
	private String description;
	private Date beginDate;
	private Date endDate;
	private int idRole; //ForeignKey
	private int idProjectCategory; //ForeignKey
	
	public AbstractPersonalProject(int idPersonalProject, String name, String description, Date beginDate, Date endDate,
			int idRole, int idProjectCategory) {
		super();
		this.idPersonalProject = idPersonalProject;
		this.name = name;
		this.description = description;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.idRole = idRole;
		this.idProjectCategory = idProjectCategory;
	}

	public AbstractPersonalProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPersonalProject() {
		return idPersonalProject;
	}

	public void setIdPersonalProject(int idPersonalProject) {
		this.idPersonalProject = idPersonalProject;
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

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getIdProjectCategory() {
		return idProjectCategory;
	}

	public void setIdProjectCategory(int idProjectCategory) {
		this.idProjectCategory = idProjectCategory;
	}

	public abstract int saveInsertFromGeneralProjectDB(int idGeneralProject, Date beginDate, Date endDate) throws SQLException;
	
	
}
