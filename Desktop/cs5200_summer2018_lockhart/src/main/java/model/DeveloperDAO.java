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

import dataModel.Developer;
import dataModel.Website;


public class DeveloperDAO extends BaseDAO{
	
	private static DeveloperDAO instance = null;
	private DeveloperDAO() {}
	public static DeveloperDAO getInstance() {
		if(instance == null) {
			instance = new DeveloperDAO();
		}
		return instance;
	}
	
	final String CREATE_PERSON = "INSERT INTO Person (personId, firstName, lastName, "
			+ "username, password, dob, "
			+ "email) "
			+ "VALUES (?,?,?,?,?,?,?)";
	
	final String CREATE_DEVELOPER =
		"INSERT INTO Developer (developerId, developerKey, personId) "
		+ "VALUES (?,?,?)";
	
	final String FIND_ALL_DEVELOPERS = "UNION SELECT * "
			+ "FROM Developer d, Person p"
			+ "WHERE p.personId = d.personId ";
	
	final String FIND_DEVELOPER_BY_ID = "SELECT p.personId, p.firstName, p.lastName, p.username, p.password, "
			+ "p.dob, p.email, d.developerId, d.developerKey "
			+ "FROM Person p"
			+ " INNER JOIN Developer d"
			+ "WHERE d.developerId=?";
	
	final String FIND_DEVELOPER_BY_USERNAME = "SELECT p.personId, p.firstName, p.lastName, p.username, p.password, "
			+ "p.dob, p.email, d.developerId, d.developerKey "
			+ "FROM Person p"
			+ " INNER JOIN Developer d"
			+ "WHERE p.username=?";
	
	final String FIND_DEVELOPER_BY_CREDENTIALS =
			"SELECT p.personId, p.firstName, p.lastName, p.username, p.password, "
					+ "p.dob, p.email, d.developerId, d.developerKey "
					+ "FROM Person p"
					+ " INNER JOIN Developer d"
					+ "WHERE p.username=? and p.password=?";
	
	final String UPDATE_DEVELOPER = "UPDATE Developer d INNER JOIN Person p ON d.personId = p.personId"
			+ "SET p.personId, p.firstName, p.lastName, p.username, p.password, p.dob, p.email, d.developerId,"
			+ "d.developerKey WHERE d.developerId=?";
	
	final String DELETE_DEVELOPER = "DELETE p.personId, p.firstName, p.lastName, p.username, p.password, "
			+ "p.dob, p.email, d.developerId, d.developerKey "
			+ "FROM Person p"
			+ " INNER JOIN Developer d"
			+ "WHERE d.developerId=?";
	
	
	public int createDeveloper(Developer d) {
		connection = null;
		pstmtP = null;
		pstmtD = null;
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	      pstmtD = connection.prepareStatement(CREATE_DEVELOPER);
	      pstmtP = connection.prepareStatement(CREATE_PERSON);
	      
	      pstmtP.setInt(1, d.getPersonId());
	      pstmtP.setString(2, d.getFirstName());
	      pstmtP.setString(3, d.getLastName());
	      pstmtP.setString(4, d.getUsername());
	      pstmtP.setString(5, d.getPassword());
	      pstmtP.setDate(6, (Date) d.getDob());
	      pstmtP.setString(7, d.getEmail());
	      
//	      pstmtP.setArray(8, (Array) d.getAddresses());
//	      pstmtP.setArray(9, (Array) d.getPhones());
	      
	      pstmtD.setInt(1, d.getDeveloperId());
	      pstmtD.setString(2, d.getDeveloperKey());
	      pstmtD.setInt(3, d.getPersonId());
	      
	      int resultP = pstmtP.executeUpdate();
	      int resultD = pstmtD.executeUpdate();
	      
	      pstmtP.executeUpdate();
	      pstmtD.executeUpdate();
	      connection.close();
	      pstmtP.close();
	      pstmtD.close();
	      
	      return resultP + resultD;
	      
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
	
	
	public List<Developer> findAlDevelopers() {
		List<Developer> developers = new ArrayList<Developer>();
		connection = null;
		Statement stmt = null;
		ResultSet results = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) connection.createStatement();
			results = stmt.executeQuery(FIND_ALL_DEVELOPERS);
			

			while(results.next()) {
				
				int personId= results.getInt("personId");
				String firstName= results.getString("firstName");
				String lastName= results.getString("lastName");
				String username = results.getString("username");
				String password= results.getString("password");
				Date dob= results.getDate("dob");
				String email= results.getString("email");
				int developerId = results.getInt("develorId");
				String developerKey= results.getString("developerKey");
				
				Developer developer = new Developer();
				developer.setPersonId(personId);
				developer.setFirstName(firstName);
				developer.setLastName(lastName);
				developer.setUsername(username);
				developer.setPassword(password);
				developer.setDob(dob);
				developer.setEmail(email);
				developer.setDeveloperId(developerId);
				developer.setDeveloperKey(developerKey);
				
				
				developers.add(developer);
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
		return developers;
		
		}
	
	public Developer findDeveloperById(int developerId) {
			Developer developer = new Developer();
			ResultSet results = null;
			
			
			try {
				Class.forName(JDBC_DRIVER);
				connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				pstmt = (PreparedStatement) connection.prepareStatement(FIND_DEVELOPER_BY_ID);
				pstmt.setInt(1, developerId);
				results = pstmt.executeQuery();
				
				
				if(results.next()) {
					
					int personId= results.getInt("personId");
					String firstName= results.getString("firstName");
					String lastName= results.getString("lastName");
					String username = results.getString("username");
					String password= results.getString("password");
					Date dob= results.getDate("dob");
					String email= results.getString("email");
					String developerKey= results.getString("developerKey");
					
					developer.setPersonId(personId);
					developer.setFirstName(firstName);
					developer.setLastName(lastName);
					developer.setUsername(username);
					developer.setPassword(password);
					developer.setDob(dob);
					developer.setEmail(email);
					developer.setDeveloperKey(developerKey);
					developer.setDeveloperId(developerId);
					
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
			return developer;
			
			}
	
	public Developer findDeveloperByUsername(String username) {
		Developer developer = new Developer();
		ResultSet results = null;
		
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = (PreparedStatement) connection.prepareStatement(FIND_DEVELOPER_BY_ID);
			pstmt.setString(1, username);
			results = pstmt.executeQuery();
			
			
			if(results.next()) {
				
				int personId= results.getInt("personId");
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String password = results.getString("password");
				Date dob = results.getDate("dob");
				String email = results.getString("email");
				int developerId = results.getInt("developerId");
				String developerKey= results.getString("developerKey");
				
				developer.setPersonId(personId);
				developer.setFirstName(firstName);
				developer.setLastName(lastName);
				developer.setUsername(username);
				developer.setPassword(password);
				developer.setDob(dob);
				developer.setEmail(email);
				developer.setDeveloperKey(developerKey);
				developer.setDeveloperId(developerId);
				
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
		return developer;
		
		}
	


public Developer findDeveloperByCredentials(String username, String password) {
	Developer developer = new Developer();
	ResultSet results = null;
	
	
	try {
		Class.forName(JDBC_DRIVER);
		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		pstmt = (PreparedStatement) connection.prepareStatement(FIND_DEVELOPER_BY_CREDENTIALS);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		results = pstmt.executeQuery();
		
		
		if(results.next()) {
			
			int personId= results.getInt("personId");
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			Date dob = results.getDate("dob");
			String email = results.getString("email");
			int developerId = results.getInt("developerId");
			String developerKey= results.getString("developerKey");
			
			developer.setPersonId(personId);
			developer.setFirstName(firstName);
			developer.setLastName(lastName);
			developer.setUsername(username);
			developer.setPassword(password);
			developer.setDob(dob);
			developer.setEmail(email);
			developer.setDeveloperKey(developerKey);
			developer.setDeveloperId(developerId);
			
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
	return developer;
	
	}


public int updateDeveloper(int developerId, Developer developer) {
	
	connection = null;
	pstmt = null;
	
    try {
      Class.forName(JDBC_DRIVER);
      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
      pstmt = connection.prepareStatement(UPDATE_DEVELOPER);
	  pstmt.setInt(1, developer.getPersonId());
	  pstmt.setString(2, developer.getFirstName());
	  pstmt.setString(3, developer.getLastName());
	  pstmt.setString(4, developer.getUsername());
	  pstmt.setString(5, developer.getPassword());
	  pstmt.setDate(6, (Date) developer.getDob());
	  pstmt.setString(7, developer.getEmail());
	  pstmt.setString(8, developer.getDeveloperKey());
	  pstmt.setInt(9, developer.getDeveloperId());
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

public int deleteWebsite(int websiteId) {
	
	connection = null;
	pstmt = null;
	
    try {
      Class.forName(JDBC_DRIVER);
      connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
      pstmt = connection.prepareStatement(DELETE_DEVELOPER);
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
		
	}
	
	
	
	

