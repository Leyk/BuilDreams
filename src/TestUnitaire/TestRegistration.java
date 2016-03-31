package TestUnitaire;

import org.junit.Test;

import BusinessLogic.ManagerRegistration;
import junit.framework.Assert;

public class TestRegistration {
	@Test
	public void TestValidRegistrationUser()  {
		
		ManagerRegistration m = new ManagerRegistration();
		
		String PseudoIn = "osis2";
		String NameIn = "totonar2"; 
		String SurnameIn = "totonar"; 
		String EmailIn ="toto@gmail.com";
		String PasswordIn = "toto2";
		String PhoneIn = "0606025412";
		
		
		String res= m.registrationUsers(PseudoIn,NameIn,SurnameIn,EmailIn,PasswordIn, PhoneIn);
		Assert.assertEquals("Ok", res);

}

	@Test
	public void TestInvalidValidRegistrationUser()  {
			
			ManagerRegistration m = new ManagerRegistration();
			
			String PseudoIn = "lolo"; // with a pseudo witch already exists
			String NameIn = "totonar2"; 
			String SurnameIn = "totonar"; 
			String EmailIn ="toto@gmail.com";
			String PasswordIn = "toto2";
			String PhoneIn = "0606025412";
			
			
			String res= m.registrationUsers(PseudoIn,NameIn,SurnameIn,EmailIn,PasswordIn, PhoneIn);
			Assert.assertEquals("Invalid registration", res);

	}
		
		@Test
		public void TestValidRegistrationSeller()  {
			
			ManagerRegistration m = new ManagerRegistration();
			
			String PseudoIn = "osiz3";
			String NameIn = "totonar2"; 
			String SurnameIn = "totonar"; 
			String EmailIn ="toto@gmail.com";
			String PasswordIn = "toto2";
			String PhoneIn = "0606025412";
			int SiretIn= 202054;
			String WebIn = "www.bois.com"; 
			String DomainActivityIn = "bois";
			
			
			String res= m.registrationSeller(PseudoIn,NameIn,SurnameIn,EmailIn,PasswordIn, PhoneIn,SiretIn, WebIn, DomainActivityIn);
			Assert.assertEquals("Ok", res);

	}
		@Test
		public void TestInvalidValidRegistrationSeller()  {
			
			ManagerRegistration m = new ManagerRegistration();
			
			String PseudoIn = "sim"; // with a pseudo witch already exists
			String NameIn = "totonar2"; 
			String SurnameIn = "totonar"; 
			String EmailIn ="toto@gmail.com";
			String PasswordIn = "toto2";
			String PhoneIn = "0606025412";
			int SiretIn= 202054;
			String WebIn = "www.bois.com"; 
			String DomainActivityIn = "bois";
			
			
			
			String res= m.registrationUsers(PseudoIn,NameIn,SurnameIn,EmailIn,PasswordIn, PhoneIn);
			Assert.assertEquals("Invalid registration", res);

	}


}
