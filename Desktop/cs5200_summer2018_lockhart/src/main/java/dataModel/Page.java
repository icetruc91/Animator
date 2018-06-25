package dataModel;

import java.util.LinkedList;
import java.util.List;
import java.sql.Date;

public class Page {

	
	private int pageId;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int views;
//	private List<PageRole> pageRoles = new LinkedList<PageRole>();
//	private List<PagePriviledge> pagePriviledges = new LinkedList<PagePriviledge>();
//	private List<Widget> widgets = new LinkedList<Widget>();
	private int websiteId;
	
	public Page(int pageId, String title, String description, Date created, Date updated, int views,
		 int websiteId) {
		super();
		this.pageId = pageId;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
//		this.pageRoles = pageRoles;
//		this.pagePriviledges = pagePriviledges;
//		this.widgets = widgets;
		this.websiteId = websiteId;
	}
	
	public Page() {
		super();
	}
	
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
//	public List<PageRole> getPageRoles() {
//		return pageRoles;
//	}
//	public void setPageRoles(List<PageRole> pageRoles) {
//		this.pageRoles = pageRoles;
//	}
//	public List<PagePriviledge> getPagePriviledges() {
//		return pagePriviledges;
//	}
//	public void setPagePriviledges(List<PagePriviledge> pagePriviledges) {
//		this.pagePriviledges = pagePriviledges;
//	}
//	public List<Widget> getWidgets() {
//		return widgets;
//	}
//	public void setWidgets(List<Widget> widgets) {
//		this.widgets = widgets;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	
	
}
