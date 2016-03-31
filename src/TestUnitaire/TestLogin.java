package TestUnitaire;

import org.junit.Test;

import BusinessLogic.ManagerLogin;
import junit.framework.Assert;

public class TestLogin {
	
	@Test
	public void TestValidLog()  {
		
		ManagerLogin m = new ManagerLogin();
		
		String log = "lolo";
		String password = "password";
		boolean res;
		
		res = m.login(log,password);
		Assert.assertTrue("Il devrait etre vraie", res);

}

	@Test 
	public void TestErrorLog()  {
		
		ManagerLogin m = new ManagerLogin();
		
		String log = "lolo";
		String password = "azerty";
		boolean res;
		
		res = m.login(log,password);
		Assert.assertFalse("Il devrait etre faux", res);
	

}

	}

