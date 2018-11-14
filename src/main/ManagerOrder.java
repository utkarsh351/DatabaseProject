package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerOrder {

	public void managerOrdersPage() { 
		System.out.println("---MANAGER ORDERS---");
		System.out.println("1. Order History");
		System.out.println("2. New Order");
		System.out.println("3. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				viewOrderHistory();
			} else if (selected_option.equals("2")) {
				newOrder();
			} else if (selected_option.equals("3")) {
				MainApp.managerLandingPage();
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public void viewOrderHistory() {
		try {
			ResultSet rs = MainApp.functObject.getOrderHistory(MainApp.userInfoObject.service_centre_id);
			
			while (rs.next()) {
				System.out.println("A. " + rs.getInt("order_id"));
				System.out.println("B. " + rs.getDate("order_date")); // Date
				System.out.println("C. " + rs.getString("name")); // Part name
				System.out.println("D. " + rs.getString("")); // Supplier Name
				System.out.println("E. " + rs.getString("")); // Purchaser Name
				System.out.println("F. " + rs.getInt("")); // Quantity 
				System.out.println("G. " + rs.getFloat("")); // Unit Price
				System.out.println("H. " + rs.getInt("")); // Total Cost
				System.out.println("I. " + rs.getString("")); // Order Status
			}
			
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					managerOrdersPage();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void newOrder() {
		System.out.println("---MANAGER: NEW ORDER---");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Part ID:");
		String part_id = s.nextLine();
		System.out.println("Enter Quantity:");
		int quantity = s.nextInt();
		
		System.out.println("1. Place Order");
		System.out.println("2. Go Back");

		int option = s.nextInt();
		if (option == 1) {  //Place order
			//TODO
			//new order record will be created to obtain the part from its authorized
			//distributor. Details such as cost, order date, etc. should be
			//automatically calculated and the order status must be
			//set as “pending”. After placing the order, show a confirmation
			//message with the order ID and estimated date of
			//fulfillment before going back to Manager: Orders Page 
			managerOrdersPage();
		} else {
			managerOrdersPage();
		}

	}
}
