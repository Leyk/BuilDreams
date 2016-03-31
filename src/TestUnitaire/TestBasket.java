package TestUnitaire;
import org.junit.Assert;
import org.junit.Test;
import BusinessLogic.*;

public class TestBasket {
/*	@Test
	public void TestValidDeleteItemFromBasket()  {
		
		ManagerBasket m = new ManagerBasket();
		int idItems = 2;
		boolean res = m.deleteItemFromBasket(idItems);
		Assert.assertTrue( res);
		
}*/
/*	@Test
	public void TestInvalidDeleteItemFromBasket()  {
		
		ManagerBasket m = new ManagerBasket();
		int idItems = 20;
		boolean res = m.deleteItemFromBasket(idItems);
		Assert.assertFalse( res);
		
}
	*/
@Test
	public void ValidmodifyQuantityForItem(){
		ManagerBasket m = new ManagerBasket();
		int idItems = 3;
		float qte= 170;
		boolean res = m.modifyQuantityForItem(idItems,qte);
		Assert.assertTrue( res);
}

}






