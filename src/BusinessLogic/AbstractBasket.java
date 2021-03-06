package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistance.JDBCSingleton;

public abstract class AbstractBasket {
	private int idBasket; //PrimarKey
	private int idRole; //ForeignKey
	
	public AbstractBasket(int idBasket, int idRole) {
		super();
		this.idBasket = idBasket;
		this.idRole = idRole;
	}

	public AbstractBasket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(int idBasket) {
		this.idBasket = idBasket;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public abstract int saveInsertDB(int role) throws SQLException;

	public abstract void loadDB(int idRole) throws SQLException;

	public abstract ArrayList<ArrayList<String>> loadContentDB() throws SQLException;

	public abstract void deleteItemFromBasket(int idItem) throws SQLException;

	public abstract ArrayList<String> getListItem() throws SQLException;

	public abstract ArrayList<String> getListSeller() throws SQLException;

	public abstract void deleteAllLinkedItem() throws SQLException;
		
	
}
