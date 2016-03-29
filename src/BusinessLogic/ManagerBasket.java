package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCFactory;

public class ManagerBasket {
	
	private AbstractFactory myFactory;
	private ArrayList<ArrayList<String>> myBasketContent;
	private AbstractBasket myBasket;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray = new ArrayList<AbstractRole>();
	

	public ManagerBasket() {
		super();
		this.myFactory = new JDBCFactory();
	}

	public ArrayList<ArrayList<String>> loadBasket() {
		ArrayList<ArrayList<String>> resBasket = new ArrayList<ArrayList<String>>();
		AbstractBasket myBasket = this.myFactory.createBasket();
		try {	
		myBasket.loadDB(this.getUserIdRole());
		resBasket = myBasket.loadContentDB();
		} catch (SQLException e) {
			e.printStackTrace();
			resBasket.add(0, null);
		}
		this.myBasketContent = resBasket;
		return resBasket;
	}

	public boolean deleteItemFromBasket(int idItem) {
		try {
			myBasket.deleteItemFromBasket(idItem);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean modifyQuantityForItem(int idItem, float newQuantity) {
		try {
			AbstractItem item = this.myFactory.createItem(idItem, -1, newQuantity, -1);
			item.UpdateQuantityItem();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Peut etre pas utile je la fait pas pour l'instant
	public boolean saveBasketQuantities() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passCommand(String cbInfos) {
		// Cree la commande
		// sauver la commande relié à lutilisateur
		// get la liste des item pour le basket
		// les inserer entre la dans itemCommand
		// La liste des sellers concerné par le panier
		// Les relier à la commande
		// Supprimer les liens entre basket et Item
		System.out.println(cbInfos);
		AbstractCommand myCommand = this.myFactory.createCommand();
		try {
		int commandId = myCommand.saveInsertDB(this.getUserIdRole());
		myCommand.setIdCommand(commandId);
		ArrayList<String> listItemBasket = this.myBasket.getListItem();
		myCommand.insertLinkedItems(listItemBasket);
		ArrayList<String> listSellerBasket = this.myBasket.getListSeller();
		myCommand.insertLinkedSellers(listSellerBasket);
		myBasket.deleteAllLinkedItem();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public int getUserIdRole() {
		for (int i = 0; i<this.myAbstractRoleArray.size() ; i++) {
			if ((this.myAbstractRoleArray.get(i).getWording()) == "users") {
					return this.myAbstractRoleArray.get(i).getIdRole();
			}
		}
		return -1;
	}

}
