package BusinessLogic;

public abstract class AbstractUsers {
	private String wording;
	private int idRole; //PrimarKey //ForeignKey
	
	public AbstractUsers(String wording, int idRole) {
		super();
		this.wording = wording;
		this.idRole = idRole;
	}

	public AbstractUsers() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
