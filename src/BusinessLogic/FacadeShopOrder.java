package BusinessLogic;

import java.util.ArrayList;

//MOCK UP 4
public class FacadeShopOrder {
	
	private ManagerShopOrder myManagerShopOrder;

	public FacadeShopOrder() {
		this.myManagerShopOrder = new ManagerShopOrder();
	}
	
	// Charger les commandes avec leur etat
	public ArrayList<ArrayList<String>> loadAllCommand(){
		return this.myManagerShopOrder.loadAllCommand();
	}
	
	//Charge une commande en particulier
	public ArrayList<ArrayList<String>> loadCommand(int idCommand){
		return this.myManagerShopOrder.loadCommand(idCommand);
	}
	
	// Change l'etat d'une commande à validée(1) ou envoyée(2)
	public boolean changeState(int idCommand, int state){
		return this.myManagerShopOrder.changeState(idCommand, state);
	}
}
