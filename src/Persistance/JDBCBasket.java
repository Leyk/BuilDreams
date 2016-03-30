package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractBasket;
public class JDBCBasket extends AbstractBasket {

	public JDBCBasket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCBasket(int idBasket, int idRole) {
		super(idBasket, idRole);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int saveInsertDB(int role) throws SQLException {
		String queryBasket = "INSERT INTO Basket(idRole) VALUES ('" + String.valueOf(role) + "');";
		try {
		ResultSet rs = JDBCSingleton.getInstance().UpdateWithResultSet(queryBasket);
		int id_AutoIncrement = 0;
	    if (rs.next()){
	    	id_AutoIncrement=rs.getInt(1);
	    }
	    return id_AutoIncrement;
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
	}

	@Override
	public void loadDB(int idRole) throws SQLException {
		if (idRole != -1) {
		String queryBasket = "Select * From Basket Where idRole = '" + idRole + "';";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryBasket);
	    while (rs.next()) {
	    	this.setIdRole(Integer.parseInt(rs.getString("idRole")));
	    	this.setIdBasket(Integer.parseInt(rs.getString("idBasket")));
	        }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadDB");
		}
		} else {
			new IllegalArgumentException("vous n'etes pas un users");
		}
		
	}

	@Override
	public ArrayList<ArrayList<String>> loadContentDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryBasketContent = "Select Product.idProduct, Product.name, Item.idItem , Item.quantity, Item.price, Seller.idRole, Person.nickname From Basket, itemBasket, Item, Product, Seller, Role, Person  Where Basket.idBasket = " + this.getIdBasket() + " and itemBasket.idBasket = Basket.idBasket and itemBasket.idItem = Item.idItem and Item.idProduct = Product.idProduct and Product.idRole = Seller.idRole and Seller.idRole = Role.idRole and Role.nickname = Person.nickname;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryBasketContent);
		int i = 0;
		while (rs.next()) {
			ArrayList<String> temp = new ArrayList<String>();
	    	for (int j= 0; j<7; j++){
	    		temp.add(j,rs.getString(j+1));
	    	}
	    	res.add(i, temp);
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadConntentDB");
		}
		return res;
	}

	@Override
	public void deleteItemFromBasket(int idItem) throws SQLException {
		try {
			String queryDelete = "Delete from itemBasket where idBasket = " + this.getIdBasket() + " and idItem = " + idItem + ";";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete);
		} catch (SQLException e) {
			throw new SQLException("Erreur, deleteItemFromBasket");
		}
	}

	@Override
	public ArrayList<String> getListItem() throws SQLException {
		ArrayList<String> res = new ArrayList<String>();
		String queryListItem = "Select idItem From itemBasket where idBasket = " + this.getIdBasket() + ";";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryListItem);
		int i = 0;
		while (rs.next()) {
	    	res.add(i, rs.getString(1));
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, getListItem");
		}
		return res;
	}

	@Override
	public ArrayList<String> getListSeller() throws SQLException {
		ArrayList<String> res = new ArrayList<String>();
		String queryListSeller = "Select distinct Seller.idRole From Basket, itemBasket, Item, Product, Seller, Role, Person  Where Basket.idBasket = " + this.getIdBasket() + " and itemBasket.idBasket = Basket.idBasket and itemBasket.idItem = Item.idItem and Item.idProduct = Product.idProduct and Product.idRole = Seller.idRole;";
		try {
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryListSeller);
		int i = 0;
		while (rs.next()) {
	    	res.add(i, rs.getString(1));
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, getListSeller");
		}
		return res;
	}

	@Override
	public void deleteAllLinkedItem() throws SQLException {
			String queryDelete = "Delete from itemBasket where idBasket = '" + this.getIdBasket() + "';";
			try {
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryDelete);
			}
			catch (SQLException e) {
				throw new SQLException("Erreur, deleteAllLinketItem");
			}
	}
	
	
}
