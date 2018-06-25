package dataModel;

//import java.util.LinkedList;
//import java.util.List;
import java.sql.Date;

public class Website {
	
	
	
	private int websiteId;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits ;
	private int developerId;
//	private List<WebsitePriviledge> websitePriviledges = new LinkedList<WebsitePriviledge>();
//	private List<WebsiteRole> websiteRoles= new LinkedList<WebsiteRole>();
//	private List<Page> pages = new LinkedList<Page>();
	
	
	
public Website(int websiteId, String name, String description, Date created, Date updated, int visits,
			int developerId 
//			List<WebsitePriviledge> websitePriviledges, List<WebsiteRole> websiteRoles,
//			List<Page> pages
			) {
		super();
		this.websiteId = websiteId;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developerId = developerId;
//		this.websitePriviledges = websitePriviledges;
//		this.websiteRoles = websiteRoles;
//		this.pages = pages;
	}

	public Website() {
		super();
	}
	
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
//	public List<WebsitePriviledge> getWebsitePriviledges() {
//		return websitePriviledges;
//	}
//	public void setWebsitePriviledges(List<WebsitePriviledge> websitePriviledges) {
//		this.websitePriviledges = websitePriviledges;
//	}
//	public List<WebsiteRole> getWebsiteRoles() {
//		return websiteRoles;
//	}
//	public void setWebsiteRoles(List<WebsiteRole> websiteRoles) {
//		this.websiteRoles = websiteRoles;
//	}
//	public List<Page> getPages() {
//		return pages;
//	}
//	public void setPages(List<Page> pages) {
//		this.pages = pages;
//	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created2) {
		this.created = created2;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	
	public String toString() {
		return  "WebsiteId: " + websiteId + "\n" + 
				"Name of website: " + name + "\n" + 
				"Description: " + description + "\n" + 
				"Date created: " + created + "\n" + 
				"Date updated: " + updated + "\n" + 
				"Amount of visits: " + visits + "\n" + 
				"Developer Identification: " + developerId + "\n" + "\n";
	}
	

}
