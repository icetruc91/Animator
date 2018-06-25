package ExerciseYourDataModels;

import java.sql.Date;

import dataModel.Developer;
import dataModel.HeadingWidget;
import dataModel.HtmlWidget;
import dataModel.ImageWidget;
import dataModel.Page;
import dataModel.Website;
import dataModel.Widget;
import dataModel.YouTubeWidget;
import model.DeveloperDAO;
import model.PageDao;
import model.PriviledgeDao;
import model.RoleDao;
import model.WebsiteDao;
import model.WidgetDao;
import dataModel.Developer;

public class hw_jdbc_lockhart_curt {
	
	 long millis=System.currentTimeMillis();  
    java.sql.Date date = new java.sql.Date(millis);  
	DeveloperDAO developerDao = DeveloperDAO.getInstance();
	Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", date,
			"alice@wonder.com", "Person", 12, "4321rewq");
	Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", date,
			"bob@marley.com", "Person", 23, "5432trew");
	Developer charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", date,
			"charlie@garcia.com", "Person", 34, "6543ytre");
	Developer dan = new Developer(45, "Dan", "Martin", "dan", "dan", date,
			"dan@martin.com", "Person", 45, "7654fda");
	Developer ed = new Developer(56, "Ed", "Karaz", "ed", "ed", date,
			"ed@karaz.com", "Person", 67, "5678dfgh");
	
	int newDeveloper = developerDao.createDeveloper(alice);
	int newDeveloper1 = developerDao.createDeveloper(bob);
	int newDeveloper2 = developerDao.createDeveloper(charlie);
	int newDeveloper3 = developerDao.createDeveloper(dan);
	int newDeveloper4 = developerDao.createDeveloper(ed);
	
	
	WebsiteDao websiteDao = WebsiteDao.getInstance();
	Website facebook = new Website(123, "Facebook", "an online media and social networking service",
			date, date, 1234234, 12 );
	Website twitter = new Website(234, "Twitter", "an online news and social networking service",
			date, date, 4321543, 23 );
	Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia",
			date, date, 3456654, 34 );
	Website cnn = new Website(456, "CNN", "an American basic cable and satelite television and news",
			date, date, 65433454, 45 );
	Website cnet = new Website(567, "CNET", "An american media website",
			date, date, 5433455, 56 );
	Website gizmodo = new Website(678, "Gizmod", "a design, tech, science and science fiction website that also writes articles on politics",
			date, date, 4322345, 789);
	
	int newWebsite = websiteDao.createWebsiteForDeveloper(12, facebook);
	int newWebsite1 = websiteDao.createWebsiteForDeveloper(23, twitter);
	int newWebsite2 = websiteDao.createWebsiteForDeveloper(34, wikipedia);
	int newWebsite3 = websiteDao.createWebsiteForDeveloper(12, cnn);
	int newWebsite4 = websiteDao.createWebsiteForDeveloper(23, cnet);
	int newWebsite5 = websiteDao.createWebsiteForDeveloper(34, gizmodo);
	
	RoleDao roleDao = RoleDao.getInstance();
	int newRole = roleDao.assignWebsiteRole(12, 123, 1);
	int newRole1 = roleDao.assignWebsiteRole(23, 123, 4);
	int newRole2 = roleDao.assignWebsiteRole(34, 123, 2);
	int newRole3 = roleDao.assignWebsiteRole(23, 234, 1);
	int newRole4 = roleDao.assignWebsiteRole(34, 234, 4);
	int newRole5 = roleDao.assignWebsiteRole(12, 234, 2);
	int newRole6 = roleDao.assignWebsiteRole(34, 345, 1);
	int newRole7 = roleDao.assignWebsiteRole(12, 345, 4);
	int newRole8 = roleDao.assignWebsiteRole(23, 345, 2);
	int newRole9 = roleDao.assignWebsiteRole(12, 456, 1);
	int newRole10 = roleDao.assignWebsiteRole(23, 456, 4);
	int newRole11 = roleDao.assignWebsiteRole(34, 456, 2);
	int newRole12 = roleDao.assignWebsiteRole(23, 567, 1);
	int newRole13 = roleDao.assignWebsiteRole(34, 567, 4);
	int newRole14 = roleDao.assignWebsiteRole(12, 567, 2);
	int newRole15 = roleDao.assignWebsiteRole(34, 678, 1);
	int newRole16 = roleDao.assignWebsiteRole(12, 678, 4);
	int newRole17 = roleDao.assignWebsiteRole(23, 678, 2);
	
	
	PageDao pageDao = PageDao.getInstance();
	
	Page home = new Page(123, "Home", "Landing page", date, date, 123434, 567);
	Page about = new Page(234, "About", "Website description", date, date, 234545, 678);
	Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", date, date, 345656, 345);
	Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", date, date, 456776, 456);
	Page profile = new Page(567, "Profile", "users can configure their personal information", date, date, 567878, 567);
	
	int newPage = pageDao.createPageForWebsite(123, home);
	int newPage1 = pageDao.createPageForWebsite(678, about);
	int newPage2 = pageDao.createPageForWebsite(345, contact);
	int newPage3 = pageDao.createPageForWebsite(456, preferences);
	int newPage4 = pageDao.createPageForWebsite(123, profile);
	
	
	int newPageRole = roleDao.assignPageRole(12, 123, 4);
	int newPageRole1 = roleDao.assignPageRole(23, 123, 5);
	int newPageRole2 = roleDao.assignPageRole(34, 123, 3);
	int newPageRole3 = roleDao.assignPageRole(23, 234, 4);
	int newPageRole4 = roleDao.assignPageRole(34, 234, 5);
	int newPageRole5 = roleDao.assignPageRole(12, 234, 3);
	int newPageRole6 = roleDao.assignPageRole(34, 345, 4);
	int newPageRole7 = roleDao.assignPageRole(12, 345, 5);
	int newPageRole8 = roleDao.assignPageRole(23, 345, 3);
	int newPageRole9 = roleDao.assignPageRole(12, 456, 4);
	int newPageRole10 = roleDao.assignPageRole(23, 456, 5);
	int newPageRole11 = roleDao.assignPageRole(34, 456, 3);
	int newPageRole12 = roleDao.assignPageRole(23, 567, 4);
	int newPageRole13 = roleDao.assignPageRole(34, 567, 5);
	int newPageRole14 = roleDao.assignPageRole(12, 567, 3);
	
	WidgetDao widgetDao = WidgetDao.getInstance();
	
	Widget head123 = new HeadingWidget(123, "head123", 0, 0,null, null,
			"Welcome", 0, 123, "heading", 1, 0 );
	Widget post234 = new HtmlWidget(234, "post234",0,0, null, null, "<p>Lorem<p>",
			0, 234, "html", 1, null);
	Widget head345 = new HeadingWidget(345, "head345",0,0, null, null, "Hi",
			1, 345, "heading", 2, 0);
	Widget intro456 = new HtmlWidget(456, "intro456",0,0, null, null, "<h1>Hi<h1>",
			2, 345, "html", 2, null);
	Widget image345 = new ImageWidget(567, "image345", 50, 100, null, null, null,
			3, 345, "image", "/img/567.png", 1);
	Widget video456 = new YouTubeWidget(789, "video456", 400, 300, null, null, null,
			0, 456, "youtube", 1, "https:youtube.com", null, null);
	
	
	int newWidget = widgetDao.createWidgetForPage(123, head123);
	int newWidget1 = widgetDao.createWidgetForPage(123, post234);
	int newWidget2 = widgetDao.createWidgetForPage(123, head345);
	int newWidget3 = widgetDao.createWidgetForPage(123, intro456);
	int newWidget4 = widgetDao.createWidgetForPage(123, image345);
	int newWidget5 = widgetDao.createWidgetForPage(123, video456);
	
	
	
	// Implement Updates
	// 1
	Widget head345Part2 = new HeadingWidget(345, "head345",0,0, null, null, "Hi",
			3, 345, "heading", 2, 0);
	Widget intro456Part2 = new HtmlWidget(456, "intro456",0,0, null, null, "<h1>Hi<h1>",
			1, 345, "html", 2, null);
	Widget image345Part2 = new ImageWidget(567, "image345", 50, 100, null, null, null,
			2, 345, "image", "/img/567.png", 1);
	int update1 = widgetDao.updateWidget(345, head345Part2);
	int update12 = widgetDao.updateWidget(456, intro456Part2);
	int update13 = widgetDao.updateWidget(567, image345Part2);
	
	//2
	Page homePart2 = new Page(123, "CNET-Home", "Landing page", date, date, 123434, 567);
	Page profilePart2 = new Page(567, "CNET-Profile", "users can configure their personal information", date, date, 567878, 567);
	int update21 = pageDao.updatePage(123, homePart2);
	int update22 = pageDao.updatePage(567, profilePart2);
	
	//3
	int newPageRole1Part2 = roleDao.deletePageRole(23, 123, 5);
	int newPageRole2Part2 = roleDao.deletePageRole(34, 123, 3);
	int update31 = roleDao.assignPageRole(23, 123, 3);
	int update32 = roleDao.assignPageRole(34, 123, 5);
	
	
	// Implement Deletes
	// 1
	int deleteWidget = widgetDao.deleteWidget(345);
	// 2
	int deleteWidget2 = widgetDao.deleteWidget(456);
	//3 
	int deleteWebsite = websiteDao.deleteWebsite(567);
	
	
	
	
	
	
	

}
