package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerServiceHistory {

	public void viewServiceHistoryPage() {
		try {
			ResultSet rs = MainApp.functObject.getServiceHistory("");
			/**
			Display the following details for all cars that were
			serviced at this service center followed by the menu.
			A. Service ID
			B. Customer Name
			C. License Plate
			D. Service Type
			E. Mechanic Name
			F. Service Start Date/Time
			G. Service End Date/Time(expected or actual)
			H. Service Status (Pending, Ongoing, or Complete)
			*/
			while (rs.next()) {
				//TODO
				System.out.println("A. " + rs.getInt("service_id"));
				System.out.println("B. " + rs.getString(""));
				System.out.println("C. " + rs.getString(""));
				System.out.println("D. " + rs.getString(""));
				System.out.println("E. " + rs.getString(""));
				System.out.println("F. " + rs.getDate(""));
				System.out.println("G. " + rs.getDate(""));
				System.out.println("H. " + rs.getString(""));  
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
