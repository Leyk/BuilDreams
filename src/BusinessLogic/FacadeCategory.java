package BusinessLogic;
//MOCK UP 9 sert aussi pour les mock up utilisant des catégories
public class FacadeCategory {
	
	private ManagerCategory myGV;

	public FacadeCategory() {
		this.myGV = new ManagerCategory();
	}
	
	//PRODUCT CATEGORY MANAGE
	
	// Ca charge toutes les categories de produit leur id et leur nom
	public String[][] loadAllProductCategory(){
		return this.myGV.loadAllProductCategory();
	}

	// Ca ajoute une categorie de produit à la base
	public boolean addProductCategory(String name){
		return this.myGV.addProductCategory(name);
	}
	
	// Ca modifie une categorie de produit de la base
	public boolean updateProductCategory(int idCategory, String newName){
		return this.myGV.updateProductCategory(idCategory, newName);
	}
	
	// Ca supprime une categorie de produit de la base
	public boolean deleteProductCategory(int idCategory){
		return this.myGV.deleteProductCategory(idCategory);
	}
	
	//PROJECT CATEGORY MANAGE
	
	// Ca charge toutes les categories de projet leur id et leur nom
	public String[][] loadAllProjectCategory(){
		return this.myGV.loadAllProjectCategory();
	}

	// Ca ajoute une categorie de projet à la base
	public boolean addProjectCategory(String name){
		return this.myGV.addProjectCategory(name);
	}
	
	// Ca modifie une categorie de projet de la base
	public boolean updateProjectCategory(int idProjectCategory, String newName){
		return this.myGV.updateProjectCategory(idProjectCategory, newName);
	}
	
	// Ca supprime une categorie de projet de la base
	public boolean deleteProjectCategory(int idProjectCategory){
		return this.myGV.deleteProjectCategory(idProjectCategory);
	}
	
	//TASK CATEGORY MANAGE
	
	// Ca charge toutes les categories de tache leur id et leur nom
	public String[][] loadAllTaskCategory(){
		return this.myGV.loadAllTaskCategory();
	}

	// Ca ajoute une categorie de tache à la base
	public boolean addTaskCategory(String name){
		return this.myGV.addTaskCategory(name);
	}
	
	// Ca modifie une categorie de tache de la base
	public boolean updateTaskCategory(int idTaskCategory, String newName){
		return this.myGV.updateTaskCategory(idTaskCategory, newName);
	}
	
	// Ca supprime une categorie de tache de la base
	public boolean deleteTaskCategory(int idTaskCategory){
		return this.myGV.deleteTaskCategory(idTaskCategory);
	}
	
}
