package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerCarServiceDetail {

	public void viewCarServiceDetailsPage() {
		try {
			ResultSet rs = MainApp.functObject.getCarServiceDetails();
			while (rs.next()) {
				int vId = rs.getInt("vehicle_id");
				System.out.println("A. " + rs.getString("make"));
				System.out.println("B. " + rs.getString("model"));
				System.out.println("C. " + rs.getString("car_make_year"));
				ResultSet rs1 = MainApp.functObject.getMaintenanceServicesForCars(vId, "A");
				System.out.println("D. Service A:");
				if (rs1.next()) {
					System.out.println("a.Miles- " + rs1.getString("miles"));
					System.out.println("b.List of Parts-  ");
					System.out.println(rs1.getInt("sid"));
				}				
				while (rs1.next()) {
					System.out.println(rs1.getInt("sid"));
				}
				ResultSet rs2 = MainApp.functObject.getMaintenanceServicesForCars(vId, "B");
				System.out.println("E. Service B:");
				if (rs2.next()) {
					System.out.println("a.Miles- " + rs2.getString("miles"));
					System.out.println("b.List of Parts-  ");
					System.out.println(rs2.getInt("sid"));
				}				
				while (rs2.next()) {
					System.out.println(rs2.getInt("sid"));
				}
				ResultSet rs3 = MainApp.functObject.getMaintenanceServicesForCars(vId, "C");
				System.out.println("F. Service C:");
				if (rs3.next()) {
					System.out.println("a.Miles- " + rs3.getString("miles"));
					System.out.println("b.List of Parts-  ");
					System.out.println(rs3.getInt("sid"));
				}
				while (rs3.next()) {
					System.out.println(rs3.getInt("sid"));
				}
				System.out.println(" ");
			}
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					MainApp.managerLandingPage();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
