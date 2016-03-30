package BusinessLogic;
// MOCK UP 12

import java.sql.Date;
import java.util.ArrayList;

public class FacadePersonalManager {
	
	private ManagerPersonalManager myManagerPersonalManager;
	
	public AbstractPerson getMyPerson() {
		return this.myManagerPersonalManager.getMyPerson();
	}

	public void setMyPerson(AbstractPerson myPerson) {
		this.myManagerPersonalManager.setMyPerson(myPerson);
	}

	public ArrayList<AbstractRole> getMyAbstractRoleArray() {
		return this.myManagerPersonalManager.getMyAbstractRoleArray();
	}

	public void setMyAbstractRoleArray(ArrayList<AbstractRole> myAbstractRoleArray) {
		this.myManagerPersonalManager.setMyAbstractRoleArray(myAbstractRoleArray);
	}

	public FacadePersonalManager() {
		this.myManagerPersonalManager = new ManagerPersonalManager();
	}
	
	// A SIMOM : Lors du select penses bien � recuper la liste de [idCategoryTache] pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create Personal Project 
	// Charger les projet generau si demander (check yes)
	// Charger un projet generale si demand� (si check yes bien sur)
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
	
	// A SIMOM : Lors du select penses bien � recuper la liste de [idCategoryProduit, quantity, unit] (ici tableau 3 fois n) pour apres l'envoyer dans la requette de creation ou d'update
	
	// Create Personal Task 
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	// Enregistrer une tache (qui poura appeler apres Enregistrer les produits reli�s a une tache personelle)
	// (Enregistrer les produit relier a une tache personel) ==> (quantity unit idcategory)
	
	// Update Personal Task
	// Charger la liste des taches personnels de ce projet
	// Charger les category de Tache : facade category
	// Charger une tache personel
	// Charger les category de produit
	// Charger la liste des produits reli� � cette tache personele
	// Enregistrer une tache personel (qui poura appeler apres Enregistrer les produits reli�s a la tache personel)
	// (Enregistrer les produits reli�s a une tache personel)
	
	// Delete Personal Tache
	// Charger la liste des taches personnelles de ce projet
	// Charger une tache personelle
	// Supprimer la tache personelle et ses liens
	
	//////////////////////////////////////////////
	
	// Charger les projet generau si demander (check yes) : FacadeGeneralManager
	// Charger un projet generale si demand� (si check yes bien sur) : FacadeGerneralManager
	// Charger les category de project : facade category
	// Charger les category de Tache : facade category
	// Charger les category de produits : facade category
	
	// Creation projet personel a partir d'un projet general : un projet generale est choisie la personne auras que a mettre les date et faire create, les taches avec leur produit relier sont faite automatiquement, il pourra les modifier ulterieurement
	public boolean addPersonalProjectFromGeneralProject(int idGeneralProject, Date beginDate, Date endDate){
		return this.myManagerPersonalManager.addPersonalProjectFromGeneralProject(idGeneralProject, beginDate, endDate);
	}
	
	// ADD Creation Classique Project personel
	public boolean addGeneralProject(String name, String description, Date beginDate, Date endDate, int idProjectCategory){
		return this.myManagerPersonalManager.addGeneralProject(name, description, beginDate, endDate, idProjectCategory);
	}
	
	// Charger la liste des project personel
	public ArrayList<ArrayList<String>> loadAllPersonalProject(){
		return this.myManagerPersonalManager.loadAllPersonalProject();
	}
	
	// Charger un projet personel
	public ArrayList<String> loadPersonalProject(int idPersonalProject){
		return this.myManagerPersonalManager.loadPersonalProject(idPersonalProject);
	}
	
	// Charger la liste des taches personnels de ce projet
	public ArrayList<ArrayList<String>> loadAllTasksLinkedToPersonalProject(int idPersonalProject){
		return this.myManagerPersonalManager.loadAllTasksLinkedToPersonalProject(idPersonalProject);
	}
	
	// UPDATE Enregistrement du projet personel (avec leur taches relier avec leur produit reli�) String[] le string est la liste des id
	public boolean updatePersonalProject(int idPersonalProject, String name, String description, Date beginDate, Date endDate, int idProjectCategory, String[] linkedPersonalTasks){
		return this.myManagerPersonalManager.updatePersonalProject(idPersonalProject, name, description, beginDate, endDate, idProjectCategory, linkedPersonalTasks);
	}
	
	// Supprimer le projet personel et ses liens
	public boolean deletePersonalProject(int idGeneralProject){
		return this.myManagerPersonalManager.deletePersonalProject(idGeneralProject);
	}
	
	// ADD Enregistrer une tache (qui poura appeler apres Enregistrer les produits reli�s a une tache personelle)
	// Retourne l'id de la tache sauv� pour pouvoir l'ajouter � la liste des tache pour la sauvegarde plus tard par le updatePersonalProject
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public String addPersonalTask(String name, String description, Date beginDate, Date endDate, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		return this.myManagerPersonalManager.addPersonalTask(name, description, beginDate, endDate, theoreticalLength, idTaskCategory, linkedProductCategories);
	}
	
	// (Enregistrer les produit relier a une tache personel) ==> (quantity unit idcategory)
	// Ici String[][] linkedProductCategories est un tableau avec sur chauqe ligne (idProductCategory, quantity, price)
	public boolean saveLinkedProductCategories(int idPersonalTask, String[][] linkedProductCategories){
		return this.myManagerPersonalManager.saveLinkedProductCategories(idPersonalTask, linkedProductCategories);
	}
	
	// Charger une tache personel
	public ArrayList<String> loadPersonalTask(int idPersonalTask){
		return this.myManagerPersonalManager.loadPersonalTask(idPersonalTask);
	}
	
	// Charger la liste des produits reli� � cette tache personelle
	public ArrayList<ArrayList<String>> loadAllProductCategoriesLinkedToPersonalTask(int idPersonalTask){
		return this.myManagerPersonalManager.loadAllProductCategoriesLinkedToPersonalTask(idPersonalTask);
	}
	
	// UPDATE Enregistrer une tache personel (qui poura appeler apres Enregistrer les produits reli�s a la tache personel)
	public String updatePersonalTask(int idPersonalTask, String name, String description, Date beginDate, Date endDate, int theoreticalLength, int idTaskCategory, String[][] linkedProductCategories){
		return this.myManagerPersonalManager.updatePersonalTask(idPersonalTask, name, description, beginDate, endDate, theoreticalLength, idTaskCategory, linkedProductCategories);
	}
	
	// Supprimer la tache personelle et ses liens
	public boolean deletePersonalTask(int idPersonalTask){
		return this.myManagerPersonalManager.deletePersonalTask(idPersonalTask);
	}
	


} 
