package dataModel;


import java.sql.Date;

public class Developer extends Person{
	

	private int developerId;
	private String developerKey;
	
	

	public Developer(int personId, String firstName, String lastName, String username, String password, Date dob,
		String email, String type, int developerId, String developerKey) {
	super(personId, firstName, lastName, username, password, dob, email, type);
	this.developerId = developerId;
	this.developerKey = developerKey;
}

	
	public Developer() {
		super();
	}





	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	
//	public int getPersonId() {
//		return personID;
//	}
//	public void setPersonId(int personId) {
//		this.personID = personId;
//	}
//	
//	public Person getPerson() {
//		return person;
//	}
//	public void setPerson(Person person) {
//		this.person = person;
//	}
	
	// needs: add/delete PageRole, Website, PagePriviledge, WebsitePriviledge, WebsiteRole
	
//	public void addWebsite(Website website) {
//		websites.add(website);
//	}
//	public void removeWebsite(Website website) {
//		websites.add(website);
//	}
//	public List<Website> getWebsites() {
//		return websites;
//	}
//	
//	public void addPagePriviledge(PagePriviledge priviledge) {
//		pagePriviledges.add(priviledge);
//	}
//	
//	public void removePagePriviledge(PagePriviledge priviledge) {
//		pagePriviledges.remove(priviledge);
//	}
//	
//	public List<PagePriviledge> getPagePriviledges() {
//		return pagePriviledges;
//	}
//	
//	public void addPageRole(PageRole role) {
//		pageRoles.add(role);
//	}
//	
//	public void removePageRole(PageRole role) {
//		pageRoles.remove(role);
//	}
//	
//	public List<PageRole> getPageRoles() {
//		return pageRoles;
//	}
//	
//	public void addWebsitePriviledge(WebsitePriviledge priviledge) {
//		websitePriviledges.add(priviledge);
//	}
//	
//	public void removeWebsitePriviledge(WebsitePriviledge priviledge) {
//		websitePriviledges.remove(priviledge);
//	}
//	
//	public List<WebsitePriviledge> getWebsitePriviledges() {
//		return websitePriviledges;
//	}
//	
//	public void addWebsiteRole(WebsiteRole role) {
//		websiteRoles.add(role);
//	}
//	
//	public void removeWebsiteRole(WebsiteRole role) {
//		websiteRoles.remove(role);
//	}
//	public List<WebsiteRole> getWebsiteRoles() {
//		return websiteRoles;
//	}
	
	

}
