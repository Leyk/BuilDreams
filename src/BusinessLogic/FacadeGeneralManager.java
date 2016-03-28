package BusinessLogic;
// MOCK UP 11 
public class FacadeGeneralManager {
	
	private ManagerGeneralManager myGV;

	public FacadeGeneralManager() {
		this.myGV = new ManagerGeneralManager();
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
	
	
	
/*
	

	// Charge tous les projets generaux
	public String[][] loadAllGeneralProject(){
		
	}
	
	// Charge toutes les taches generales
	public String[][] loadAllGeneralTask(){
		
	}
	
	// Charge toutes les taches generales
		public String[][] loadAllProjectTasks(){
			
		}
		
	// Charge toutes les taches generales
	public String[][] loadAllTask(){
		
	}
	


	// Ca ajoute un produit de ce seller � la base 
	public boolean addGeneralProject(String name, String description, float quantity, String reference, float price , int idCategory){
		
	}
	
	// Ca modifie un produit de ce seller � la base
	public boolean updateProductSeller(int idProduct, String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myGV.updateProductSeller(idProduct, name, description, quantity, reference, price , idCategory);
	}
	
	// Ca supprime un produit de ce seller de la base
	public boolean deleteProductSeller(int idProduct){
		return this.myGV.deleteProductSeller(idProduct);
	}
	
	// Ca ajoute un produit de ce seller � la base 
	public boolean addProductSeller(String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myGV.addProductSeller(name, description, quantity, reference, price , idCategory);
	}
	
	// Ca modifie un produit de ce seller � la base
	public boolean updateProductSeller(int idProduct, String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myGV.updateProductSeller(idProduct, name, description, quantity, reference, price , idCategory);
	}
	
	// Ca supprime un produit de ce seller de la base
	public boolean deleteProductSeller(int idProduct){
		return this.myGV.deleteProductSeller(idProduct);
	}*/

} 
