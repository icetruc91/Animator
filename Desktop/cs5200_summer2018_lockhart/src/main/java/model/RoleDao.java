package model;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class RoleDao extends BaseDAO{
	
	private static RoleDao instance = null;
	private RoleDao() {}
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	final String ASSIGN_WEBSITE_ROLE = "INSERT INTO WebsiteRole "
			+ "(roleId, websiteId, developerId) VALUES (?,?,?)";
	final String ASSIGN_PAGE_ROLE = "INSERT INTO PageRole "
			+ "(roleId, developerId, pageId) VALUES (?,?,?)";
	final String DELETE_WEBSITE_ROLE = "DELETE FROM WebsiteRole WHERE developerId=? and websiteId=? and roleId=?";
	final String DELETE_PAGE_ROLE = "DELETE FROM PageRole WHERE developerId=? and pageId=? and roleId=?";
	
	
	
	public int assignWebsiteRole(int developerId, int websiteId, int roleId) {
		connection = null;
		pstmt = null;
		int result;
		
		 try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmtP = connection.prepareStatement(ASSIGN_WEBSITE_ROLE);
		      
		      pstmtP.setInt(1, roleId);
		      pstmtP.setInt(2, developerId);
		      pstmtP.setInt(3, websiteId);
		      
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
	
	public int assignPageRole(int developerId, int pageId, int roleId) {
		pstmt = null;
		int result;
		
		 try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmtP = connection.prepareStatement(ASSIGN_PAGE_ROLE);
		      
		      pstmtP.setInt(1, roleId);
		      pstmtP.setInt(2, developerId);
		      pstmtP.setInt(3, pageId);
		      
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
	
public int deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		
		connection = null;
		pstmt = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmt = connection.prepareStatement(DELETE_WEBSITE_ROLE);
		  pstmt.setInt(1, developerId);
		  pstmt.setInt(2, websiteId);
		  pstmt.setInt(3, roleId);
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

public int deletePageRole(int developerId, int pageId, int roleId) {
	connection = null;
	pstmt = null;
	
    try {
      Class.forName(JDBC_DRIVER);
      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
      pstmt = connection.prepareStatement(DELETE_PAGE_ROLE);
	  pstmt.setInt(1, developerId);
	  pstmt.setInt(2, pageId);
	  pstmt.setInt(3, roleId);
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
