package BusinessLogic;
// MOCK UP 12

import java.sql.Date;

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
	// Creation Classique Project personell
	
	
	// Update General Project
	// Charger la liste des project personel
	// Charger un projet personel
	// Charger les category de project : facade category
	// Afficher les taches personelle relier a ce projet
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
	// Charger la liste des taches personnelles de ce projet
	// Charger une tache personelle
	// Supprimer la tache personelle et ses liens
	
	//////////////////////////////////////////////
	
	// Charger les projet generau si demander (check yes) : FacadeGeneralManager
	// Charger un projet generale si demandé (si check yes bien sur) : FacadeGerneralManager
	// Charger les category de project : facade category
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	
	// Creation projet personel a partir d'un projet general : un projet generale est choisie la personne auras que a mettre les date et faire create, les taches avec leur produit relier sont faite automatiquement, il pourra les modifier ulterieurement
	public boolean addPersonalProjectFromGeneralProject(int idGeneralProject, Date beginDate, Date endDate){
		
	}
	
	// ADD Creation Classique Project personel
	public boolean addGeneralProject(String name, String description, Date beginDate, Date endDate, int idProjectCategory){
	
	}
	
	// Charger la liste des project personel
	public String[][] loadAllPersonalProject(){
		
	}
	
	// Charger un projet personel
	public String[] loadPersonalProject(int idPersonalProject){
		
	}
	
	// Charger la liste des taches personnels de ce projet
	public String[][] loadAllTasksLinkedToPersonalProject(int idPersonalProject){
		
	}
	
	// UPDATE Enregistrement du projet personel (avec leur taches relier avec leur produit relié) String[] le string est la liste des id
	public boolean updatePersonalProject(int idPersonalProject, String name, String description, Date beginDate, Date endDate, int idProjectCategory, String[] linkedPersonalTasks){
		
	}
	
	// Supprimer le projet personel et ses liens
	public boolean deletePersonalProject(int idGeneralProject){
		
	}
	
	// ADD Enregistrer une tache (qui poura appeler apres Enregistrer les produits reliés a une tache personelle)
	// Retourne l'id de la tache sauvé pour pouvoir l'ajouter à la liste des tache pour la sauvegarde plus tard par le updatePersonalProject
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public String addPersonalTask(String name, String description, Date beginDate, Date endDate, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		
	}
	
	// (Enregistrer les produit relier a une tache personel) ==> (quantity unit idcategory)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean saveLinkedProductCategories(int idPersonalTask, String[][] linkedProductCategories){
		
	}
	
	// Charger une tache personel
	public String[] loadPersonalTask(int idPersonalTask){
		
	}
	
	// Charger la liste des produits relié à cette tache personelle
	public String[][] loadAllProductCategoriesLinkedToPersonalTask(int idPersonalTask){
		
	}
	
	// UPDATE Enregistrer une tache personel (qui poura appeler apres Enregistrer les produits reliés a la tache personel)
	public String updatePersonalTask(int idPersonalTask, String name, String description, Date beginDate, Date endDate, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		
	}
	
	// Supprimer la tache personelle et ses liens
	public boolean deletePersonalTask(int idPersonalTask){
		
	}
	


} 
