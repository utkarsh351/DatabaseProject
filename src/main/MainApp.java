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
		if (option == 1) {
			boolean ans = functObject.validUser(username, password);
			if (ans == false) {
				System.out.println("Wrong Input");
				login();
			} else {
				userInfoObject = new userInfo(functObject.getRole(username), username);
				if (userInfoObject.role.equals("customer")) {
					customerLandingPage();
				}
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
		String email = s.nextLine();
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
			boolean ans = functObject.createUser(email, password, name, addr, phone);
			if(ans==false) {
				System.out.println("Email already exists");
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
	
	public static void customerLandingPage() {
		System.out.println("1. Profile");
		System.out.println("2. Register Car");
		System.out.println("3. Service");
		System.out.println("4. Invoices");
		System.out.println("5. Logout");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				customerProfilePage();
			} else if (selected_option.equals("2")) {
				registerCar();
			} else if (selected_option.equals("3")) {

			} else if (selected_option.equals("4")) {

			} else if (selected_option.equals("5")) {

			} else {
				System.out.println("Choose a valid option");
			}
		}
	}
	
	public static void registerCar() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter licence plate:");
		String licencePlate = s.nextLine();
		System.out.println("Enter purchase date: (Format YYYY-MM-DD eg. 2015-12-09)");
		String purchaseDate = s.nextLine();
		System.out.println("Enter make:");
		String make = s.nextLine();
		System.out.println("Enter model:");
		String model = s.nextLine();
		System.out.println("Enter year:(Format YYYY eg. 2018)");
		String year = s.nextLine();
		System.out.println("Enter lastServiceDate: (Format YYYY-MM-DD eg. 2015-12-09)");
		String lastServiceDate = s.nextLine();
		System.out.println("Enter current milage:");
		int currMilage = s.nextInt();
		
		System.out.println("1.Register");
		System.out.println("2.Go Back");
		
		int option = s.nextInt();
		if(option == 1) {
			boolean ans = functObject.addCar(licencePlate, purchaseDate, make, model, year, currMilage, lastServiceDate, userInfoObject.email);
			if(ans) {
				customerLandingPage();
			} else {
				System.out.println("Wrong Input");
				registerCar();
			}
		} else if (option == 2) {
			customerLandingPage();
		} else {
			System.out.println("Wrong Input");
			registerCar();
		}
	}

	public static void customerProfilePage() {
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				customerViewProfilePage();
			} else if (selected_option.equals("2")) {
				customerUpdateProfilePage();
			} else if (selected_option.equals("3")) {
				customerLandingPage();
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void customerViewProfilePage() {
		try {
			ResultSet rs = functObject.getCustomerInfo(userInfoObject.email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("id"));
				System.out.println("B. " + rs.getString("name"));
				System.out.println("C. " + rs.getString("addr"));
				System.out.println("D. " + rs.getString("email"));
				System.out.println("E. " + rs.getString("tel"));
				System.out.println("F. ");
				ResultSet rs2 = functObject.getCustomerCars(userInfoObject.email);
				while (rs2.next()) {
					String s = rs2.getString("make") + " " +  rs2.getString("model");
					System.out.println(s);
				}
				System.out.println("1. Go Back");
				Scanner s = new Scanner(System.in);
				while (true) {
					String selected_option = s.nextLine();

					if (selected_option.equals("1")) {
						customerProfilePage();
					} else {
						System.out.println("Choose a valid option");
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void customerUpdateProfilePage() {
		try {
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("3. Phone Number");
			System.out.println("4. Password");
			System.out.println("5. Go Back");
			Scanner s = new Scanner(System.in);

			while (true) {
				String selected_option = s.nextLine();
				Scanner s2 = new Scanner(System.in);

				if (selected_option.equals("1")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerName(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("2")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerAddress(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("3")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerPhoneNumber(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("4")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerPassword(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("5")) {
					customerProfilePage();

				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			// e.printStackTrace();
		}
	}

	public static void mainMenu() {
		Scanner s = new Scanner(System.in);
		System.out.println("1.Login");
		System.out.println("2.Sign Up");
		System.out.println("3.Exit");

		int option = s.nextInt();

		if (option == 1) {
			login();
		} else if (option == 2) {
			signup();
		} else if (option == 3) {
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