package model;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class PriviledgeDao extends BaseDAO{
		
		private static PriviledgeDao instance = null;
		private PriviledgeDao() {}
		public static PriviledgeDao getInstance() {
			if(instance == null) {
				instance = new PriviledgeDao();
			}
			return instance;
		}
		
		final String ASSIGN_WEBSITE_PRIVILEDGE = "INSERT INTO WebsitePriviledge "
				+ "(priviledgeId, websiteId, developerId) VALUES (?,?,?)";
		final String ASSIGN_PAGE_PRIVILEDGE = "INSERT INTO PagePriviledge "
				+ "(priviledgeId, developerId, pageId) VALUES (?,?,?)";
		final String DELETE_WEBSITE_PRIVILEDGE = "DELETE FROM WebsitePriviledge WHERE developerId=? and websiteId=? and priviledgeId=?";
		final String DELETE_PAGE_PRIVILEDGE = "DELETE FROM PagePriviledge WHERE developerId=? and pageId=? and priviledgeId=?";
		
		
		
		public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
			connection = null;
			pstmt = null;
			int result;
			
			 try {
			      Class.forName(JDBC_DRIVER);
			      connection = DriverManager.getConnection(DB_URL, USER, PASS);
			      pstmtP = connection.prepareStatement(ASSIGN_WEBSITE_PRIVILEDGE);
			      
			      pstmtP.setInt(1, priviledgeId);
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
		
		public int assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
			pstmt = null;
			int result;
			
			 try {
			      Class.forName(JDBC_DRIVER);
			      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			      pstmtP = connection.prepareStatement(ASSIGN_PAGE_PRIVILEDGE);
			      
			      pstmtP.setInt(1, priviledgeId);
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
		
	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
			
			connection = null;
			pstmt = null;
			
		    try {
		      Class.forName(JDBC_DRIVER);
		      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      pstmt = connection.prepareStatement(DELETE_WEBSITE_PRIVILEDGE);
			  pstmt.setInt(1, developerId);
			  pstmt.setInt(2, websiteId);
			  pstmt.setInt(3, priviledgeId);
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

	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
		connection = null;
		pstmt = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmt = connection.prepareStatement(DELETE_PAGE_PRIVILEDGE);
		  pstmt.setInt(1, developerId);
		  pstmt.setInt(2, pageId);
		  pstmt.setInt(3, priviledgeId);
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


