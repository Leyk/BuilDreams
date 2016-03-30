package BusinessLogic;

import java.util.ArrayList;

// MOCK UP 13
public class FacadeOnlineShop {
	
	private ManagerOnlineShop myManagerOnlineShop;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerOnlineShop.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerOnlineShop.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerOnlineShop.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerOnlineShop.setMyAbstractRoleArray(myAbstractRoleArray);
	}

	public FacadeOnlineShop() {
		this.myManagerOnlineShop = new ManagerOnlineShop();
	}
	
	// Charge les donn�es du shop
	public ArrayList<ArrayList<String>> loadShop(){
		return this.myManagerOnlineShop.loadShop();
	}
	
	// Charge les donn�es du shop pour un seller
	public ArrayList<ArrayList<String>> loadShopSeller(int idSeller){
		return this.myManagerOnlineShop.loadShopSeller(idSeller);
	}
	
	// Charge les donn�es du shop pour une category
	public ArrayList<ArrayList<String>> loadShopCategory(int idCategory){
		return this.myManagerOnlineShop.loadShopCategory(idCategory);
	}
	
	// Charge les donn�es du shop pour un seller et une category
	public ArrayList<ArrayList<String>> loadShopSellerCategory(int idSeller, int idCategory){
		return this.myManagerOnlineShop.loadShopSellerCategory(idSeller, idCategory);
	}

	// ajout d'un item au panier
	public boolean addItemToBasket(int idProduct, float quantity, float price){
		return this.myManagerOnlineShop.addItemToBasket(idProduct, quantity, price);
	}
	
}
