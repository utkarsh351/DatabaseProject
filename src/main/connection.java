package main;

import java.sql.*;

public class connection {
	
	private static final String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	private static String user = "rbhasin";	// add your unity id if want to test something, don't do in this db
	private static String passwd = "200259240"; //add you password for oracle here.

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public connection() {
		if(stmt == null) {
			
			createConnection();
		}
	}
	
	private static void createConnection() {
		try {
			
			conn = DriverManager.getConnection(jdbcURL, user, passwd);

			stmt = conn.createStatement();
			
		} catch (Throwable e) {
			System.out.println("************************CONNECTION FAILED**************************");
//			e.printStackTrace();
		}
	}
	
//	call this function to create table. pass create statement as a string in query
	public int createTable(String query) {
		try {
			return stmt.executeUpdate(query);
		} catch (Throwable e) {
			System.out.println("************************CREATE TABLE FAILED**************************");
//			e.printStackTrace();
		}
		return -1;
	}
	
//	call this function to insert queries. pass insert statement as a string in query
	public int insertQuery(String query) {
		try {
			return stmt.executeUpdate(query);
		} catch (Throwable e) {
			System.out.println("************************INSERT QUERY FAILED**************************");
//			e.printStackTrace();
		}
		return -1;
	}
	
//	call this function for select queries. pass select statement as a string in query
	public ResultSet selectQuery(String query) {
		try {
			rs = stmt.executeQuery(query);
		} catch (Throwable e) {
			System.out.println("************************SELECT QUERY FAILED**************************");
//			e.printStackTrace();
		}
		
		return rs;
	}

//	call this statement to get statement, if required ever,
//	otherwise always use only connection object to manipulate everything.
	public static Statement getStatement() {
		if(stmt == null) {
			createConnection();
		}
		
		return stmt;
	}
	
	
//	call close functions from when everything is done or when necessary
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable e) {
				System.out.println("************************CONNECTION CLOSE FAILED**************************");
//				e.printStackTrace();
			}
		}
	}

	public static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Throwable e) {
				System.out.println("************************STATEMENT CLOSE FAILED**************************");
//				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Throwable e) {
				System.out.println("************************RESULTSET CLOSE FAILED**************************");
//				e.printStackTrace();
			}
		}
	}

}
