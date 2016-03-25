package BusinessLogic;

public abstract class AbstractCommand {
	private int idCommand; //PrimarKey
	private int idRole; //ForeignKey
	
	public AbstractCommand(int idCommand, int idRole) {
		super();
		this.idCommand = idCommand;
		this.idRole = idRole;
	}

	public AbstractCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
}
