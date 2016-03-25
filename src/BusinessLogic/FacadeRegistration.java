package BusinessLogic;

public class FacadeRegistration {
	private ManagerRegistration myGV;
	
	public FacadeRegistration () {
		this.myGV = new ManagerRegistration();
	}
	
	public String registrationUser (String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		return this.myGV.registrationUser(textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
	}
	
	public String registrationSeller (String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPhoneIn, String textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return this.myGV.registrationSeller(textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPhoneIn, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
	}
}
