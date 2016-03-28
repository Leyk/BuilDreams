package BusinessLogic;

public class ManagerBasket extends ManagerLogin {
	
	private AbstractFactory myFactory;

	public ManagerBasket() {
		super();
		this.myFactory = new JDBCFactory();
	}

	

}
