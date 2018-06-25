package model;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dataModel.Website;

public class WebsiteDao extends BaseDAO{
	
	private static WebsiteDao instance = null;
	private WebsiteDao() {}
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	
	final String CREATE_WEBSITE = "INSERT INTO Website (websiteId, name, description, created, "
			+ "updated, visits, developerId) "
			+ "VALUES (?,?,?,?,?,?,?)";
	final String FIND_ALL_WEBSITES = "SELECT * FROM Website";
	final String FIND_WEBSITE_BY_DEVELOPERID = "SELECT * FROM Website WHERE developerId=?";
	final String DELETE_WEBSITE = "DELETE FROM Website WHERE websiteId=?";
	final String UPDATE_WEBSITE = "UPDATE Website SET name=?, description=?, created=?, "
			+ "updated=?, visits=?, developerId=? WHERE websiteId=?";
	final String FIND_WEBSITE_BY_WEBSITEID = "SELECT * FROM Website WHERE websiteId=?";
	
	
	public List<Website> findAllWebsites() {
		List<Website> websites = new ArrayList<Website>();
		connection = null;
		Statement stmt = null;
		ResultSet results = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) connection.createStatement();
			results = stmt.executeQuery(FIND_ALL_WEBSITES);
			

			while(results.next()) {
				int websiteId = results.getInt("websiteId");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				int developerId = results.getInt("developerId");
				
				Website website = new Website();
				website.setWebsiteId(websiteId);
				website.setName(name);
				website.setDescription(description);
				website.setCreated(created);
				website.setUpdated(updated);
				website.setVisits(visits);
				website.setDeveloperId(developerId);
				
				
				websites.add(website);
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
		return websites;
		
		}
	
	public List<Website> findWebsitesForDeveloper(int developerId) {
		List<Website> websites = new ArrayList<Website>();
		ResultSet results = null;
		
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = (PreparedStatement) connection.prepareStatement(FIND_WEBSITE_BY_DEVELOPERID);
			pstmt.setInt(1, developerId);
			results = pstmt.executeQuery();
			
			
			
			while(results.next()) {
				int websiteId = results.getInt("websiteId");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				
				Website website = new Website();
				website.setWebsiteId(websiteId);
				website.setName(name);
				website.setDescription(description);
				website.setCreated(created);
				website.setUpdated(updated);
				website.setVisits(visits);
				website.setDeveloperId(developerId);
				websites.add(website);
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
		return websites;
		
		}
	

		public int createWebsiteForDeveloper(int developerId, Website website) {
			connection = null;
			pstmt = null;
			
		    try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmt = connection.prepareStatement(CREATE_WEBSITE);
		      
		      pstmt.setInt(1, website.getWebsiteId());
		      pstmt.setString(2, website.getName());
		      pstmt.setString(3, website.getDescription());
		      pstmt.setDate(4, website.getCreated());
		      pstmt.setDate(5, website.getUpdated());
		      pstmt.setInt(6, website.getVisits());
		      pstmt.setInt(7, developerId);
		      
		      pstmt.executeUpdate();
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
			return 1;
			}
		
		public int deleteWebsite(int websiteId) {
			
			connection = null;
			pstmt = null;
			
		    try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmt = connection.prepareStatement(DELETE_WEBSITE);
			  pstmt.setInt(1, websiteId);
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
		
		public int updateWebsite(int websiteId, Website website) {
			
			connection = null;
			pstmt = null;
			
		    try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmt = connection.prepareStatement(UPDATE_WEBSITE);
			  pstmt.setString(1, website.getName());
			  pstmt.setString(2, website.getDescription());
			  pstmt.setDate(3, website.getCreated());
			  pstmt.setDate(4, website.getUpdated());
			  pstmt.setInt(5, website.getVisits());
			  pstmt.setInt(6, website.getDeveloperId());
			  pstmt.setInt(7, websiteId);
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
			return 0;
			
		}
		
		
		public Website findWebsiteById(int websiteId) {
			Website website = new Website();
			ResultSet result = null;
			
			
			try {
				Class.forName(JDBC_DRIVER);
				connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				pstmt = (PreparedStatement) connection.prepareStatement(FIND_WEBSITE_BY_WEBSITEID);
				pstmt.setInt(1, websiteId);
				result = pstmt.executeQuery();
				
				
				
				if(result.next()) {
					
					String name = result.getString("name");
					String description = result.getString("description");
					Date created = result.getDate("created");
					Date updated = result.getDate("updated");
					int visits = result.getInt("visits");
					int developerId = result.getInt("developerId");
					
					website.setWebsiteId(websiteId);
					website.setName(name);
					website.setDescription(description);
					website.setCreated(created);
					website.setUpdated(updated);
					website.setVisits(visits);
					website.setDeveloperId(developerId);
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
			return website;
			
			}
		
			
		}



