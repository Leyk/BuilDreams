package TestUnitaire;
import org.junit.Assert;
import org.junit.Test;
import BusinessLogic.*;

public class TestCategoryTask {
	
	@Test
	public void TestValidAddGeneralManager()  {
		ManagerCategory m = new ManagerCategory();
		Assert.assertNotNull("Le chargement a marche",m.loadAllTaskCategory());
		
		}
	

	

}
