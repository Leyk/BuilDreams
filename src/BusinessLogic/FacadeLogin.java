package BusinessLogic;
//MOCK UP 8
public class FacadeLogin {
	private ManagerLogin myGV;

	public FacadeLogin() {
		this.myGV = new ManagerLogin();
	}
	
	// Renvoie le profile person demand� si il existe
	public String[] login(String nicknameIn, String passwordIn){
		return this.myGV.login(nicknameIn, passwordIn);
	}
	
	/* D�l�gue uniquement l'appel de la m�thode login, de cette mani�re le user ne voit pas la complexit� */
}
