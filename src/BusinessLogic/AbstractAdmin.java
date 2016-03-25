package BusinessLogic;

public abstract class AbstractAdmin {
	private String wording;
	private int idRole; //PrimarKey //ForeignKey
	
	public AbstractAdmin(String wording, int idRole) {
		super();
		this.wording = wording;
		this.idRole = idRole;
	}

	public AbstractAdmin() {
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
