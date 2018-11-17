package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerCarServiceDetail {

	public void viewCarServiceDetailsPage() {
		try {
			ResultSet rs = MainApp.functObject.getCarServiceDetails();
			/**
			  * Display the following details for all car models registered in
			  * the system followed by the menu.
			  * A. Make
			  * B. Model
			  * C. Year
			  * D. Service
			  * a. Miles
			  * b. List of Basic
				Services
				(Service ID)
				E. Service B
				a. Miles
				b. List of Basic
				Services
				(Service ID)
				F. Service C
				a. Miles
				b. List of Basic
				Services
				(Service ID
			*/
			while (rs.next()) {
				System.out.println("A. " + rs.getString("make"));
				System.out.println("B. " + rs.getString("model"));
				System.out.println("C. " + rs.getString("year"));
			    //TODO
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
