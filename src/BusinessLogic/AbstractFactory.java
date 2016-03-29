package BusinessLogic;

import java.sql.Date;

public abstract class AbstractFactory {
	
	
	abstract public AbstractAdmin createAdmin();
	abstract public AbstractAdmin createAdmin(String wording, int idRole);
	
	abstract public AbstractBasket createBasket();
	abstract public AbstractBasket createBasket(int idBasket, int idRole);
	
	abstract public AbstractCommand createCommand();
	abstract public AbstractCommand createCommand(int idCommand, int idRole);
	
	abstract public AbstractGeneralProject createGeneralProject();
	abstract public AbstractGeneralProject createGeneralProject(int idGeneralProject, String name, String description, int idProjectCategory);
	
	abstract public AbstractGeneralTask createGeneralTask();
	abstract public AbstractGeneralTask createGeneralTask(int idGeneralTask, String name, String description, int theoreticalLength,
			int idTaskCategory);
	
	abstract public AbstractItem createItem();
	abstract public AbstractItem createItem(int idItem, float price, float quantity, int idProduct);
	
	abstract public AbstractPerson createPerson();
	abstract public AbstractPerson createPerson (String pseudoIn, String passwordIn);
	abstract public AbstractPerson createPerson(String pseudo, String name, String surname, String email, String password, String phoneNumber);
	
	abstract public AbstractPersonalProject createPersonalProject();
	abstract public AbstractPersonalProject createPersonalProject(int idPersonalProject, String name, String description, Date beginDate, Date endDate,
			int idRole, int idProjectCategory);
	
	abstract public AbstractPersonalTask createPersonalTask();
	abstract public AbstractPersonalTask createPersonalTask(String name, String description, Date beginDate, Date endDate, int theoreticalLength,
			int idEntry, int idPersonalProject, int idTaskCategory);
	
	abstract public AbstractProduct createProduct();
	abstract public AbstractProduct createProduct(int idProduct, String name, String description, float quantity, String reference, float price, int idCategory, int idRole);
	
	abstract public AbstractProductCategory createProductCategory();
	abstract public AbstractProductCategory createProductCategory(int idCategory, String name, int idSuperCategory);
	
	abstract public AbstractProjectCategory createProjectCategory();
	abstract public AbstractProjectCategory createProjectCategory(int idProjectCategory, String name, int idSuperProjectCategory);
	
	abstract public AbstractSeller createSeller();
	abstract public AbstractSeller createSeller(String wording, int siret, String webSite, String domainActivity, int idRole);
	
	abstract public AbstractTaskCategory createTaskCategory();
	abstract public AbstractTaskCategory createTaskCategory(int idTaskCategory, String name, int idSuperTaskCategory);
	
	abstract public AbstractUsers createUsers();
	abstract public AbstractUsers createUsers(String wording, int idRole);
	
	// Classe abstraite de la factory, qui joue "presque" le role d'interface
}
