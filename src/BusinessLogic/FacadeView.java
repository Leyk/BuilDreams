package BusinessLogic;

public class FacadeView {
	private ManagerPerson myGV;

	public FacadeView () {
		this.myGV = new ManagerPerson();
	}
	
	public String[] loginJDBC(String nicknameIn, String passwordIn){
		return this.myGV.loginJDBC(nicknameIn, passwordIn);
	}
	
	/* D�l�gue uniquement l'appel de la m�thode login, de cette mani�re le user ne voit pas la complexit� */
}
