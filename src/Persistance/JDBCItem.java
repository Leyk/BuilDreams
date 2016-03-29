package Persistance;
import java.sql.SQLException;

import BusinessLogic.AbstractItem;

public class JDBCItem extends AbstractItem{

	public JDBCItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCItem(int idItem, float price, float quantity, int idProduct) {
		super(idItem, price, quantity, idProduct);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void UpdateQuantityItem() throws SQLException {
		try {
			String queryUpdate = "Update Item Set quantity = " + this.getQuantity() + " where idItem = " + this.getIdItem() + ";";
			JDBCSingleton.getInstance().UpdateWithoutResultSet(queryUpdate);
		} catch (SQLException e) {
			throw new SQLException("Erreur, l'identifiant ou le mot de passe n'existe pas dans la base de donn�es");
		}
	}

}
