package BusinessLogic;
//MOCK UP 10 /// PAS DE SUBCATEGORY
public class FacadeProductSeller {

	private ManagerProductSeller myGV;

	public FacadeProductSeller() {
		this.myGV = new ManagerProductSeller();
	}
	
	// Charge tous les produit de ce seller
	public String[][] loadAllProductSeller(){
		return this.myGV.loadAllProductSeller();
	}

	// Ca ajoute un produit de ce seller à la base 
	public boolean addProductSeller(String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myGV.addProductSeller(name, description, quantity, reference, price , idCategory);
	}
	
	// Ca modifie un produit de ce seller à la base
	public boolean updateProductSeller(int idProduct, String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myGV.updateProductSeller(idProduct, name, description, quantity, reference, price , idCategory);
	}
	
	// Ca supprime un produit de ce seller de la base
	public boolean deleteProductSeller(int idProduct){
		return this.myGV.deleteProductSeller(idProduct);
	}
	// ici faire gaffe
}
