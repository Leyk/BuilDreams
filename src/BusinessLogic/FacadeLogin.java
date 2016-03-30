package BusinessLogic;

import java.util.ArrayList;

//MOCK UP 8
public class FacadeLogin {
	private ManagerLogin myManagerLogin;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerLogin.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerLogin.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerLogin.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerLogin.setMyAbstractRoleArray(myAbstractRoleArray);
	}

	public FacadeLogin() {
		this.myManagerLogin = new ManagerLogin();
	}
	
	// Renvoie le profile person demand� si il existe
	public boolean login(String nicknameIn, String passwordIn){
		return this.myManagerLogin.login(nicknameIn, passwordIn);
	}
	
	/* D�l�gue uniquement l'appel de la m�thode login, de cette mani�re le user ne voit pas la complexit� */
}
