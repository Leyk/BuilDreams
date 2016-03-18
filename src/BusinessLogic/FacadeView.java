package BusinessLogic;

public class FacadeView {
	private ManagerPerson myGV;

	public FacadeView (String nicknameIn, String passwordIn) {
		this.myGV = new ManagerPerson(nicknameIn, passwordIn);
	}
	
	public String[] loginJDBC(){
		return this.myGV.loginJDBC();
	}
	
	/* Délègue uniquement l'appel de la méthode login, de cette manière le user ne voit pas la complexité */
}
