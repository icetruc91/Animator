package dataModel;

public class WebsitePriviledge {
	
	private int developerId;
	private int websiteId;
	private Priviledge priviledge;
	private int websitePriviledgeId;
	

	public WebsitePriviledge(int developerId, int websiteId, Priviledge priviledge, int websitePriviledgeId) {
		super();
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.priviledge = priviledge;
		this.websitePriviledgeId = websitePriviledgeId;
	}
	
	public WebsitePriviledge() {
		super();
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public int getWebsitePriviledgeId() {
		return websitePriviledgeId;
	}
	
	public void setWebsitePriviledgeId(int websitePriviledgeId) {
		this.websitePriviledgeId = websitePriviledgeId;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}
	

}
