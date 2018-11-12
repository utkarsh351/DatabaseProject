package main;

import java.sql.*;
import java.util.Scanner;

import utilities.utilitiesFunctions;

public class MainApp {
	
	static ResultSet rs = null;
	static connection connObject = new connection();
	
	static utilitiesFunctions functObject = new utilitiesFunctions();
	static userInfo userInfoObject;
	
	public static void login() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter user name:");
		String username = s.nextLine();
		System.out.println("Enter password:");
		String password = s.nextLine();
		
		System.out.println("1.Sign In");
		System.out.println("2.Go Back");
		
		int option = s.nextInt();
		if(option == 1) {
			boolean ans = functObject.validUser(username, password);
			if(ans==false) {
				System.out.println("Wrong Input");
				login();
			} else {
				userInfoObject = new userInfo(functObject.getRole(username), username);
			}
		} else if (option == 2) {
			mainMenu();
		} else {
			System.out.println("Wrong Input");
			login();
		}
	}
	
	public static void signup() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter email:");
		String username = s.nextLine();
		System.out.println("Enter password:");
		String password = s.nextLine();
		System.out.println("Enter name:");
		String name = s.nextLine();
		System.out.println("Enter address:");
		String addr = s.nextLine();
		System.out.println("Enter phone:");
		String phone = s.nextLine();
		
		System.out.println("1.Sign Up");
		System.out.println("2.Go Back");
		
		int option = s.nextInt();
		if(option == 1) {
			boolean ans = functObject.validUser(username, password);
			if(ans==false) {
				System.out.println("Wrong Input");
				signup();
			} else {
				login();
			}
		} else if (option == 2) {
			mainMenu();
		} else {
			System.out.println("Wrong Input");
			signup();
		}
	}
	
	public static void mainMenu() {
		Scanner s = new Scanner(System.in);
		System.out.println("1.Login");
		System.out.println("2.Sign Up");
		System.out.println("3.Exit");
		
		int option = s.nextInt();
		
		if(option == 1) {
			login();
		} else if(option == 2) {
			signup();
		} else if(option == 3) {
			return;
		} else {
			System.out.println("Wrong Input");
			mainMenu();
		}
	}

	public static void main(String[] args) {
		try {
//			ResultSet rs = null;
//			
//			connection connObject = new connection();
			
//			******************************************
//			query like this everywhere
//			connObject.createTable("CREATE TABLE TRYING1 " + "(COF_NAME VARCHAR(32), SUP_ID INTEGER, "
//					+ "PRICE FLOAT, SALES INTEGER, TOTAL INTEGER)");
//			
//			connObject.insertQuery("INSERT INTO TRYING1 " + "VALUES ('Colombian', 101, 7.99, 0, 0)");
			
//			connObject.insertQuery("INSERT INTO TRYING1 " + "VALUES ('1', 1, 7.99, 0, 0)");
			
//			rs = connObject.selectQuery("SELECT email FROM Users");
//
//			while (rs.next()) {
//				String s = rs.getString("email");
//				System.out.println(s);
//			}
//			******************************************
		
			
//			now do stuff
			
			mainMenu();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}