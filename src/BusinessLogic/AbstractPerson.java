package BusinessLogic;

import java.sql.SQLException;

public abstract class AbstractPerson {
	private String pseudo; //PrimarKey
	private String name;
	private String surname;
	private String email;
	private String password;
	private String phoneNumber;
	
	
	public AbstractPerson(String pseudo, String name, String surname, String email, String password, String phoneNumber) {
		super();
		this.pseudo = pseudo;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		
	}

	public AbstractPerson(String pseudo, String password) {
		this.pseudo = pseudo;
		this.name = "";
		this.surname = "";
		this.email = "";
		this.password = password;
		this.phoneNumber = "";
	}

	public AbstractPerson() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public abstract AbstractPerson loadDB() throws SQLException;

	public abstract String saveInsertDB() throws SQLException;

	
	/* Classe abstraite contenant tous les attributs communs � tous les users. Permettra ensuite de jouer avec le pattern role etc ... */
}
