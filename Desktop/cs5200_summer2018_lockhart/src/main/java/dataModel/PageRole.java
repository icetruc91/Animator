package dataModel;

public class PageRole {

	
	private int developerId;
	private int websiteId;
	private int roleId;
	private Role role;

	
	public PageRole(int developerId, int websiteId, int roleId, Role role) {
		super();
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.roleId = roleId;
		this.role = role;
	}
	
	public PageRole() {
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
