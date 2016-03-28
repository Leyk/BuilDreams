package BusinessLogic;
// MOCK UP 13
public class FacadeOnlineShop {
	
	private ManagerOnlineShop myManagerOnlineShop;

	public FacadeOnlineShop() {
		this.myManagerOnlineShop = new ManagerOnlineShop();
	}
	
	// Charge les données du shop
	public String[][] loadShop(){
		return this.myManagerOnlineShop.loadShop();
	}
	
	// Charge les données du shop pour un seller
	public String[][] loadShopSeller(int idSeller){
		return this.myManagerOnlineShop.loadShopSeller(idSeller);
	}
	
	// Charge les données du shop pour une category
	public String[][] loadShopCategory(int idCategory){
		return this.myManagerOnlineShop.loadShopCategory(idCategory);
	}
	
	// Charge les données du shop pour un seller et une category
	public String[][] loadShopSellerCategory(int idSeller, int idCategory){
		return this.myManagerOnlineShop.loadShopSellerCategory(idSeller, idCategory);
	}

	// ajout d'un item au panier
	public boolean addItemToBasket(int idProduct, float quantity, float price){
		return this.myManagerOnlineShop.addItemToBasket(idProduct, quantity, price);
	}
	
}
