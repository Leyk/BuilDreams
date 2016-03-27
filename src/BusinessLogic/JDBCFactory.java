package BusinessLogic;

import java.sql.Date;
import java.sql.SQLException;

import Persistance.JDBCAdmin;
import Persistance.JDBCBasket;
import Persistance.JDBCCommand;
import Persistance.JDBCGeneralProject;
import Persistance.JDBCGeneralTask;
import Persistance.JDBCItem;
import Persistance.JDBCPerson;
import Persistance.JDBCPersonalProject;
import Persistance.JDBCPersonalTask;
import Persistance.JDBCProduct;
import Persistance.JDBCProductCategory;
import Persistance.JDBCProjectCategory;
import Persistance.JDBCSeller;
import Persistance.JDBCTaskCategory;
import Persistance.JDBCUsers;


public class JDBCFactory extends AbstractFactory{
	
	public JDBCFactory (){
		super();
	}
	
	@Override
	public AbstractAdmin createAdmin() {
		return new JDBCAdmin();
	}
	
	@Override
	public AbstractAdmin createAdmin(String wording, int idRole) {
		return new JDBCAdmin(wording, idRole);
	}

	@Override
	public AbstractBasket createBasket() {
		return new JDBCBasket();
	}

	@Override
	public AbstractBasket createBasket(int idBasket, int idRole) {
		return new JDBCBasket(idBasket, idRole);
	}

	@Override
	public AbstractCommand createCommand() {
		return new JDBCCommand();
	}

	@Override
	public AbstractCommand createCommand(int idCommand, int idRole) {
		return new JDBCCommand(idCommand, idRole);
	}

	@Override
	public AbstractGeneralProject createGeneralProject() {
		return new JDBCGeneralProject();
	}

	@Override
	public AbstractGeneralProject createGeneralProject(int idGeneralProject, String name, String description,
			int idProjectCategory) {
		return new JDBCGeneralProject(idGeneralProject, name, description,
				idProjectCategory);
	}

	@Override
	public AbstractGeneralTask createGeneralTask() {
		return new JDBCGeneralTask();
	}

	@Override
	public AbstractGeneralTask createGeneralTask(int idGeneralTask, String name, String description,
			int theoreticalLength, int idTaskCategory) {
		return new JDBCGeneralTask(idGeneralTask, name, description,
				theoreticalLength, idTaskCategory);
	}

	@Override
	public AbstractItem createItem() {
		return new JDBCItem();
	}

	@Override
	public AbstractItem createItem(int idItem, float price, float quantity, int idProduct) {
		return new JDBCItem(idItem, price, quantity, idProduct);
	}

	@Override
	public AbstractPerson createPerson() {
		return new JDBCPerson();
	}

	@Override
	public AbstractPerson createPerson(String pseudoIn, String passwordIn) {
		return new JDBCPerson(pseudoIn, passwordIn);
	}

	@Override
	public AbstractPerson createPerson(String pseudo, String name, String surname, String email, String password, String phoneNumber) {
		return new JDBCPerson(pseudo, name, surname, email, phoneNumber,
				password);
	}

	@Override
	public AbstractPersonalProject createPersonalProject() {
		return new JDBCPersonalProject();
	}

	@Override
	public AbstractPersonalProject createPersonalProject(int idPersonalProject, String name, String description,
			Date beginDate, Date endDate, int idRole, int idProjectCategory) {
		return new JDBCPersonalProject(idPersonalProject, name, description, 
				beginDate, endDate, idRole, idProjectCategory);
	}

	@Override
	public AbstractPersonalTask createPersonalTask() {
		return new JDBCPersonalTask();
	}

	@Override
	public AbstractPersonalTask createPersonalTask(String name, String description, Date beginDate, Date endDate,
			int theoreticalLength, int idEntry, int idPersonalProject, int idTaskCategory) {
		return new JDBCPersonalTask(name, description, beginDate, endDate,
				theoreticalLength, idEntry, idPersonalProject, idTaskCategory);
	}

	@Override
	public AbstractProduct createProduct() {
		return new JDBCProduct();
	}

	@Override
	public AbstractProduct createProduct(int idProduct, String name, String description, float quantity, int idCategory,
			int idRole) {
		return new JDBCProduct(idProduct, name, description, quantity, idCategory,
				idRole);
	}

	@Override
	public AbstractProductCategory createProductCategory() {
		return new JDBCProductCategory();
	}

	@Override
	public AbstractProductCategory createProductCategory(int idCategory, String name, int idSuperCategory) {
		return new JDBCProductCategory(idCategory, name, idSuperCategory);
	}

	@Override
	public AbstractProjectCategory createProjectCategory() {
		return new JDBCProjectCategory();
	}

	@Override
	public AbstractProjectCategory createProjectCategory(int idProjectCategory, String name,
			int idSuperProjectCategory) {
		return new JDBCProjectCategory(idProjectCategory, name,
				idSuperProjectCategory);
	}

	@Override
	public AbstractSeller createSeller() {
		return new JDBCSeller();
	}

	@Override
	public AbstractSeller createSeller(String wording, int siret, String webSite, String domainActivity,
			int idRole) {
		return new JDBCSeller(wording, siret, webSite, domainActivity,
				idRole);
	}

	@Override
	public AbstractTaskCategory createTaskCategory() {
		return new JDBCTaskCategory();
	}

	@Override
	public AbstractTaskCategory createTaskCategory(int idTaskCategory, String name, int idSuperTaskCategory) {
		return new JDBCTaskCategory(idTaskCategory, name, idSuperTaskCategory);
	}

	@Override
	public AbstractUsers createUsers() {
		return new JDBCUsers();
	}

	@Override
	public AbstractUsers createUsers(String wording, int idRole) {
		return new JDBCUsers(wording, idRole);
	}
}