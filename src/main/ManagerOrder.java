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
				System.out.println("A. " + rs.getString("order_id"));
				System.out.println("B. " + rs.getString("order_date"));
				System.out.println("C. " + rs.getString("part_name"));
				if (rs.getString("distributor_id") == null) {
					System.out.println("D. Supplier- " + rs.getString("sc_name"));
				} else {
					System.out.println("D. Supplier- " + rs.getString("dname"));
				}
				System.out.println("G. Purchaser" + rs.getString("purchaser_name"));
				int quantity = rs.getInt("quantity");
				int unitPrice = rs.getInt("unit_price");
				System.out.println("H. " + quantity);
				System.out.println("I. " + unitPrice + "$");
				System.out.println("J.Total Cost- " + (quantity * unitPrice));
				System.out.println("H. " + rs.getString("status"));
				System.out.println(" ");
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
		String part_to_make_id = s.nextLine();
		System.out.println("Enter Quantity:");
		int quantity = s.nextInt();

		System.out.println("1. Place Order");
		System.out.println("2. Go Back");

		int option = s.nextInt();
		if (option == 1) { 
			MainApp.functObject.newManagerOrder(part_to_make_id, quantity, MainApp.userInfoObject.service_centre_id);
			managerOrdersPage();
		} else {
			managerOrdersPage();
		}

	}
}
