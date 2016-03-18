package BusinessLogic;

public class AbstractPerson {
	private String pseudo;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	public AbstractPerson(String pseudoIn, String passwordIn) {
		this.pseudo = pseudoIn;
		this.password = passwordIn;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phoneNumber = "";
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/* Classe abstraite contenant tous les attributs communs à tous les users. Permettra ensuite de jouer avec le pattern role etc ... */
}
