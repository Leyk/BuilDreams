package BusinessLogic;
//MOCK UP 4
public class FacadeShopOrder {
	
	private ManagerShopOrder myManagerShopOrder;

	public FacadeShopOrder() {
		this.myManagerShopOrder = new ManagerShopOrder();
	}
	
	// Charger les commandes avec leur etat
	public String[][] loadAllCommand(){
		return this.myManagerShopOrder.loadAllCommand();
	}
	
	//Charge une commande en particulier
	public String[][] loadCommand(int idCommand){
		return this.myManagerShopOrder.loadCommand(idCommand);
	}
	
	// Change l'etat d'une commande � valid�e(1) ou envoy�e(2)
	public boolean changeState(int idCommand, int state){
		return this.myManagerShopOrder.changeState(idCommand, state);
	}
}
