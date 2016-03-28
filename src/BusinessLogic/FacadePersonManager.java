package BusinessLogic;
//MOCK UP 5
public class FacadePersonManager {
	
	private ManagerRegistration myRGV;
	private ManagerPersonManager myPMGV;
	
	public FacadeRegistration () {
		this.myRGV = new ManagerRegistration();
		this.myPMGV = new ManagerPersonManager();
	}
	// pas oublier non plus pour la verification que le gars ne s'inscrive pas avec un pseudo null
	
	// Enregistre le nouveau seller dans la base (person, role, seller)
	public String addSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myRGV.registrationSeller(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
	
	// Enregistre le nouvel users dans la base (person, role, users, basket)
	public String addUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myRGV.registrationUsers(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	// Update les nouvelles informations du seller dans la base (person, seller)
	public String updateSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myPMGV.updateSeller(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
	
	// Update les nouvelles informations du users dans la base (person)
	public String updateUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myPMGV.updateUsers(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	// Supprime un Users ou un Vendeur, c'est la meme chose preciser le nickname/pseudo
	public String deletePerson(String textFieldPseudoIn) {
		return this.myRGV.deletePerson(textFieldPseudoIn);
	}
	
	
	
}
