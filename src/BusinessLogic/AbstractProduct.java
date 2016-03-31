package BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractProduct {
	private int idProduct; //PrimarKey
	private String name;
	private String description;
	private float quantity;
	private String reference;
	private float price;
	private int idCategory; //ForeignKey
	private int idRole; //ForeignKey
	
	public AbstractProduct(int idProduct, String name, String description, float quantity, String reference,
			float price, int idCategory, int idRole) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reference = reference;
		this.price = price;
		this.idCategory = idCategory;
		this.idRole = idRole;
	}

	public AbstractProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	public abstract ArrayList<ArrayList<String>> loadContentDB(int i) throws SQLException;

	public abstract void saveInsertDB() throws SQLException;

	public abstract ArrayList<ArrayList<String>> loadContentAllDB() throws SQLException;
	
}