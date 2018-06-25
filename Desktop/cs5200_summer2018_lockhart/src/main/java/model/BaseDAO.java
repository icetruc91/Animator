package model;


import java.sql.Connection;
import java.sql.PreparedStatement;


public class BaseDAO {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://cs5200-summer2018-clockhart-1.clfneoreyntd.us-east-2.rds.amazonaws.com/hw2_lockhart_curt_summer_2018";
	final static String USER = "clockhart";
	final static String PASS = "Highland91!";
    static Connection connection = null;
    static PreparedStatement pstmtP = null;
    static PreparedStatement pstmtD = null;
    static PreparedStatement pstmt = null;

//    public void execute() throws ClassNotFoundException, SQLException {
//    	Class.forName("com.mysql.jdbc.Driver");
//    	Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//    	String sql = "SELECT * FROM Developer";
////    	Statement statement = connection.createStatement();
//    	 pstmtP = connection.prepareStatement(sql);
////    	pstmtP.setString(1, "alice");
//    	ResultSet rs = pstmtP.executeQuery();
//    	while(rs.next()) {
//    		int id = rs.getInt("developerId");
//    		String username = rs.getString("developerKey");
//    		int personId = rs.getInt("personId");
//    		System.out.println(id + "\t" + username + "\t" + personId );
//    	}
//    	rs.close();
//    	pstmtP.close();
//    	connection.close();
//    	
//    }
// 
}

