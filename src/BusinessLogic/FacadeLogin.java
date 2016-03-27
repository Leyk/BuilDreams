package BusinessLogic;

public class FacadeLogin {
	private ManagerLogin myGV;

	public FacadeLogin() {
		this.myGV = new ManagerLogin();
	}
	
	public String[] login(String nicknameIn, String passwordIn){
		return this.myGV.login(nicknameIn, passwordIn);
	}
	
	/* D�l�gue uniquement l'appel de la m�thode login, de cette mani�re le user ne voit pas la complexit� */
}
