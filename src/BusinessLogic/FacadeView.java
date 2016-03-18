package BusinessLogic;

public class FacadeView {
	private ManagerPerson myGV;

	public FacadeView (String nicknameIn, String passwordIn) {
		this.myGV = new ManagerPerson(nicknameIn, passwordIn);
	}
	
	public String[] loginJDBC(){
		return this.myGV.loginJDBC();
	}
	
	/* D�l�gue uniquement l'appel de la m�thode login, de cette mani�re le user ne voit pas la complexit� */
}
