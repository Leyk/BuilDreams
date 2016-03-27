package BusinessLogic;

import java.sql.SQLException;

public abstract class AbstractSeller {
	private String wording;
	private int siret;
	private String webSite;
	private String domainActivity;
	private int idRole; //PrimarKey //ForeignKey
	
	public AbstractSeller(String wording, int siret, String webSite, String domainActivity, int idRole) {
		super();
		this.wording = wording;
		this.siret = siret;
		this.webSite = webSite;
		this.domainActivity = domainActivity;
		this.idRole = idRole;
	}

	public AbstractSeller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
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

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public abstract int saveInsertDB(String pseudo) throws SQLException;
	
	
}
