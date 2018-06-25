package com.cs5200.jdbc;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.cs5200.jdbc.insertStatements;

import dataModel.Website;
import dataModel.Widget;
import dataModel.YouTubeWidget;
import model.DeveloperDAO;
import model.WebsiteDao;
import model.WidgetDao;


@SpringBootApplication
public class Cs5200Summer2018LockhartApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Summer2018LockhartApplication.class, args);
		
		WebsiteDao websiteDao = WebsiteDao.getInstance();
//		DeveloperDAO developerDao = DeveloperDAO.getInstance();
		WidgetDao widgetDao = WidgetDao.getInstance();
		
		
//		System.out.println("Find all widgets:");
//		List<Widget> widgets = widgetDao.findAllWidgets();
//		for(Widget widget: widgets) {
//			System.out.println(widget);
//		}
//		System.out.println();
		
//		System.out.println("Find all widget by widgetId:");
//		Widget widget = widgetDao.findWidgetById(123);
//		System.out.println(widget);
//		System.out.println();
		
//		System.out.println("Find all widgets by pageId:");
//		List<Widget> widgets = widgetDao.findWidgetsForPage(345);
//		for(Widget widget: widgets) {
//			System.out.println(widget);
//		}
//		System.out.println();
		
		System.out.println("Create a new widget");
		YouTubeWidget ywidget = new YouTubeWidget();
		ywidget.setWidgetId(789);
		ywidget.setName("This");
		ywidget.setHeight(30);
		ywidget.setWidth(30);
		ywidget.setOrder(30);
		ywidget.setUrl("kjsdlhfdskjfgsd");
		ywidget.setPageId(456);
		ywidget.setType("youtube");
		ywidget.setShareable(true);
		ywidget.setExpandable(true);
		
		int widget = widgetDao.createWidgetForPage(456, ywidget);
//		Widget widget1 = widgetDao.findWidgetById(789);
//		System.out.println(widget1);
//		System.out.println();
		
//		System.out.println("Find all widgets:");
//		List<Widget> widgets = widgetDao.findAllWidgets();
//		for(Widget widget2: widgets) {
//			System.out.println(widget2);
//		}
//		System.out.println();
		
		
		
		
		
//		System.out.println("Find all websites:");
//		List<Website> websites =  websiteDao.findAllWebsites();
//		for(Website website: websites) {
//			System.out.println(website);
//		}
//		System.out.println();
		
//		System.out.println("Find all websites by developerId:");
//		List<Website> websites1 = websiteDao.findWebsitesForDeveloper(12);
//		for(Website website: websites1) {
//			System.out.println(website);
//		}
//		System.out.println();
	
		
//		 long millis=System.currentTimeMillis();  
//	     java.sql.Date date = new java.sql.Date(millis);  
//		
//		Website website = new Website();
//		website.setWebsiteId(789);
//		website.setName("Plea");
//		website.setDescription("How a bout 100% on this assignment?");
//		website.setCreated(date);
//		website.setUpdated(date);
//		website.setVisits(12345678);
//		website.setDeveloperId(12);
//		
//		System.out.println("Create website for devveloper: ");
//		websiteDao.createWebsiteForDeveloper(12, website);
//		
//		System.out.println();
//		
//		System.out.println("Find all websites:");
//		List<Website> websites =  websiteDao.findAllWebsites();
//		for(Website website1: websites) {
//			System.out.println(website1);
//		}
//		System.out.println();
//		
		
//		System.out.println("Find website by ID: ");
//		Website website = websiteDao.findWebsiteById(123);
//		System.out.println(website);
//		System.out.println();
		
//		System.out.println("Update website: ");
//		 long millis=System.currentTimeMillis();  
//	     java.sql.Date date = new java.sql.Date(millis);  
//		Website website = new Website();
//		website.setWebsiteId(789);
//		website.setName("Please");
//		website.setDescription("How about 100% on this assignment?");
//		website.setCreated(date);
//		website.setUpdated(date);
//		website.setVisits(12345678);
//		website.setDeveloperId(12);
//		
//		int newWebsite = websiteDao.updateWebsite(789, website);
//		System.out.println(newWebsite);
//		
//		System.out.println("Find all websites:");
//		List<Website> websites =  websiteDao.findAllWebsites();
//		for(Website website1: websites) {
//			System.out.println(website1);
//		}
//		System.out.println();
		
		
		
//		insertStatements.execute();
	
	}
}
