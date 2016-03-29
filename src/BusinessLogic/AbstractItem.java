package BusinessLogic;

import java.sql.SQLException;

public abstract class AbstractItem {
	private int idItem; //PrimarKey
	private float price;
	private float quantity;
	private int idProduct; //ForeignKey
	
	public AbstractItem(int idItem, float price, float quantity, int idProduct) {
		super();
		this.idItem = idItem;
		this.price = price;
		this.quantity = quantity;
		this.idProduct = idProduct;
	}

	public AbstractItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public abstract void UpdateQuantityItem() throws SQLException;
	
	
}
