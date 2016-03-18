package BusinessLogic;

import java.sql.SQLException;

import Persistance.JDBCPerson;

public class MyFactory extends AbstractFactory{
	
	public MyFactory (){
		
	}
	
	/* Renvoie un objet user créé à partir des informations, nickname et password passé en paramètre */
	public JDBCPerson createUserJDBC (String nicknameIn, String passwordIn) {
		// futur : phase de test pour voir si le nickname ou le password est pertinant
		return new JDBCPerson(nicknameIn, passwordIn);
	}
}
