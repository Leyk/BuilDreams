package TestUnitaire;
import org.junit.Assert;
import org.junit.Test;
import BusinessLogic.*;

public class TestCategory {
	@Test
	public void TestValidAddGeneralManager()  {
		ManagerGeneralManager m = new ManagerGeneralManager();
		String name = "Montages";
		String description = " Montagess ";
		int idProjectCategory =3;
		String [] linkedGeneralTasks = {"1"};
		boolean res = m.addGeneralProject(name, description, idProjectCategory, linkedGeneralTasks);
		 
		Assert.assertFalse( res);
		
		
	}
	
	@Test
	public void TestValidGeneralManager()  {
		ManagerGeneralManager m = new ManagerGeneralManager();
		String name = "Montages";
		String description = " Montagess ";
		int idProjectCategory =3;
		String [] linkedGeneralTasks = {"1"};
		boolean res = m.addGeneralProject(name, description, idProjectCategory, linkedGeneralTasks);
		 
		Assert.assertFalse( res);

	}

	@Test
	public void TestValidLoadAllGeneralProject()  {
		// Permet de charger tous les generalProject presentes dans la bd
		ManagerGeneralManager m = new ManagerGeneralManager();
	Assert.assertNotNull("Le chargement a marche",m.loadAllGeneralProject());
	}
	
	

}
