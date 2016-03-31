package Persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.AbstractProduct;

public class JDBCProduct extends AbstractProduct{

	public JDBCProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCProduct(int idProduct, String name, String description, float quantity, String reference, float price,
			int idCategory, int idRole) {
		super(idProduct, name, description, quantity, reference, price, idCategory, idRole);
		// TODO Auto-generated constructor stub
	}

	
	// This method permits to retrieve all the products
	@Override
	public ArrayList<ArrayList<String>> loadContentDB(int idRole) throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryProductContent = "select Product.reference, Product.name, ProductCategory.name, Person.nickname, Product.quantity, Product.price "
				+ "from Product, Productcategory, Role, Seller, Person where Product.idcategory = ProductCategory.idcategory and Product.idRole = Seller.idRole "
				+ "and Seller.idRole = Role.idRole and Role.nickname = Person.nickname and Seller.idRole = " + idRole + ";";
		try{
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryProductContent);
		int i = 0;
		while (rs.next()) {
			ArrayList<String> temp = new ArrayList<String>();
	    	for (int j= 0; j<6; j++){
	    		temp.add(j,rs.getString(j+1));
	    	}
	    	res.add(i, temp);
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadContentDB");
		}
		return res;
	}

	@Override
	public void saveInsertDB() throws SQLException {
		String queryGeneralTask = "INSERT INTO Product (name, description, quantity, reference, price ,idCategory, idRole) VALUES ('" + this.getName() + "','" + this.getDescription() + "'," + this.getQuantity() + ",'" + this.getReference() + "'," + this.getPrice() + "," + this.getIdCategory() + "," + this.getIdRole() + ");";
		try {
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryGeneralTask);
		} catch (SQLException e) {
			throw new SQLException("Erreur, saveInsertDB");
		}
		
	}

	@Override
	public ArrayList<ArrayList<String>> loadContentAllDB() throws SQLException {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String queryProductContent = "select Product.reference, Product.name, ProductCategory.name, Person.nickname, Product.quantity, Product.price "
				+ "from Product, Productcategory, Role, Seller, Person where Product.idcategory = ProductCategory.idcategory and Product.idRole = Seller.idRole "
				+ "and Seller.idRole = Role.idRole and Role.nickname = Person.nickname";
		try{
		ResultSet rs = JDBCSingleton.getInstance().RequestWithResultSet(queryProductContent);
		int i = 0;
		while (rs.next()) {
			ArrayList<String> temp = new ArrayList<String>();
	    	for (int j= 0; j<6; j++){
	    		temp.add(j,rs.getString(j+1));
	    	}
	    	res.add(i, temp);
	    	i++;
	    }
		}
		catch (SQLException e) {
			throw new SQLException("Erreur, loadContentDB");
		}
		return res;
	}



}
