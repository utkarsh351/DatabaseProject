package main;

import java.util.Scanner;

public class ManagerNewCarModel {

	public void newCarModelPage() {
		System.out.println("---MANAGER NEW CAR MODEL PAGE---");
		Scanner s = new Scanner(System.in);
		System.out.println("A. Enter Make:");
		String make = s.nextLine();
		System.out.println("B. Enter Model:");
		String model = s.nextLine();
		System.out.println("C. Enter Year:");
		String year = s.nextLine();
		System.out.println("D. Service A:");
		System.out.println("    a. Enter Miles:");
		int milesA = s.nextInt();
		s.nextLine();
		System.out.println("    b. Enter Months:");
		String monthsA = s.nextLine();
		
		//When entering part list for Service A, all parts that are
		//required must be input using their part IDs (a sample list will
		//be given separately).
		System.out.println("    c. Enter Basic Service Id's List:(Comma separated)");
		String partsA = s.nextLine();
		
		System.out.println("    d. Enter Quantities List:(Comma separated)");
		String quantA = s.nextLine();
		
		System.out.println("E. Service B:");
		System.out.println("    a. Enter Miles:");
		int milesB = s.nextInt();
		s.nextLine();
		System.out.println("    b. Enter Months:");
		String monthsB = s.nextLine();
		
		//When entering part list for Service B, only
		//those parts that are different from Service A must be input. 
		System.out.println("    c. Enter Additional Basic Service Id's:(Comma separated)");
		String partsB = s.nextLine();
		
		System.out.println("    d. Enter Quantities List:(Comma separated) ");
		String quantB = s.nextLine();
		
		System.out.println("F. Service C:");
		System.out.println("    a. Enter Miles:");
		int milesC = s.nextInt();
		s.nextLine();
		System.out.println("    b. Enter Months:");
		String monthsC = s.nextLine();
		
		//For Service C, input only those parts that are
		//different from Service B.
		System.out.println("    c. Enter Additional Basic Service Id's:(Comma separated)");
		String partsC = s.nextLine();
		
		System.out.println("    d. Enter Quantities List:(Comma separated)");
		String quantC = s.nextLine();

		System.out.println("1.Add Car");
		System.out.println("2.Go Back");

		int option = s.nextInt();
		if (option == 1) {
			//if the user chooses 1, save the entered
			//information into database to add a new car model for
			//service. Then go to Manager: Landing page .
			MainApp.functObject.addNewCar(make, model, year, milesA, monthsA, partsA,
					milesB, monthsB, partsB, milesC, monthsC, partsC, quantA, quantB, quantC );
			MainApp.managerLandingPage();
		} else if (option == 2) {
			MainApp.managerLandingPage();
		} else {
			System.out.println("Wrong Input");
		}
		
	}

}
