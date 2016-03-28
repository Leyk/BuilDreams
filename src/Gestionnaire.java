
/*
// PS on a la personne et ses rôles stockés

class Gestionnaire { 
	// Mock Up 1
	// CHARGER LE PANIER
	// Requete : Select * from item, product, seller, basket, itemBasket WHERE (Le role stocké Users).idRole = basket.idRole and basket.idBasket = itemBasket.idBasket and itemBasket.idItem = Item.idItem and Item.idProduct = Product.idProduct and Product.idRole = Seller.idRole
	// Il cree ensuite les : Item, Product, Seller, Basket par leur type correspondant dans l'application (for + edition des liens entres ces objets)
	// MODIFIER LES ITEM PAR LE DELETE OU LA MODIFICATION DE QUANTITÉ
	void deleteItemFromBasket (Item, Basket) {
		// Requete : Delete * from itemBasket where Item.idItem =  itemBasket.idItem and Basket.idBasket = itemBasket.idBasket
		// Supprime un element de la liste du panier et le suprimme aussi dans l'application ducoup mais aussi dans la base pour garder la coherence
	}
	void modifyQuantityForItem (Item, Basket, newQuantity) {
		// modifie dans l'application la quantité pour un produit  et le sauve automatiquement ou pas
		// Requete : Update item SET quantity = newQuantity where Item.idItem = item.idItem  
	}
	void passCommand(basket, CBinfo) {
		// Creer la commande correspondante et la stocke dans la base
		// requete : insert into command "la nouvelle commande toute fraichement créée, ne pas oublier le idRole à relier à l'user"
		// requete : insert into itemCommand (idItem, IdCommand) pour chaque item du basket pour la commande crée deux ligne plus haut
	    // auusi pour chaque seller de la commande il faut mettre un lien entre celle ci et eux
	    //Requette :  insert into commandSeller values (Seller.idRole, Command.idCommand, "!")


	}
	
	// Mock up 2
	// Ici on a deja la personne et ses role depuis sa connection
	void modifyProfilSeller(name, surname, email, password, website, domainActivity, siret, phoneNumber) {
	// Requete : Update person set //name, surname, email, password, phoneNumber where person.nickname = Person.nickname
	// Requete : Update seller set //website, domainActivity, siret where seller.idRole = Person.idrole
	}
	
	
	// Mock Up 3
	// Ici on a deja la personne et ses role depuis sa connection
	void modifyProfilUser(name, surname, email, password, phoneNumber) {
	// Requete : Update person set //TOUT LES ATTRIBUTS CI-DESSSUS where person.nickname = Person.nickname
	}

	// Mock Up 4
	// CHARGER LE SHOP ORDERS VIEW
	// Requete : Select * from Users, Seller, Command, Item, Product, itemCommand, commandSeller Where Users.idRole = command.idRole and command.idRole = itemCommand.idRole and itemCommand.idItem = Item.idItem and item.idProduct = Product.idProduct and Product.idRole = Seller.idRole
	// Apres fetch ca puis les mettre dans les element cree dans part la factory, faire les liens, et les remplir et les retourner à la vue
	void sentCommand(Command)
	{
		// met l'etat de la commande à envoyé
		// Requete : Update command set commandSeller.state = "sent" where command.idCommand = Command.idCommand
	
	}
	void valideCommand(Command)
	{
		// met l'etat de la commande à validé
		// Requete : Update command set commande.state = "validated" where command.idCommand = Command.idCommand
	
	}

	// Mock Up 5 
	void addSeller(les champs entré dans la vue) {
		//insert into Personne value(// les champ liée à la table personne)
		//insert into role value nickname 
		//insert into seller values idRole et les attributs en rapport avec le seller "seller"
	}
	void addUsers(les champs entré dans la vue) {
		//insert into Personne value(// les champ liée à la table personne)
		//insert into role value nickname
		//insert into users values idRole "users"
	}
	void updateSeller(les champs modifié dans la vue) {
	// exactement pareil que avant sauf que on fait update TABLE set valeur = newValeur where id=nickname/idrole
	}
	void updateUsers(les champs modifié dans la vue) {
	// exactement pareil que avant sauf que on fait update TABLE set valeur = newValeur where id=nickname/idrole
	}
	void deleteUsers(idRole ou idPerson ?) {
	// Pareil avec un delete
	}
	void deleteSeller(idRole ou idPerson ?) {
	// Pareil avec un delete
	}


									// Mock Up 6 // FAIT
									void logoff(){
										// logoff
									}
									
									// MockUp 7 // FAIT
									void addPersonRegistration() {
										//insert into Personne value(// les champ liée à la table personne)
									}
									void addSellerRegistration(les champs entré dans la vue) {
										//insert into role value nickname 
										//insert into seller values idRole et les attributs en rapport avec le seller "seller"
									}
									void addUsersRegistration(les champs entré dans la vue) {
										//insert into role value nickname
										//insert into users values idRole "users"
									}
									
									// Mock Up 8 // FAIT
									// Use case login donc normalement c'est bon

	// Mock Up 9 
	// Ici on manage les category
	void addProjectCategory(name)
	    //creation de l'objet
	    //requette insert into la table de la catégory values (name)
	    
	    // Pareil pour les 3 add
	    
	    // avant l'update charchement des category de la base pour le menu deroulant
	    // requete :  select * from category
	void updateCategory()
	    // Update category set newnam where name=oldname
	    
	void deleteCategory()
	    // pareil qu'au dessus on charge et on fifni par un delete pas cmpliqué
	    
// Mock Up 10
    // Ici on manage les produit depuit un compte seller
    // poru les 2 premier il faut d'abort importer les category de produit
    // requete : select * from ProductCategory
    // pour les 2 dernier il faut import le nom de ses produit
    // select name, desc, quant, idcat, idrole, id product from Product, seller where seller.idRole = Product.idRole and Seller.idRole = Seller.idRole
    // apres cela il faut faire les taches specifiques
void addProduit()
    // insert...
void updateProduit()
    // update....
void deleteProduit()
    //delete ...
    
    
    
// Mock Up 11 - GENERAL MANAGING
    // ici c'est le mastodonte
    //CREATE PROJECT
    // requete pour charger les category : select * from categoryProject
    void addProjectG(){
        
    }
    
    //CREATE TASKS
    
    void addTadkG(){
    
    }
    
    //UPDATE PROJECT
    
    void updateProjectG(){
        
    }

    //UPDATE TASK
    
    void updateTaskG(){
        
    }
    
    //DELETE PROJECT
    
    void deleteProject() {
        
    }
    
    //DELETE TASK
    
    void deleteTask(){
    
    }
    
    // SELECT TASKS
    
    void selectTasks(){
        // select 
    }
    void selectTasks(project){
        
    }
    
    // SELECT PRODUCT
    
    
    void selectProducts(){
        
    }
    
    
    
    
    
    
    
    
    
}*/