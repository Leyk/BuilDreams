package BusinessLogic;
//MOCK UP 2 et 3
public class FacadeProfileModifier {
	
	private ManagerProfileModifier myManagerProfileModifier;
	
	public FacadeProfileModifier() {
		this.myManagerProfileModifier = new ManagerProfileModifier();
	}
	
	
	// Ce qui modifie le profil d'un Seller
	public boolean modifyProfileSeller(String name, String surname, String email, String password, String phoneNumber, int siret, String webSite, String domainActivity) {
		return this.myManagerProfileModifier.modifyProfileSeller(name, surname, email, password, phoneNumber, siret, webSite, domainActivity);
	}
	
	// Ce qui modifie le profils d'un Users
	public boolean modifyProfileUsers(String name, String surname, String email, String password, String phoneNumber) {
		return this.myManagerProfileModifier.modifyProfileUsers(name, surname, email, password, phoneNumber);
	}
	
}
