package BusinessLogic;
//MOCK UP 1
public class FacadeBasket {

	private ManagerBasket myGV;

	public FacadeBasket() {
		this.myGV = new ManagerBasket();
	}
	
	// Charge les donn�es du panier
	public String[][] loadBasket(){
		return this.myGV.loadBasket();
	}

	//il faut que tu supprime graphiquement l'item
	// supprime un item donn�e du panier
	public boolean deleteItemFromBasket(int idItem){
		return this.myGV.deleteItemFromBasket(idItem);
	}
	
	// Modifie la quantit� d'un item dans l'app (a chaque changement d'etat d'un quantit� !)
	public boolean modifyQuantityForItem(int idItem, float newQuantity){
		return this.myGV.modifyQuantityForItem(idItem, newQuantity);
	}
	
	// Sauve les quantit�es d'item chang�e du basket (a la fermeture du panier)
	public boolean saveBasketQuantities(){
		
	}
	
	// Ce qui passe la commande (cree la commande dans la base)
	public boolean passCommand(String cbInfos) {
		return this.myGV.passCommand(cbInfos);
	}
}
