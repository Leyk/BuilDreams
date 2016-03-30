package BusinessLogic;

import java.util.ArrayList;

// MOCK UP 11 
public class FacadeGeneralManager {
	
	private ManagerGeneralManager myManagerGeneralManager;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerGeneralManager.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerGeneralManager.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerGeneralManager.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerGeneralManager.setMyAbstractRoleArray(myAbstractRoleArray);
	}

	public FacadeGeneralManager() {
		this.myManagerGeneralManager = new ManagerGeneralManager();
	}
	
	// A SIMOM : Lors du select penses bien � recuper la liste de [idCategoryTache] pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create General Project 
	// Charger les category de project : facade category
	// Charger les taches generales
	// Enregistrer un projet (qui poura appeler apres Enregistrer les taches reli�s a un project general)
	// (Enregistrer les tache relier a un project general)
	
	// Update General Project
	// Charger la liste des project generaux
	// Charger les category de project : facade category
	// Charger un projet general
	// Charger les taches generales
	// Charger la liste des taches reli� � un projet general
	// Enregistrer un projet (qui poura appeler apres Enregistrer les taches reli�s a un project general)
	// (Enregistrer les tache relier a un project general)
	
	// Delete General Project
	// Charger la liste des project generaux
	// Charger un projet general
	// Supprimer le projet general et ses liens
	
	// A SIMOM : Lors du select penses bien � recuper la liste de [idCategoryProduit, quantity, unit] (ici tableau 3 fois n) pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create General Task 
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	// Enregistrer une tache (qui poura appeler apres Enregistrer les produits reli�s a une tache generale)
	// (Enregistrer les produit relier a une tache generale) ==> (quantity unit idcategory)
	
	// Update General Task
	// Charger la liste des taches generale
	// Charger les category de Tache : facade category
	// Charger une tache generale
	// Charger les category de produit
	// Charger la liste des category de produits reli� a cette tache generale
	// Enregistrer une tache generale (qui poura appeler apres Enregistrer les produits reli�s a une tache generale)
	// (Enregistrer les produits reli�s a une tache generale)
	
	// Delete General Task
	// Charger la liste des taches generales
	// Charger une tache generale
	// Supprimer la tache generale et ses liens
	
	
	/////////////////////////////////
	
	// Charger les category de project : facade category
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	
	// Charger les taches generales
	public ArrayList<ArrayList<String>> loadAllGeneralTask(){
		return this.myManagerGeneralManager.loadAllGeneralTask();
	}
	
	// ADD Enregistrer un projet (qui poura appeler apres Enregistrer les taches reli�s a un project general) le string est la liste des id
	public boolean addGeneralProject(String name, String description, int idProjectCategory, String[] linkedGeneralTasks){
		return this.myManagerGeneralManager.addGeneralProject(name, description, idProjectCategory, linkedGeneralTasks);
	}
	
	// (Enregistrer les tache relier a un project general) le string est la liste des id
	public boolean saveLinkedGeneralTask(int idGeneralProject, String[] linkedGeneralTasks){
		return this.myManagerGeneralManager.saveLinkedGeneralTask(idGeneralProject, linkedGeneralTasks);
	}
	
	// Charger la liste des project generaux
	public ArrayList<ArrayList<String>> loadAllGeneralProject(){
		return this.myManagerGeneralManager.loadAllGeneralProject();
	}
	
	// Charger un projet general
	public ArrayList<String> loadGeneralProject(int idGeneralProject){
		return this.myManagerGeneralManager.loadGeneralProject(idGeneralProject);
	}
	
	// Charger la liste des taches reli� � un projet general
	public ArrayList<ArrayList<String>> loadAllTasksLinkedToGeneralProject(int idGeneralProject){
		return this.myManagerGeneralManager.loadAllTasksLinkedToGeneralProject(idGeneralProject);
	}
	
	// UPDATE Enregistrer un projet (qui poura appeler apres Enregistrer les taches reli�s a un project general) le string est la liste des id
	public boolean updateGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory, String[] linkedGeneralTasks){
		return this.myManagerGeneralManager.updateGeneralProject(idGeneralProject, name,  description, idProjectCategory, linkedGeneralTasks);
	}
	
	// Supprimer le projet general et ses liens
	public boolean deleteGeneralProject(int idGeneralProject){
		return this.myManagerGeneralManager.deleteGeneralProject(idGeneralProject);
	}
	
	// ADD Enregistrer une tache (qui poura appeler apres Enregistrer les produits reli�s a une tache generale)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean addGeneralTask(String name, String description, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		return this.myManagerGeneralManager.addGeneralTask(name, description, theoreticalLength, idTaskCategory, linkedProductCategories);
	}
	
	// (Enregistrer les produit relier a une tache generale) ==> (quantity unit idcategory)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean saveLinkedProductCategories(int idGeneralTask, String[][] linkedProductCategories){
		return this.myManagerGeneralManager.saveLinkedProductCategories(idGeneralTask, linkedProductCategories);
	}
	
	// Charger une tache generale
	public ArrayList<String> loadGeneralTask(int idGeneralTask){
		return this.myManagerGeneralManager.loadGeneralTask(idGeneralTask);
	}
	
	// Charger la liste des category de produits reli� a cette tache generale
	public ArrayList<ArrayList<String>> loadAllProductCategoriesLinkedToGeneralTask(int idGeneralTask){
		return this.myManagerGeneralManager.loadAllProductCategoriesLinkedToGeneralTask(idGeneralTask);
	}
	
	// UPDATE Enregistrer une tache generale (qui poura appeler apres Enregistrer les produits reli�s a une tache generale)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean updateGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		return this.myManagerGeneralManager.updateGeneralTask(idGeneralTask, name, description, theoreticalLength, idTaskCategory, linkedProductCategories);
	}
	
	// Supprimer la tache generale et ses liens
	public boolean deleteGeneralTask(int idGeneralTask){
		return this.myManagerGeneralManager.deleteGeneralTask(idGeneralTask);
	}
	
} 
