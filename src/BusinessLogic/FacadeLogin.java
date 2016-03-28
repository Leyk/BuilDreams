package BusinessLogic;
//MOCK UP 8
public class FacadeLogin {
	private ManagerLogin myManagerLogin;

	public FacadeLogin() {
		this.myManagerLogin = new ManagerLogin();
	}
	
	// Renvoie le profile person demand� si il existe
	public String[] login(String nicknameIn, String passwordIn){
		return this.myManagerLogin.login(nicknameIn, passwordIn);
	}
	
	/* D�l�gue uniquement l'appel de la m�thode login, de cette mani�re le user ne voit pas la complexit� */
}
