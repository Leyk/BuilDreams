package BusinessLogic;

public class FacadeLogin {
	private ManagerLogin myGV;

	public FacadeLogin() {
		this.myGV = new ManagerLogin();
	}
	
	public String[] login(String nicknameIn, String passwordIn){
		return this.myGV.login(nicknameIn, passwordIn);
	}
	
	/* Délègue uniquement l'appel de la méthode login, de cette manière le user ne voit pas la complexité */
}
