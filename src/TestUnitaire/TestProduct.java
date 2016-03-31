package TestUnitaire;

import org.junit.Assert;
import org.junit.Test;

import BusinessLogic.ManagerCategory;

public class TestProduct {
	@Test
	public void TestValidAddGeneralManager()  {
		ManagerCategory m = new ManagerCategory();
		Assert.assertNotNull("Le chargement a marche",m.loadAllTaskCategory());
		
		}
	

}
