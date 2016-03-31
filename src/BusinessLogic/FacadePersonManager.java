package BusinessLogic;

import java.util.ArrayList;

//MOCK UP 5
public class FacadePersonManager {
	
	private ManagerRegistration myManagerRegistration;
	private ManagerPersonManager myManagerPersonManager;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerRegistration.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerRegistration.setMyPerson(myPerson);
		this.myManagerPersonManager.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerRegistration.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerRegistration.setMyAbstractRoleArray(myAbstractRoleArray);
		this.myManagerPersonManager.setMyAbstractRoleArray(myAbstractRoleArray);
	}
	
	public FacadePersonManager() {
		this.myManagerRegistration = new ManagerRegistration();
		this.myManagerPersonManager = new ManagerPersonManager();
	}
	// pas oublier non plus pour la verification que le gars ne s'inscrive pas avec un pseudo null
	
	// Enregistre le nouveau seller dans la base (person, role, seller)
	public String addSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myManagerRegistration.registrationSeller(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
	
	// Enregistre le nouvel users dans la base (person, role, users, basket)
	public String addUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myManagerRegistration.registrationUsers(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	// Update les nouvelles informations du seller dans la base (person, seller)
	public boolean updateSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myManagerPersonManager.updateSeller(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
	
	// Update les nouvelles informations du users dans la base (person)
	public boolean updateUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myManagerPersonManager.updateUsers(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	// Supprime un Users ou un Vendeur, c'est la meme chose preciser le nickname/pseudo
	public boolean deletePerson(String textFieldPseudoIn) {
		return this.myManagerPersonManager.deletePerson(textFieldPseudoIn);
	}
	
	public ArrayList<ArrayList<String>> loadAllMembers(){
		return this.myManagerPersonManager.loadAllMembers();
	}
	
	
	
}
