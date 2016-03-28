package BusinessLogic;
// MOCK UP 11 
public class FacadeGeneralManager {
	
	private ManagerGeneralManager myGV;

	public FacadeGeneralManager() {
		this.myGV = new ManagerGeneralManager();
	}
	
	// A SIMOM : Lors du select penses bien à recuper la liste de [idCategoryTache] pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create General Project 
	// Charger les category de project : facade category
	// Charger les taches generales
	// Enregistrer un projet (qui poura appeler apres Enregistrer les taches reliés a un project general)
	// (Enregistrer les tache relier a un project general)
	
	// Update General Project
	// Charger la liste des project generaux
	// Charger les category de project : facade category
	// Charger un projet general
	// Charger les taches generales
	// Charger la liste des taches relié à un projet general
	// Enregistrer un projet (qui poura appeler apres Enregistrer les taches reliés a un project general)
	// (Enregistrer les tache relier a un project general)
	
	// Delete General Project
	// Charger la liste des project generaux
	// Charger un projet general
	// Supprimer le projet general et ses liens
	
	// A SIMOM : Lors du select penses bien à recuper la liste de [idCategoryProduit, quantity, unit] (ici tableau 3 fois n) pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create General Task 
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	// Enregistrer une tache (qui poura appeler apres Enregistrer les produits reliés a une tache generale)
	// (Enregistrer les produit relier a une tache generale) ==> (quantity unit idcategory)
	
	// Update General Task
	// Charger la liste des taches generale
	// Charger les category de Tache : facade category
	// Charger une tache generale
	// Charger les category de produit
	// Charger la liste des category de produits relié a cette tache generale
	// Enregistrer une tache generale (qui poura appeler apres Enregistrer les produits reliés a une tache generale)
	// (Enregistrer les produits reliés a une tache generale)
	
	// Delete General Task
	// Charger la liste des taches generales
	// Charger une tache generale
	// Supprimer la tache generale et ses liens
	
	
	/////////////////////////////////
	
	// Charger les category de project : facade category
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	
	// Charger les taches generales
	public String[][] loadAllGeneralTask(){
		
	}
	
	// ADD Enregistrer un projet (qui poura appeler apres Enregistrer les taches reliés a un project general) le string est la liste des id
	public boolean addGeneralProject(String name, String description, int idProjectCategory, String[] linkedGeneralTasks){
		
	}
	
	// (Enregistrer les tache relier a un project general) le string est la liste des id
	public boolean saveLinkedGeneralTask(int idGeneralProject, String[] linkedGeneralTasks){
		
	}
	
	// Charger la liste des project generaux
	public String[][] loadAllGeneralProject(){
		
	}
	
	// Charger un projet general
	public String[] loadGeneralProject(int idGeneralProject){
		
	}
	
	// Charger la liste des taches relié à un projet general
	public String[][] loadAllTasksLinkedToGeneralProject(int idGeneralProject){
		
	}
	
	// UPDATE Enregistrer un projet (qui poura appeler apres Enregistrer les taches reliés a un project general) le string est la liste des id
	public boolean updateGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory, String[] linkedGeneralTasks){
			
	}
	
	// Supprimer le projet general et ses liens
	public boolean deleteGeneralProject(int idGeneralProject){
		
	}
	
	// ADD Enregistrer une tache (qui poura appeler apres Enregistrer les produits reliés a une tache generale)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean addGeneralTask(String name, String description, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		
	}
	
	// (Enregistrer les produit relier a une tache generale) ==> (quantity unit idcategory)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean saveLinkedProductCategories(int idGeneralTask, String[][] linkedProductCategories){
		
	}
	
	// Charger une tache generale
	public String[] loadGeneralTask(int idGeneralTask){
		
	}
	
	// Charger la liste des category de produits relié a cette tache generale
	public String[][] loadAllProductCategoriesLinkedToGeneralTask(int idGeneralTask){
		
	}
	
	// UPDATE Enregistrer une tache generale (qui poura appeler apres Enregistrer les produits reliés a une tache generale)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean updateGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		
	}
	
	// Supprimer la tache generale et ses liens
	public boolean deleteGeneralTask(int idGeneralTask){
		
	}
	
} 
