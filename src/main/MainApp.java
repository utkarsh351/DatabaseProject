package main;

import java.sql.*;
import java.util.Scanner;

import utilities.utilitiesFunctions;

public class MainApp {

	static ResultSet rs = null;
	static connection connObject = new connection();

	static utilitiesFunctions functObject = new utilitiesFunctions();
	static userInfo userInfoObject;

	public static void login() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter user name:");
		String username = s.nextLine();
		System.out.println("Enter password:");
		String password = s.nextLine();

		System.out.println("1.Sign In");
		System.out.println("2.Go Back");

		int option = s.nextInt();
		if (option == 1) {
			boolean ans = functObject.validUser(username, password);
			if (ans == false) {
				System.out.println("Wrong Input");
				login();
			} else {
				userInfoObject = new userInfo(functObject.getRole(username), username);
				if (userInfoObject.role.equals("customer")) {
					customerLandingPage();
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistLandingPage();
				} else if (userInfoObject.role.equals("manager")) {
					managerLandingPage();
				}
			}
		} else if (option == 2) {
			mainMenu();
		} else {
			System.out.println("Wrong Input");
			login();
		}
	}

	public static void signup() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter email:");
		String email = s.nextLine();
		System.out.println("Enter password:");
		String password = s.nextLine();
		System.out.println("Enter name:");
		String name = s.nextLine();
		System.out.println("Enter address:");
		String addr = s.nextLine();
		System.out.println("Enter phone:");
		String phone = s.nextLine();

		System.out.println("1.Sign Up");
		System.out.println("2.Go Back");

		int option = s.nextInt();

		if (option == 1) {
			boolean ans = functObject.createUser(email, password, name, addr, phone);
			if (ans == false) {
				System.out.println("Email already exists");
				signup();
			} else {
				login();
			}
		} else if (option == 2) {
			mainMenu();
		} else {
			System.out.println("Wrong Input");
			signup();
		}
	}

	public static void customerLandingPage() {
		System.out.println("1. Profile");
		System.out.println("2. Register Car");
		System.out.println("3. Service");
		System.out.println("4. Invoices");
		System.out.println("5. Logout");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				customerProfilePage();
			} else if (selected_option.equals("2")) {
				registerCar(userInfoObject.email);
			} else if (selected_option.equals("3")) {
				customerServicePage();
			} else if (selected_option.equals("4")) {
				customerInvoice();
			} else if (selected_option.equals("5")) {

			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void registerCar(String email) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter licence plate:");
		String licencePlate = s.nextLine();
		System.out.println("Enter purchase date: (Format YYYY-MM-DD eg. 2015-12-09)");
		String purchaseDate = s.nextLine();
		System.out.println("Enter make:");
		String make = s.nextLine();
		System.out.println("Enter model:");
		String model = s.nextLine();
		System.out.println("Enter year:(Format YYYY eg. 2018)");
		String year = s.nextLine();
		System.out.println("Enter lastServiceDate: (Format YYYY-MM-DD eg. 2015-12-09)");
		String lastServiceDate = s.nextLine();
		System.out.println("Enter current milage:");
		int currMilage = s.nextInt();

		System.out.println("1.Register");
		System.out.println("2.Cancel");

		while (true) {
			int option = s.nextInt();
			if (option == 1) {
				boolean ans = functObject.addCar(licencePlate, purchaseDate, make, model, year, currMilage,
						lastServiceDate, userInfoObject.email);
				if (ans) {
					customerLandingPage();
				} else {
					System.out.println("Wrong Input");
				}
			} else if (option == 2) {
				if (userInfoObject.role.equals("customer")) {
					customerLandingPage();
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistLandingPage();
				}
			} else {
				System.out.println("Wrong Input");
			}
		}
	}

	// Customer Profile
	public static void customerProfilePage() {
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				customerViewProfilePage(userInfoObject.email);
			} else if (selected_option.equals("2")) {
				customerUpdateProfilePage();
			} else if (selected_option.equals("3")) {
				customerLandingPage();
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void customerViewProfilePage(String email) {
		try {
			ResultSet rs = functObject.getCustomerInfo(email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("id"));
				System.out.println("B. " + rs.getString("name"));
				System.out.println("C. " + rs.getString("addr"));
				System.out.println("D. " + rs.getString("email"));
				System.out.println("E. " + rs.getString("tel"));
				System.out.println("F. ");
				ResultSet rs2 = functObject.getCustomerCars(email);
				while (rs2.next()) {
					String s = rs2.getString("make") + " " + rs2.getString("model");
					System.out.println(s);
				}
			}
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					if (userInfoObject.role.equals("customer")) {
						customerProfilePage();
					} else if (userInfoObject.role.equals("receptionist")) {
						receptionistLandingPage();
					} else if (userInfoObject.role.equals("manager")) {
						managerLandingPage();
					}
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void customerUpdateProfilePage() {
		try {
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("3. Phone Number");
			System.out.println("4. Password");
			System.out.println("5. Go Back");
			Scanner s = new Scanner(System.in);

			while (true) {
				String selected_option = s.nextLine();
				Scanner s2 = new Scanner(System.in);

				if (selected_option.equals("1")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerName(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("2")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerAddress(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("3")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerPhoneNumber(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("4")) {
					String updatedValue = s.nextLine();
					functObject.updateCustomerPassword(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("5")) {
					customerProfilePage();

				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			// e.printStackTrace();
		}
	}

	// Customer Service
	public static void customerServicePage() {
		System.out.println("1. View Service History");
		System.out.println("2. Schedule Service");
		System.out.println("3. Reschedule Service");
		System.out.println("4. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				customerServiceHistoryPage(userInfoObject.email);
			} else if (selected_option.equals("2")) {
				customerScheduleService(userInfoObject.email);
			} else if (selected_option.equals("3")) {
				customerRescheduleServicePage1(userInfoObject.email);
			} else if (selected_option.equals("4")) {
				customerLandingPage();
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void customerServiceHistoryPage(String email) {
		try {
			// ResultSet rs = functObject.getCustomerServiceHistory(userInfoObject.email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("id"));
				System.out.println("B. " + rs.getString("plate_no"));
				System.out.println("C. " + rs.getString("service_type"));
				System.out.println("D. " + rs.getString("mechanic"));
				System.out.println("E. " + rs.getString("start_time"));
				System.out.println("F. " + rs.getString("end_time"));
				System.out.println("G. " + rs.getString("status"));
			}
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					if (userInfoObject.role.equals("customer")) {
						customerLandingPage();
					} else if (userInfoObject.role.equals("receptionist")) {
						receptionistLandingPage();
					}
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void customerScheduleService(String email) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter licence plate:");
		String licencePlate = s.nextLine();
		System.out.println("Enter current milage:");
		int currMilage = s.nextInt();
		System.out.println("Mechanic name:");
		String make = s.nextLine();

		System.out.println("1.Schedule Maintenance");
		System.out.println("2.Schedule Repair");
		System.out.println("3.Go Back");

		Scanner s2 = new Scanner(System.in);
		while (true) {
			String selected_option = s2.nextLine();
			if (selected_option.equals("1")) {
				customerScheduleMaintenancePage1(email);
			} else if (selected_option.equals("2")) {
				customerScheduleRepairPage1(email);
			} else if (selected_option.equals("3")) {
				if (userInfoObject.role.equals("customer")) {
					customerServicePage();
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistLandingPage();
				}
			} else {
				System.out.println("Wrong Input");
			}
		}
	}

	// Customer Maintenance Schedule
	public static void customerScheduleMaintenancePage1(String email) {
		System.out.println("1. Find Service Date");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				customerScheduleMaintenancePage2(email);
				// find two earliest dates
			} else if (selected_option.equals("2")) {
				if (userInfoObject.role.equals("customer")) {
					customerScheduleService(userInfoObject.email);
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistScheduleService();
				}
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void customerScheduleMaintenancePage2(String email) {
		// Display
		// 1. Date 1 available with Mechanic name selected(if selected)
		// 2. Date 2 available with Mechanic name selected(if selected)
		System.out.println("1. Schedule on Date");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				Scanner s2 = new Scanner(System.in);
				while (true) {
					String dateOption = s2.nextLine();

					if (dateOption.equals("1")) {
						// Schedule for date 1

					} else if (dateOption.equals("2")) {
						// Schedule for date 2
					} else {
						System.out.println("Choose a valid option");

					}
				}
			} else if (selected_option.equals("2")) {
				customerScheduleMaintenancePage1(email);
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	// Customer Repair Schedule
	public static void customerScheduleRepairPage1(String email) {
		System.out.println("1. Engine knock");
		System.out.println("2. Car drifts in a particular direction");
		System.out.println("3. Battery does not hold charge");
		System.out.println("4. Black/unclean exhaust");
		System.out.println("5. A/C-Heater not lamps not working");
		System.out.println("6. Headlamps/Taillamps not working");
		System.out.println("7. Check engine light");
		System.out.println("8. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				// create and display diagnostic report showing list of causes and parts needed
				// find two earliest dates
				// send to repair page 2
				// if repair date cannot be found due to insufficient parts, place an order
				// show message to user to try after particular date calculated with expected
				// date of delivery
				// if an existing order can fulfill the requirement, but show a message to the
				// user asking him to try again after a
				// specific date. After showing the message, go back to Customer: Schedule
				// Service page
			} else if (selected_option.equals("2")) {
				// refer to first comment
			} else if (selected_option.equals("3")) {
				// refer to first comment
			} else if (selected_option.equals("4")) {
				// refer to first comment
			} else if (selected_option.equals("5")) {
				// refer to first comment
			} else if (selected_option.equals("6")) {
				// refer to first comment
			} else if (selected_option.equals("7")) {
				// refer to first comment
			} else if (selected_option.equals("8")) {
				if (userInfoObject.role.equals("customer")) {
					customerScheduleService(userInfoObject.email);
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistScheduleService();
				}
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void customerScheduleRepairPage2(String email) {
		// Display
		// 1. Date 1 available with Mechanic name selected(if selected)
		// 2. Date 2 available with Mechanic name selected(if selected)
		System.out.println("1. Repair on Date");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				Scanner s2 = new Scanner(System.in);
				while (true) {
					String dateOption = s2.nextLine();

					if (dateOption.equals("1")) {
						// Schedule for date 1
						// create a new service record for repair service on the
						// chosen date, and go back to Customer:Schedule Service page
					} else if (dateOption.equals("2")) {
						// Schedule for date 2
						// create a new service record for repair service on the
						// chosen date, and go back to Customer:Schedule Service page
					} else {
						System.out.println("Choose a valid option");
					}
				}
			} else if (selected_option.equals("2")) {
				customerScheduleRepairPage1(email);
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	// Customer Reschedule Service
	public static void customerRescheduleServicePage1(String email) {
		// Display
		// 1. License Plate, Service ID, Service Date, Service Type, Service Details
		// 2. License Plate, Service ID, Service Date, Service Type, Service Details
		// etc
		System.out.println("1. Pick a service");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {

				Scanner s2 = new Scanner(System.in);
				while (true) {
					System.out.println("Enter a Service ID:");
					String service_id = s2.nextLine();

					// Check if service_id is valid
//					if (valid(service_id)) {
//						// find two earliest dates
//						customerRescheduleServicePage2();
//					} else {
//						System.out.println("Choose a valid option");
//					}
				}
			} else if (selected_option.equals("2")) {
				if (userInfoObject.role.equals("customer")) {
					customerServicePage();
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistLandingPage();
				}
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void customerRescheduleServicePage2(String email) {
		// Display
		// 1. Date 1 available with Mechanic name selected(if selected)
		// 2. Date 2 available with Mechanic name selected(if selected)
		System.out.println("1. Reschedule Date");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				Scanner s2 = new Scanner(System.in);
				while (true) {
					String dateOption = s2.nextLine();

					if (dateOption.equals("1")) {
						// Schedule for date 1
						// existing service to the chosen date making necessary
						// adjustments to the parts commitment in the inventory, and go
						// back to Customer: Service page

					} else if (dateOption.equals("2")) {
						// Schedule for date 2
						// existing service to the chosen date making necessary
						// adjustments to the parts commitment in the inventory, and go
						// back to Customer: Service page
					} else {
						System.out.println("Choose a valid option");

					}
				}
			} else if (selected_option.equals("2")) {
				customerRescheduleServicePage1(email);
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	// Customer Invoice
	public static void customerInvoice() {
		try {
			// ResultSet rs = functObject.getCustomerServiceHistory(userInfoObject.email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("service_id"));
				System.out.println("B. " + rs.getString("service_start_date"));
				System.out.println("C. " + rs.getString("service_end_date"));
				System.out.println("D. " + rs.getString("plate_no"));
				System.out.println("E. " + rs.getString("service_type"));
				System.out.println("E. " + rs.getString("mechanic_name"));
				System.out.println("E. " + rs.getInt("total_service_cost"));
				System.out.println("F. ");
			}
			System.out.println("1. View Invoice Details");
			System.out.println("2. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					customerViewInvoiceDetails();
				} else if (selected_option.equals("2")) {
					customerLandingPage();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void customerViewInvoiceDetails() {
		try {
			System.out.println("Enter Service ID");
			Scanner s = new Scanner(System.in);
			while (true) {
				String service_id = s.nextLine();

				// if (vaild(service_id)) {
				// ResultSet rs = functObject.getCustomerServiceHistory(userInfoObject.email);
				while (rs.next()) {
					System.out.println("A. " + rs.getString("service_id"));
					System.out.println("B. " + rs.getString("service_start_date"));
					System.out.println("C. " + rs.getString("service_end_date"));
					System.out.println("D. " + rs.getString("plate_no"));
					System.out.println("E. " + rs.getString("service_type"));
					System.out.println("E. " + rs.getString("mechanic_name"));
					System.out.println("E. " + rs.getInt("total_service_cost"));
					System.out.println("F. ");
				}
				break;
				// }
				// else {
				// System.out.println("Choose a valid option");
				// }
			}

			System.out.println("1. Go Back");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String selected_option = s2.nextLine();

				if (selected_option.equals("1")) {
					customerInvoice();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// Manager
	public static void managerLandingPage() {
		try {
			ResultSet rs = functObject.getEmployeeInfo(userInfoObject.email);
			while (rs.next()) {
				userInfoObject.service_centre_id = rs.getString("service_centre_id");
			}
			System.out.println("1. Profile");
			System.out.println("2. View Customer Profile");
			System.out.println("3. Add New Employees");
			System.out.println("4. Payroll");
			System.out.println("5. Inventory");
			System.out.println("6. Orders");
			System.out.println("7. Notifications");
			System.out.println("8. New Car Model");
			System.out.println("9. Car Service Details");
			System.out.println("10. Service History");
			System.out.println("11. Invoices");
			System.out.println("12. Logout");

			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					employeeProfilePage();
				} else if (selected_option.equals("2")) {
					employeeViewCustomerProfilePage();
				} else if (selected_option.equals("3")) {
					managerAddNewEmployees();
				} else if (selected_option.equals("4")) {
					customerInvoice();
				} else if (selected_option.equals("5")) {
					managerInventoryPage();
				} else if (selected_option.equals("6")) {
					ManagerOrder managerOrder = new ManagerOrder();
					managerOrder.managerOrdersPage();
				} else if (selected_option.equals("7")) {
					Notification notification = new Notification();
					notification.notificationPage();
				} else if (selected_option.equals("8")) {
					ManagerNewCarModel newCarModel = new ManagerNewCarModel();
					newCarModel.newCarModelPage();
				} else if (selected_option.equals("9")) {
					ManagerCarServiceDetail carServiceDetails = new ManagerCarServiceDetail();
					carServiceDetails.viewCarServiceDetailsPage();
				} else if (selected_option.equals("10")) {
					ManagerServiceHistory serviceHistory = new ManagerServiceHistory();
					serviceHistory.viewServiceHistoryPage();
				} else if (selected_option.equals("11")) {
					ManagerInvoice invoice = new ManagerInvoice();
					invoice.viewInvoice();
				} else if (selected_option.equals("12")) {
					mainMenu();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void managerAddNewEmployees() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Name:");
		String emp_name = s.nextLine();
		System.out.println("Enter Address:");
		String addr = s.nextLine();
		System.out.println("Enter Email:");
		String email = s.nextLine();
		System.out.println("Enter Phone Number:");
		String tel = s.nextLine();
		System.out.println("Enter Role:");
		String role = s.nextLine();
		System.out.println("Enter start date: (Format YYYY-MM-DD eg. 2015-12-09)");
		String s_date = s.nextLine();
		System.out.println("Enter Compensatiom:");
		int wage = s.nextInt();

		System.out.println("1.Add");
		System.out.println("2.Go Back");

		int option = s.nextInt();
		if (option == 1) {
			functObject.addEmpolyee(emp_name, addr, email, tel, role, s_date, wage, userInfoObject.service_centre_id);
		} else if (option == 2) {
			managerLandingPage();
		} else {
			System.out.println("Wrong Input");
			managerAddNewEmployees();
		}
	}

	public static void managerPayrollPage() {
		try {
			System.out.println("Enter employee ID:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				int employee_id = s2.nextInt();
				if (functObject.doesEmployeeExists(employee_id)) {
					// ResultSet rs = functObject.getEmployeePayrollDetails(userInfoObject.email);
					while (rs.next()) {
						System.out.println("A. " + rs.getString("paycheck_date"));
						System.out.println("B. " + rs.getString("pay_period"));
						System.out.println("C. " + rs.getInt("eid"));
						System.out.println("D. " + rs.getString("name"));
						System.out.println("E. " + rs.getInt("wage"));
						System.out.println("F. " + rs.getString("freq"));
						System.out.println("G. " + rs.getInt("units"));
						System.out.println("H. " + rs.getString("current_earnings"));
						System.out.println("I. " + rs.getString("year_earnings"));
					}
					break;
				} else {
					System.out.println("Enter a valid employee id");
				}
			}
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					managerLandingPage();
				} else {
					System.out.println("Choose a valid option");
				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void managerInventoryPage() {
		try {
			ResultSet rs = functObject.getInventory(userInfoObject.service_centre_id);
			while (rs.next()) {
				System.out.println("A. " + rs.getInt("part_id"));
				System.out.println("B. " + rs.getString("name") + " " + rs.getString("make"));
				System.out.println("C. " + rs.getInt("current_quantity"));
				System.out.println("D. " + rs.getInt("unit_price"));
				System.out.println("E. " + rs.getInt("min_inventory_thold"));
				System.out.println("F. " + rs.getInt("min_order_quantity"));
				System.out.println(" ");
			}
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					managerLandingPage();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// Receptionist
	public static void receptionistLandingPage() {
		System.out.println("1. Profile");
		System.out.println("2. View Customer Profile");
		System.out.println("3. Register Car");
		System.out.println("4. Service History");
		System.out.println("5. Schedule Service");
		System.out.println("6. Reschedule Service");
		System.out.println("7. Invoices");
		System.out.println("8. Daily Task-Update Inventory");
		System.out.println("9. Daily Task-Record Deliveries");
		System.out.println("10. Logout");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				employeeProfilePage();
			} else if (selected_option.equals("2")) {
				employeeViewCustomerProfilePage();
			} else if (selected_option.equals("3")) {
				receptionistRegisterCar();
			} else if (selected_option.equals("4")) {
				receptionistServiceHistoryPage();
			} else if (selected_option.equals("5")) {
				receptionistScheduleService();
			} else if (selected_option.equals("6")) {
				receptionistRescheduleService();
			} else if (selected_option.equals("7")) {
				// add Stuff
			} else if (selected_option.equals("8")) {
				// add Stuff
			} else if (selected_option.equals("9")) {
				// add Stuff
			} else if (selected_option.equals("10")) {
				// add Stuff
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void receptionistRegisterCar() {
		try {
			System.out.println("Enter customer email:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String customer_email = s2.nextLine();
				if (functObject.doesUserExists(customer_email)) {
					registerCar(customer_email);
				} else {
					System.out.println("Enter a valid customer email");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void receptionistServiceHistoryPage() {
		try {
			System.out.println("Enter customer email:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String customer_email = s2.nextLine();
				if (functObject.doesUserExists(customer_email)) {
					customerServiceHistoryPage(customer_email);
				} else {
					System.out.println("Enter a valid customer email");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void receptionistScheduleService() {
		try {
			System.out.println("Enter customer email:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String customer_email = s2.nextLine();
				if (functObject.doesUserExists(customer_email)) {
					customerScheduleService(customer_email);
				} else {
					System.out.println("Enter a valid customer email");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void receptionistRescheduleService() {
		try {
			System.out.println("Enter customer email:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String customer_email = s2.nextLine();
				if (functObject.doesUserExists(customer_email)) {
					customerRescheduleServicePage1(customer_email);
				} else {
					System.out.println("Enter a valid customer email");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// Employee Profile
	public static void employeeProfilePage() {
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				employeeViewProfilePage();
			} else if (selected_option.equals("2")) {
				employeeUpdateProfilePage();
			} else if (selected_option.equals("3")) {
				if (userInfoObject.role.equals("manager")) {
					managerLandingPage();
				} else if (userInfoObject.role.equals("receptionist")) {
					receptionistLandingPage();
				}
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void employeeViewProfilePage() {
		try {
			ResultSet rs = functObject.getEmployeeInfo(userInfoObject.email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("eid"));
				System.out.println("B. " + rs.getString("e_name"));
				System.out.println("C. " + rs.getString("e_addr"));
				System.out.println("D. " + rs.getString("email"));
				System.out.println("E. " + rs.getString("e_tel"));
				System.out.println("F. " + rs.getString("sc_name"));
				System.out.println("G. " + rs.getString("role"));
				System.out.println("H. " + rs.getString("s_date"));
				System.out.println("I. " + rs.getInt("wage") + "$");
				System.out.println("J. " + rs.getString("freq"));
			}
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					employeeProfilePage();
				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void employeeUpdateProfilePage() {
		try {
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("3. Email Address");
			System.out.println("4. Phone Number");
			System.out.println("5. Password");
			System.out.println("6. Go Back");
			Scanner s = new Scanner(System.in);

			while (true) {
				String selected_option = s.nextLine();
				Scanner s2 = new Scanner(System.in);

				if (selected_option.equals("1")) {
					String updatedValue = s.nextLine();
					functObject.updateEmployeeName(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("2")) {
					String updatedValue = s.nextLine();
					functObject.updateEmployeeAddress(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("3")) {
					String updatedValue = s.nextLine();
					functObject.updateEmployeeEmail(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("4")) {
					String updatedValue = s.nextLine();
					functObject.updateEmployeePhoneNumber(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("5")) {
					String updatedValue = s.nextLine();
					functObject.updateEmployeePassword(userInfoObject.email, updatedValue);

				} else if (selected_option.equals("6")) {
					employeeProfilePage();

				} else {
					System.out.println("Choose a valid option");
				}
			}
		} catch (Throwable e) {
			// e.printStackTrace();
		}
	}

	public static void employeeViewCustomerProfilePage() {
		try {
			System.out.println("Enter customer email:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String customer_email = s2.nextLine();
				if (functObject.doesUserExists(customer_email)) {
					customerViewProfilePage(customer_email);
				} else {
					System.out.println("Enter a valid customer email");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void mainMenu() {
		Scanner s = new Scanner(System.in);
		System.out.println("1.Login");
		System.out.println("2.Sign Up");
		System.out.println("3.Exit");

		int option = s.nextInt();

		if (option == 1) {
			login();
		} else if (option == 2) {
			signup();
		} else if (option == 3) {
			return;
		} else {
			System.out.println("Wrong Input");
			mainMenu();
		}
	}

	public static void main(String[] args) {
		try {
//			ResultSet rs = null;
//			
//			connection connObject = new connection();

//			******************************************
//			query like this everywhere
//			connObject.createTable("CREATE TABLE TRYING1 " + "(COF_NAME VARCHAR(32), SUP_ID INTEGER, "
//					+ "PRICE FLOAT, SALES INTEGER, TOTAL INTEGER)");
//			
//			connObject.insertQuery("INSERT INTO TRYING1 " + "VALUES ('Colombian', 101, 7.99, 0, 0)");

//			connObject.insertQuery("INSERT INTO TRYING1 " + "VALUES ('1', 1, 7.99, 0, 0)");

//			rs = connObject.selectQuery("SELECT email FROM Users");
//
//			while (rs.next()) {
//				String s = rs.getString("email");
//				System.out.println(s);
//			}
//			******************************************

//			now do stuff

			mainMenu();

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}