package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerInvoice {

	public void viewInvoice() {
		/**
		Display the following details for all the
		services that are complete at this service center
		followed by the menu.
		A. Service ID
		B. Customer Name
		C. Service Start Date/Time
		D. Service End Date/Time
		E. License Plate
		F. Service Type
		G. Mechanic Name
		H. Parts Used in service with cost of each part
		I. Total labor hours
		J. Labor wages per hour
		K. Total Service Cost
		*/
		try {
			ResultSet rs = MainApp.functObject.getInvoiceDetails();
			while (rs.next()) {
				//TODO
				System.out.println("A. " + rs.getString("service_id"));
				System.out.println("B. " + rs.getString(""));
				System.out.println("C. " + rs.getDate(""));
				System.out.println("D. " + rs.getDate(""));
				System.out.println("E. " + rs.getString(""));
				System.out.println("F. " + rs.getString(""));
				System.out.println("G. " + rs.getString(""));
				System.out.println("H. " + rs.getString(""));
				System.out.println("I. " + rs.getInt(""));
				System.out.println("J. " + rs.getInt(""));
				System.out.println("K. " + rs.getInt(""));
			    
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
