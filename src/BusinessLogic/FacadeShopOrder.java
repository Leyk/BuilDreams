package BusinessLogic;
//MOCK UP 4
public class FacadeShopOrder {
	
	private ManagerShopOrder myGV;

	public FacadeShopOrder() {
		this.myGV = new ManagerShopOrder();
	}
	
	// Charger les commandes avec leur etat
	public String[][] loadAllCommand(){
		return this.myGV.loadAllCommand();
	}
	
	//Charge une commande en particulier
	public String[][] loadCommand(int idCommand){
		return this.myGV.loadCommand(idCommand);
	}
	
	// Change l'etat d'une commande à validée(1) ou envoyée(2)
	public boolean changeState(int idCommand, int state){
		return this.myGV.changeState(idCommand, state);
	}
}
