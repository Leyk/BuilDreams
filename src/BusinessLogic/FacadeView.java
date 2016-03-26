package BusinessLogic;

public class FacadeView {
	private ManagerPerson myGV;

	public FacadeView () {
		this.myGV = new ManagerPerson();
	}
	
	public String[] loginJDBC(String nicknameIn, String passwordIn){
		return this.myGV.loginJDBC(nicknameIn, passwordIn);
	}
	
	/* Délègue uniquement l'appel de la méthode login, de cette manière le user ne voit pas la complexité */
}
