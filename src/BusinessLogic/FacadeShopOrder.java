package BusinessLogic;

import java.util.ArrayList;

//MOCK UP 4
public class FacadeShopOrder {
	
	private ManagerShopOrder myManagerShopOrder;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerShopOrder.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerShopOrder.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerShopOrder.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerShopOrder.setMyAbstractRoleArray(myAbstractRoleArray);
	}

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
	
	// Change l'etat d'une commande � valid�e(1) ou envoy�e(2)
	public boolean changeState(int idCommand, int state){
		return this.myManagerShopOrder.changeState(idCommand, state);
	}
}
