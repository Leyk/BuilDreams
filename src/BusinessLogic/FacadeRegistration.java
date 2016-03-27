package BusinessLogic;

public class FacadeRegistration {
	private ManagerRegistration myGV;
	
	public FacadeRegistration () {
		this.myGV = new ManagerRegistration();
	}
	// pas oublier non plus pour la verification que le gars ne s'inscrive pas avec un pseudo null
	//Pas oublier le pseudo a faire
	
	public String registrationUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myGV.registrationUsers(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	public String registrationSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myGV.registrationSeller(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
}
