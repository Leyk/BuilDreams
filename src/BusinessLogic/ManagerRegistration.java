package BusinessLogic;

import java.sql.SQLException;

import Persistance.JDBCSingleton;

public class ManagerRegistration {
	
	public ManagerRegistration() {
		super();

	}

	public String registrationUser (String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		try {
			return JDBCSingleton.getInstance().registrationUser(textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
		} catch (SQLException e) {
			return "Invalid registration";
		}
	}
	
	public String registrationSeller (String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPhoneIn, String textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		return "";
	}
}
