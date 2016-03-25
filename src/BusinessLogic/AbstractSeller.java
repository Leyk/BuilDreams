package BusinessLogic;

public abstract class AbstractSeller {
	private String wording;
	private int siret;
	private String webSite;
	private String domainActivity;
	private String idRole; //PrimarKey //ForeignKey
	
	public AbstractSeller(String wording, int siret, String webSite, String domainActivity, String idRole) {
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

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	
	
}
