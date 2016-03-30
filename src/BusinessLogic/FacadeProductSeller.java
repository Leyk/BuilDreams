package BusinessLogic;

import java.util.ArrayList;

//MOCK UP 10 /// PAS DE SUBCATEGORY
public class FacadeProductSeller {

	private ManagerProductSeller myManagerProductSeller;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerProductSeller.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerProductSeller.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerProductSeller.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerProductSeller.setMyAbstractRoleArray(myAbstractRoleArray);
	}

	public FacadeProductSeller() {
		this.myManagerProductSeller = new ManagerProductSeller();
	}
	
	// Charge tous les produit de ce seller
	public ArrayList<ArrayList<String>> loadAllProductSeller(){
		return this.myManagerProductSeller.loadAllProductSeller();
	}

	// Ca ajoute un produit de ce seller � la base 
	public boolean addProductSeller(String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myManagerProductSeller.addProductSeller(name, description, quantity, reference, price , idCategory);
	}
	
	// Ca modifie un produit de ce seller � la base
	public boolean updateProductSeller(int idProduct, String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myManagerProductSeller.updateProductSeller(idProduct, name, description, quantity, reference, price , idCategory);
	}
	
	// Ca supprime un produit de ce seller de la base
	public boolean deleteProductSeller(int idProduct){
		return this.myManagerProductSeller.deleteProductSeller(idProduct);
	}
	// ici faire gaffe
}
