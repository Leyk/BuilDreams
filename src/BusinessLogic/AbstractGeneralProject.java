package BusinessLogic;

public abstract class AbstractGeneralProject {
	private int idGeneralProject; //PrimarKey
	private String name;
	private String description;
	private int idProjectCategory; //ForeignKey
	
	public AbstractGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory) {
		super();
		this.idGeneralProject = idGeneralProject;
		this.name = name;
		this.description = description;
		this.idProjectCategory = idProjectCategory;
	}

	public AbstractGeneralProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdGeneralProject() {
		return idGeneralProject;
	}

	public void setIdGeneralProject(int idGeneralProject) {
		this.idGeneralProject = idGeneralProject;
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

	public int getIdProjectCategory() {
		return idProjectCategory;
	}

	public void setIdProjectCategory(int idProjectCategory) {
		this.idProjectCategory = idProjectCategory;
	}
	
	
}
