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
		System.out.println("    b. Enter Months:");
		String monthsA = s.nextLine();
		
		//When entering part list for Service A, all parts that are
		//required must be input using their part IDs (a sample list will
		//be given separately).
		System.out.println("    c. Enter Parts List:");
		String partsA = s.nextLine();
		
		System.out.println("E. Service B:");
		System.out.println("    a. Enter Miles:");
		int milesB = s.nextInt();
		System.out.println("    b. Enter Months:");
		String monthsB = s.nextLine();
		
		//When entering part list for Service B, only
		//those parts that are different from Service A must be input. 
		System.out.println("    c. Enter Additional Parts:");
		String partsB = s.nextLine();
		
		System.out.println("F. Service F:");
		System.out.println("    a. Enter Miles:");
		int milesC = s.nextInt();
		System.out.println("    b. Enter Months:");
		String monthsC = s.nextLine();
		
		//For Service C, input only those parts that are
		//different from Service B.
		System.out.println("    c. Enter Additional Parts:");
		String partsC = s.nextLine();

		System.out.println("1.Add Car");
		System.out.println("2.Go Back");

		int option = s.nextInt();
		if (option == 1) {
			//if the user chooses 1, save the entered
			//information into database to add a new car model for
			//service. Then go to Manager: Landing page .
			MainApp.functObject.addNewCar(make, model, year, milesA, monthsA, partsA,
					milesB, monthsB, partsB, milesC, monthsC, partsC );
			MainApp.managerLandingPage();
		} else if (option == 2) {
			MainApp.managerLandingPage();
		} else {
			System.out.println("Wrong Input");
		}
		
	}

}
