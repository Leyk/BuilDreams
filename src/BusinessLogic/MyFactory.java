package BusinessLogic;

import java.sql.SQLException;

import Persistance.JDBCPerson;

public class MyFactory extends AbstractFactory{
	
	public MyFactory (){
		
	}
	
	/* Renvoie un objet user cr�� � partir des informations, nickname et password pass� en param�tre */
	public JDBCPerson createPersonJDBC (String nicknameIn, String passwordIn) {
		// futur : phase de test pour voir si le nickname ou le password est pertinant
		return new JDBCPerson(nicknameIn, passwordIn);
	}
}
