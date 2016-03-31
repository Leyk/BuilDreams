package BusinessLogic;

import java.util.ArrayList;

//MOCK UP 9 sert aussi pour les mock up utilisant des cat�gories
public class FacadeCategory {
	
	private ManagerCategory myManagerCategory;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerCategory.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerCategory.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerCategory.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerCategory.setMyAbstractRoleArray(myAbstractRoleArray);
	}
	public FacadeCategory() {
		this.myManagerCategory = new ManagerCategory();
	}
	
		
	//PRODUCT CATEGORY MANAGE
	
	// Ca charge toutes les categories de produit leur id et leur nom
	public ArrayList<ArrayList<String>> loadAllProductCategory(){
		return this.myManagerCategory.loadAllProductCategory();
	}

	// Ca ajoute une categorie de produit � la base
	public boolean addProductCategory(String name){
		return this.myManagerCategory.addProductCategory(name);
	}
	
	// Ca modifie une categorie de produit de la base
	public boolean updateProductCategory(int idCategory, String newName){
		return this.myManagerCategory.updateProductCategory(idCategory, newName);
	}
	
	// Ca supprime une categorie de produit de la base
	public boolean deleteProductCategory(int idCategory){
		return this.myManagerCategory.deleteProductCategory(idCategory);
	}
	
	//PROJECT CATEGORY MANAGE
	
	// Ca charge toutes les categories de projet leur id et leur nom
	public ArrayList<ArrayList<String>> loadAllProjectCategory(){
		return this.myManagerCategory.loadAllProjectCategory();
	}

	// Ca ajoute une categorie de projet � la base
	public boolean addProjectCategory(String name){
		return this.myManagerCategory.addProjectCategory(name);
	}
	
	// Ca modifie une categorie de projet de la base
	public boolean updateProjectCategory(int idProjectCategory, String newName){
		return this.myManagerCategory.updateProjectCategory(idProjectCategory, newName);
	}
	
	// Ca supprime une categorie de projet de la base
	public boolean deleteProjectCategory(int idProjectCategory){
		return this.myManagerCategory.deleteProjectCategory(idProjectCategory);
	}
	
	//TASK CATEGORY MANAGE
	
	// Ca charge toutes les categories de tache leur id et leur nom
	public ArrayList<ArrayList<String>> loadAllTaskCategory(){
		return this.myManagerCategory.loadAllTaskCategory();
	}

	// Ca ajoute une categorie de tache � la base
	public boolean addTaskCategory(String name){
		return this.myManagerCategory.addTaskCategory(name);
	}
	
	// Ca modifie une categorie de tache de la base
	public boolean updateTaskCategory(int idTaskCategory, String newName){
		return this.myManagerCategory.updateTaskCategory(idTaskCategory, newName);
	}
	
	// Ca supprime une categorie de tache de la base
	public boolean deleteTaskCategory(int idTaskCategory){
		return this.myManagerCategory.deleteTaskCategory(idTaskCategory);
	}
	
}
