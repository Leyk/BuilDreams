package BusinessLogic;

import java.sql.SQLException;

public abstract class AbstractSeller extends AbstractRole{
	
	private int siret;
	private String webSite;
	private String domainActivity;
	

	public AbstractSeller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AbstractSeller(String wording, int idRole, int siret, String webSite, String domainActivity) {
		super(wording, idRole);
		this.siret = siret;
		this.webSite = webSite;
		this.domainActivity = domainActivity;
	}

	public int getSiret() {
		return siret;
	}

	public void setSiret(int siret) {
		this.siret = siret;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getDomainActivity() {
		return domainActivity;
	}

	public void setDomainActivity(String domainActivity) {
		this.domainActivity = domainActivity;
	}

	public abstract int saveInsertDB(String pseudo) throws SQLException;

	public abstract AbstractSeller loadDB(String pseudoIn);
	
	
}
