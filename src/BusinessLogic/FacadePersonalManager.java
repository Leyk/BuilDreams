package BusinessLogic;
// MOCK UP 12
public class FacadePersonalManager {
	
	private ManagerPersonalManager myGV;

	public FacadePersonalManager() {
		this.myGV = new ManagerPersonalManager();
	}
	
	// A SIMOM : Lors du select penses bien à recuper la liste de [idCategoryTache] pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create Personal Project 
	// Charger les projet generau si demander (check yes)
	// Charger un projet generale si demandé (si check yes bien sur)
	// Si
	// un projet generale est choisie la personne auras que a mettre les date et faire create, les taches avec leur produit relier sont faite automatiquement, il pourra les modifier ulterieurement
	// Enregistrer un projet personel
	// Sinon
	// Creation classique
	
	
	// Update General Project
	// Charger la liste des project personel
	// Charger un projet personel
	// Charger les category de project : facade category
	// Afficher les taches relier a ce projet
	// Choix Create Update Delete tache voir plus bas
	// Enregistrement du projet personel

	// Delete General Project
	// Charger la liste des project personel
	// Charger un projet personel
	// Supprimer le projet personel et ses liens
	
	// A SIMOM : Lors du select penses bien à recuper la liste de [idCategoryProduit, quantity, unit] (ici tableau 3 fois n) pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create Personal Task 
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	// Enregistrer une tache (qui poura appeler apres Enregistrer les produits reliés a une tache personelle)
	// (Enregistrer les produit relier a une tache personel) ==> (quantity unit idcategory)
	
	// Update Personal Task
	// Charger la liste des taches personnels de ce projet
	// Charger les category de Tache : facade category
	// Charger une tache personel
	// Charger les category de produit
	// Charger la liste des produits relié à cette tache personele
	// Enregistrer une tache personel (qui poura appeler apres Enregistrer les produits reliés a la tache personel)
	// (Enregistrer les produits reliés a une tache personel)
	
	// Delete Personal Tache
	// Charger la liste des taches personnelles
	// Charger une tache personelle
	// Supprimer la tache personelle et ses liens
	
	
	
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
	


	// Ca ajoute un produit de ce seller à la base 
	public boolean addGeneralProject(String name, String description, float quantity, String reference, float price , int idCategory){
		
	}
	
	// Ca modifie un produit de ce seller à la base
	public boolean updateProductSeller(int idProduct, String name, String description, float quantity, String reference, float price , int idCategory){
		return this.myGV.updateProductSeller(idProduct, name, description, quantity, reference, price , idCategory);
	}
	
	// Ca supprime un produit de ce seller de la base
	public boolean deleteProductSeller(int idProduct){
		return this.myGV.deleteProductSeller(idProduct);
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
	}*/

} 
