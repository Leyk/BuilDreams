package BusinessLogic;

import java.util.ArrayList;

public class FacadeProduct {
	
	private ManagerProduct myManagerProduct;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerProduct.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerProduct.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerProduct.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerProduct.setMyAbstractRoleArray(myAbstractRoleArray);
	}

	public FacadeProduct() {
		this.myManagerProduct = new ManagerProduct();
	}
	
	// Charge tous les produit de ce seller
	public ArrayList<ArrayList<String>> loadAllProduct(){
		return this.myManagerProduct.loadAllProduct();
	}
	
	// Ca modifie un produit de ce seller � la base
	public boolean updateProduct(int idProduct, String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myManagerProduct.updateProduct(idProduct, name, description, quantity, reference, price , idCategory);
	}
	
	// Ca supprime un produit de ce seller de la base
	public boolean deleteProduct(int idProduct){
		return this.myManagerProduct.deleteProduct(idProduct);
	}
	// ici faire gaffe
}


