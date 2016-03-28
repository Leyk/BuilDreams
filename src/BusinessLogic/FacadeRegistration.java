package BusinessLogic;
// MOCK UP 7 
public class FacadeRegistration {
	private ManagerRegistration myManagerRegistration;
	
	public FacadeRegistration () {
		this.myManagerRegistration = new ManagerRegistration();
	}
	// pas oublier non plus pour la verification que le gars ne s'inscrive pas avec un pseudo null
	//Pas oublier le pseudo a faire
	
	
	// Enregistre le nouvel users dans la base (person, role, users, basket)
	public String registrationUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myManagerRegistration.registrationUsers(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	// Enregistre le nouveau seller dans la base (person, role, seller)
	public String registrationSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myManagerRegistration.registrationSeller(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
}
