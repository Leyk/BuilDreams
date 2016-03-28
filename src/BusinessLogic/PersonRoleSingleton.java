package BusinessLogic;

import Persistance.JDBCSingleton;
import Persistance.Parametres;

public class PersonRoleSingleton {
	
	private static PersonRoleSingleton INSTANCE = null;
	private AbstractPerson person = null;
	private AbstractAdmin admin = null;
	private AbstractUsers users = null;
	private AbstractSeller seller = null;
	
	
	/** Constructeur privé */
	private PersonRoleSingleton(AbstractPerson person, AbstractAdmin admin, AbstractUsers users, AbstractSeller seller) {
		this.person = person;
		this.admin = admin;
		this.users = users;
		this.seller = seller;
	}
	
	
	/** Point d'accès pour l'instance unique du singleton */
	public static PersonRoleSingleton getInstance(){
		return INSTANCE;
	}
	
	/** Sécurité anti-désérialisation */
	private Object readResolve() {
		return INSTANCE;
	}
	
	public static PersonRoleSingleton initInstance(AbstractPerson person, AbstractAdmin admin, AbstractUsers users, AbstractSeller seller){
		if (INSTANCE == null) {
			INSTANCE = new PersonRoleSingleton(person, admin, users, seller);
		}
		System.out.println(INSTANCE.person.getPseudo()+";"+
		INSTANCE.admin.getIdRole()+";"+
		INSTANCE.users.getIdRole()+";"+
		INSTANCE.seller.getIdRole());
		return INSTANCE;
	}
	
	public static void eraseInstance(){
		INSTANCE = null;
	}

	
	
}
