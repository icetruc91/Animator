package dataModel;

public class PagePriviledge {
	
	
	private int developerId;
	private int websiteId;
	private int priviledgeId;
	private Priviledge priviledge;
	

	public PagePriviledge(int developerId, int websiteId, int priviledgeId, Priviledge priviledge) {
		super();
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.priviledgeId = priviledgeId;
		this.priviledge = priviledge;
	}
	
	public PagePriviledge() {
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

	public int getPriviledgeId() {
		return priviledgeId;
	}

	public void setPriviledgeId(int priviledgeId) {
		this.priviledgeId = priviledgeId;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}
	

}
