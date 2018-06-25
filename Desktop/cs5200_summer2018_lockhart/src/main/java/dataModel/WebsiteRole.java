package dataModel;

public class WebsiteRole {
	
	private int developerId;
	private int websiteId;
	private Role role;
	private int roleId;

	public WebsiteRole(int developerId, int websiteId, Role role, int roleId) {
		super();
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.role = role;
		this.roleId = roleId;
	}

	public WebsiteRole() {
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
