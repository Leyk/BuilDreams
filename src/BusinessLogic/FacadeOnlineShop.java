package BusinessLogic;
// MOCK UP 13
public class FacadeOnlineShop {
	
	private ManagerOnlienShop myGV;

	public FacadeOnlineShop() {
		this.myGV = new ManagerOnlineShop();
	}
	
	// Charge les données du shop
	public String[][] loadShop(){
		return this.myGV.loadShop();
	}
	
	// Charge les données du shop pour un seller
	public String[][] loadShop(int idSeller){
		return this.myGV.loadShop(idSeller);
	}
	
	// Charge les données du shop pour une category
	public String[][] loadShop(int idCategory){
		return this.myGV.loadShop(idCategory);
	}
	
	// Charge les données du shop pour un seller et une category
	public String[][] loadShop(int idSeller, int idCategory){
		return this.myGV.loadShop(idSeller, idCategory);
	}

	// ajout d'un item au panier
	public boolean addItemToBasket(int idProduct, float quantity, float price){
		return this.myGV.addItemToBasket(idProduct, quantity, price);
	}
	
}
