package BusinessLogic;

import Persistance.*;

public abstract class AbstractFactory {

	abstract public JDBCPerson createPersonJDBC (String nicknameIn, String passwordIn);
	
	/* Classe abstraite de la factory, qui joue "presque" le role d'interface */
}
