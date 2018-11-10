package main;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
	
	static final String role = null; //will set it when user gets logged in

	public static void main(String[] args) {
		try {
			ResultSet rs = null;
			
			connection connObject = new connection();
			
//			******************************************
//			query like this everywhere
//			connObject.createTable("CREATE TABLE TRYING1 " + "(COF_NAME VARCHAR(32), SUP_ID INTEGER, "
//					+ "PRICE FLOAT, SALES INTEGER, TOTAL INTEGER)");
//			
//			connObject.insertQuery("INSERT INTO TRYING1 " + "VALUES ('Colombian', 101, 7.99, 0, 0)");
			
//			connObject.insertQuery("INSERT INTO TRYING1 " + "VALUES ('1', 1, 7.99, 0, 0)");
			
			rs = connObject.selectQuery("SELECT COF_NAME, PRICE FROM TRYING1");

			while (rs.next()) {
				String s = rs.getString("COF_NAME");
				float n = rs.getFloat("PRICE");
				System.out.println(s + "   " + n);
			}
//			******************************************
//			Scanner s = new Scanner(System.in);
//			
//			System.out.println("Welcome!!");
//			System.out.println("Enter user name:");
//			String username = s.nextLine();
//			System.out.println("Enter password:");
//			String password = s.nextLine();
			
//			now do stuff
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
