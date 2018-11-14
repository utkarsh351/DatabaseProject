package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class Notification {

	public void notificationPage() {
		try {
			ResultSet rs = MainApp.functObject.getNotifications(MainApp.userInfoObject.service_centre_id);
			
			while (rs.next()) {
				System.out.println("A. " + rs.getInt("notification_id"));
				System.out.println("B. " + rs.getString("")); // Notification Date/Time
				System.out.println("C. " + rs.getInt("")); // OrderID
				System.out.println("D. " + rs.getInt("")); // Supplier Name
				System.out.println("E. " + rs.getInt("")); // Expected DeliverDate
				System.out.println("F. " + rs.getInt("")); // Delayed by(# of days)
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
		try {
			ResultSet rs = MainApp.functObject.getOrderHistory(MainApp.userInfoObject.service_centre_id);
			
			while (rs.next()) {
				System.out.println("A. " + rs.getInt("order_id"));
				System.out.println("B. " + rs.getString("")); // Date
				System.out.println("C. " + rs.getInt("")); // Part name
				System.out.println("D. " + rs.getInt("")); // Supplier Name
				System.out.println("E. " + rs.getInt("")); // Purchaser Name
				System.out.println("F. " + rs.getInt("")); // Quantity 
				System.out.println("G. " + rs.getInt("")); // Unit Price
				System.out.println("H. " + rs.getInt("")); // Total Cost
				System.out.println("I. " + rs.getInt("")); // Order Status
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
