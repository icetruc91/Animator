package model;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import dataModel.Page;

public class PageDao extends BaseDAO{
	
	private static PageDao instance = null;
	private PageDao() {}
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	final String CREATE_PAGE = "INSERT INTO PAGE (pageId, title, description, created, updated, "
			+ "views, websiteId)"
			+ "VALUES (?,?,?,?,?,)";
	
	final String FIND_ALL_PAGES = "SELECT * FROM Page";
	final String FIND_PAGE_BY_PAGEID = "SELECT * FROM Page WHERE pageId=?";
	final String FIND_PAGES_FOR_WEBSITE = "SELECT * FROM Page WHERE websiteId=?";
	final String DELETE_PAGE = "DELETE FROM Page WHERE pageId=?";
	final String UPDATE_PAGE = "UPDATE Page SET pageId=?, title=?, description=?, "
			+ "created=?, updated=?, views=? WHERE websiteId=?";
	
	public int createPageForWebsite(int websiteId, Page page) {
		connection = null;
		pstmt = null;
		int result;
		
		 try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmtP = connection.prepareStatement(CREATE_PAGE);
		     
		      pstmtP.setInt(1, page.getPageId());
		      pstmtP.setString(2, page.getTitle());
		      pstmtP.setString(3, page.getDescription());
		      pstmtP.setDate(4, page.getCreated());
		      pstmtP.setDate(5, page.getUpdated());
		      pstmtP.setInt(6, page.getViews());
		      pstmtP.setInt(7, websiteId);
		      
		      result = pstmt.executeUpdate();
		      connection.close();
		      pstmt.close();
		      return result;
		 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			return 1;
			}
		      
	
	public List<Page> findAllPages() {
		List<Page> pages = new ArrayList<Page>();
		connection = null;
		Statement stmt = null;
		ResultSet results = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) connection.createStatement();
			results = stmt.executeQuery(FIND_ALL_PAGES);
			

			while(results.next()) {
				
				int pageId = results.getInt("pageId");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				int websiteId = results.getInt("websiteId");
				
				
				Page page = new Page();
				page.setPageId(pageId);
				page.setTitle(title);
				page.setDescription(description);
				page.setCreated(created);
				page.setUpdated(updated);
				page.setViews(views);
				page.setWebsiteId(websiteId);
				
				
				pages.add(page);
			}
			connection.close();
			stmt.close();
			results.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return pages;
		
		}
	
	public Page findPageById(int pageId) {
		Page page = new Page();
		ResultSet result = null;
		
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = (PreparedStatement) connection.prepareStatement(FIND_PAGE_BY_PAGEID);
			pstmt.setInt(1, pageId);
			result = pstmt.executeQuery();
			
			
			
			if(result.next()) {
				
				
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int views = result.getInt("views");
				int websiteId = result.getInt("websiteId");
				
				page.setPageId(pageId);
				page.setTitle(title);
				page.setDescription(description);
				page.setCreated(created);
				page.setUpdated(updated);
				page.setViews(views);
				page.setWebsiteId(websiteId);
			}
			
			connection.close();
		    pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return page;
		
		}
	
	public List<Page> findPagesForWebsite(int websiteId) {
		List<Page> pages = new ArrayList<Page>();
		ResultSet results = null;
		pstmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = (PreparedStatement) connection.prepareStatement(FIND_PAGE_BY_PAGEID);
			pstmt.setInt(1, websiteId);
			results = pstmt.executeQuery();
			
			
			
			while(results.next()) {
				Page page = new Page();
				int pageId = results.getInt("pageId");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				
				page.setPageId(pageId);
				page.setTitle(title);
				page.setDescription(description);
				page.setCreated(created);
				page.setUpdated(updated);
				page.setViews(views);
				page.setWebsiteId(websiteId);
				
				pages.add(page);
			}
			
			connection.close();
		    pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return pages;
		
		}
	
	public int updatePage(int pageId, Page page) {
		
		connection = null;
		pstmt = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmt = connection.prepareStatement(UPDATE_PAGE);
	      
	      pstmtP.setInt(1, page.getPageId());
	      pstmtP.setString(2, page.getTitle());
	      pstmtP.setString(3, page.getDescription());
	      pstmtP.setDate(4, page.getCreated());
	      pstmtP.setDate(5, page.getUpdated());
	      pstmtP.setInt(6, page.getViews());
	      
		  int result = pstmt.executeUpdate(); 
		  pstmt.close();
		  connection.close();
		  return result;
		  
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return 1;
		
	}
	
	public int deletePage(int pageId) {
		
		connection = null;
		pstmt = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmt = connection.prepareStatement(DELETE_PAGE);
		  pstmt.setInt(1, pageId);
		  return pstmt.executeUpdate(); 
		  
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return -1;
		}
	
	
		
	}
		 
			      
			  
			      
			      
			   

			

