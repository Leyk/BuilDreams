package BusinessLogic;

public abstract class AbstractRole {
	
	private String wording;
	private int idRole; //PrimaryKey

	public AbstractRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractRole(String wording, int idRole) {
		super();
		this.wording = wording;
		this.idRole = idRole;
	}
	
	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public abstract String[] returnYourAttributes();
	
	public boolean hasExistence() {
		return ((this.getWording()!=null) && (this.getIdRole()!=0));
	}
	
}
