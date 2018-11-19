package main;

import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Notification {

	public void notificationPage() {
		try {
			ResultSet rs = MainApp.functObject.getNotifications(MainApp.userInfoObject.service_centre_id);

			while (rs.next()) {
				System.out.println("A. Notification ID: " + rs.getInt("notification_id"));
				System.out.println("B. Notification Date: " + rs.getDate("notification_date"));
				System.out.println("C. Order ID: " + rs.getInt("order_id")); // OrderID
				System.out.println("D. Supplier Name: " + rs.getString("supplier")); // Supplier Name
				System.out.println("E. Expected Delivery Date: " + rs.getDate("expected_delivery")); 
				System.out.println("F. Delayed by: " + "days"); // Delayed by(# of days)
			}

			System.out.println("1. Order ID");
			System.out.println("2. Go Back");

			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					viewNotificationsDetailPage();
				} else if (selected_option.equals("2")) {
					MainApp.managerLandingPage();
				} else {
					System.out.println("Invalid input");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void viewNotificationsDetailPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Order ID: ");
		int input;
		while (true) {
			try {
				input = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.print("Invalid input. Please reenter: ");
				scan.nextLine();
			}
		}

		try {
			ResultSet rs = MainApp.functObject.getOrderHistory(MainApp.userInfoObject.service_centre_id);
			while (rs.next()) {

				if (rs.getInt("order_id") == input) {
					System.out.println("A. Order ID: " + rs.getInt("order_id"));
					System.out.println("B. Date: " + rs.getString("order_date"));
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
			}

			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					notificationPage();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
