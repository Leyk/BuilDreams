package BusinessLogic;

import java.io.Serializable;
import java.sql.SQLException;

import Persistance.JDBCSingleton;

public class ManagerRegistration {
	
	private AbstractFactory myFactory;

	public ManagerRegistration() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public String registrationUsers(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn) {
		//cree un Person
		//cree un Users
		//save la Person
		//save le Users
		//cree son basket
		//save le basket
		AbstractPerson myPerson = myFactory.createPerson(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
		AbstractUsers myUser = myFactory.createUsers();
		AbstractBasket myBasket = myFactory.createBasket();
		try {
		String pseudo = myPerson.saveInsertDB();
		int role = myUser.saveInsertDB(pseudo);
		myBasket.saveInsertDB(role);
		return "Ok";
		} catch (SQLException e) {
			return "Invalid registration";
		}
	}
	
	public String registrationSeller(String textFieldPseudoIn, String textFieldNameIn, String textFieldSurnameIn, String textFieldEmailIn, String textFieldPasswordIn, String textFieldPhoneIn, int textFieldSiretIn, String textFieldWebIn, String textFieldDomainActivityIn) {
		//cree un Person
		//cree un Seller
		//save la Person
		//save le Seller
		AbstractPerson myPerson = myFactory.createPerson(textFieldPseudoIn, textFieldNameIn, textFieldSurnameIn, textFieldEmailIn, textFieldPasswordIn, textFieldPhoneIn);
		AbstractSeller mySeller = myFactory.createSeller("seller", 0, textFieldSiretIn, textFieldWebIn, textFieldDomainActivityIn);
		System.out.println(mySeller.getSiret());
		try {
		String pseudo = myPerson.saveInsertDB();
		mySeller.saveInsertDB(pseudo);
		return "Ok";
		} catch (SQLException e) {
			return "Invalid registration";
		}
	}
}
