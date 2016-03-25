package BusinessLogic;

public abstract class AbstractTaskCategory {
	private int idTaskCategory; //PrimarKey
	private String name;
	private int idSuperTaskCategory; //ForeignKey
	
	public AbstractTaskCategory(int idTaskCategory, String name, int idSuperTaskCategory) {
		super();
		this.idTaskCategory = idTaskCategory;
		this.name = name;
		this.idSuperTaskCategory = idSuperTaskCategory;
	}

	public AbstractTaskCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTaskCategory() {
		return idTaskCategory;
	}

	public void setIdTaskCategory(int idTaskCategory) {
		this.idTaskCategory = idTaskCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdSuperTaskCategory() {
		return idSuperTaskCategory;
	}

	public void setIdSuperTaskCategory(int idSuperTaskCategory) {
		this.idSuperTaskCategory = idSuperTaskCategory;
	}
	
	
}
