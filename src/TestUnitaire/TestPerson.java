package TestUnitaire;
import org.junit.Assert;
import org.junit.Test;
import BusinessLogic.*;

public class TestPerson {
	@Test
	public void TestValidAllMembers()  {
		// Permet de charger tous les personnes presentes dans la bd
		ManagerPersonManager m = new ManagerPersonManager();
	Assert.assertNotNull("Le chargement a marche",m.loadAllMembers());
	}
	
	

	
	
	

}
