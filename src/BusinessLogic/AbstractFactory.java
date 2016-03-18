package BusinessLogic;

import Persistance.JDBCPerson;

public abstract class AbstractFactory {
	abstract public JDBCPerson createUserJDBC (String nicknameIn, String passwordIn);
	
	/* Classe abstraite de la factory, qui joue "presque" le role d'interface */
}
