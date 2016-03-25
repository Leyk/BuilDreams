package BusinessLogic;

public abstract class AbstractProductCategory {
	private int idCategory; //PrimarKey
	private String name;
	private int idSuperCategory; //ForeignKey
	
	public AbstractProductCategory(int idCategory, String name, int idSuperCategory) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.idSuperCategory = idSuperCategory;
	}

	public AbstractProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdSuperCategory() {
		return idSuperCategory;
	}

	public void setIdSuperCategory(int idSuperCategory) {
		this.idSuperCategory = idSuperCategory;
	}
	
	
}
