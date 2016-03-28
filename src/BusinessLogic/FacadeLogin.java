package BusinessLogic;
//MOCK UP 8
public class FacadeLogin {
	private ManagerLogin myManagerLogin;

	public FacadeLogin() {
		this.myManagerLogin = new ManagerLogin();
	}
	
	// Renvoie le profile person demandé si il existe
	public String[] login(String nicknameIn, String passwordIn){
		return this.myManagerLogin.login(nicknameIn, passwordIn);
	}
	
	/* Délègue uniquement l'appel de la méthode login, de cette manière le user ne voit pas la complexité */
}
