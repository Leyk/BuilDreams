package BusinessLogic;

public abstract class AbstractProduct {
	private int idProduct; //PrimarKey
	private String name;
	private String description;
	private float quantity;
	private int idCategory; //ForeignKey
	private int idRole; //ForeignKey
	
	public AbstractProduct(int idProduct, String name, String description, float quantity, int idCategory, int idRole) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
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
	
	
}
