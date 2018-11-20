package main;

import java.sql.*;
import java.util.ArrayList;
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

		while (true) {
			int option = s.nextInt();
			if (option == 1) {
				boolean ans = functObject.validUser(username, password);
				if (ans == false) {
					System.out.println("Wrong Input");
					login();
				} else {
					userInfoObject = new userInfo(functObject.getRole(username), username);
					if (userInfoObject.role.equals("customer")) {
						try {
							ResultSet rs = functObject.getCustomerInfo(userInfoObject.email);
							while (rs.next()) {
								userInfoObject.service_centre_id = rs.getString("sc_id");
							}
							customerLandingPage();
						} catch (Throwable e) {
							e.printStackTrace();
						}
					} else if (userInfoObject.role.equals("receptionist")) {
						try {
							ResultSet rs = functObject.getEmployeeInfo(userInfoObject.email);
							while (rs.next()) {
								userInfoObject.service_centre_id = rs.getString("service_centre_id");
							}
							receptionistLandingPage();
						} catch (Throwable e) {
							e.printStackTrace();
						}
					} else if (userInfoObject.role.equals("manager")) {
						managerLandingPage();
					}
				}
			} else if (option == 2) {
				mainMenu();
			} else {
				System.out.println("Wrong Input");
			}
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
		System.out.println("Enter Service Centre ID:");
		String sc_id = s.nextLine();

		System.out.println("1.Sign Up");
		System.out.println("2.Go Back");

		while (true) {
			int option = s.nextInt();

			if (option == 1) {
				boolean ans = functObject.createUser(email, password, name, addr, phone, sc_id);
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
			}
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
				mainMenu();
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void registerCar(String email) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter license plate:");
		String licensePlate = s.nextLine();
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
				boolean ans = functObject.addCar(licensePlate, purchaseDate, make, model, year, currMilage,
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
					System.out.println("Enter New Name:");
					String updatedValue = s.nextLine();
					functObject.updateCustomerName(userInfoObject.email, updatedValue);
					customerProfilePage();

				} else if (selected_option.equals("2")) {
					System.out.println("Enter New Address:");
					String updatedValue = s.nextLine();
					functObject.updateCustomerAddress(userInfoObject.email, updatedValue);
					customerProfilePage();

				} else if (selected_option.equals("3")) {
					System.out.println("Enter New Phone Number:");
					String updatedValue = s.nextLine();
					functObject.updateCustomerPhoneNumber(userInfoObject.email, updatedValue);
					customerProfilePage();

				} else if (selected_option.equals("4")) {
					System.out.println("Enter New Password:");
					String updatedValue = s.nextLine();
					functObject.updateCustomerPassword(userInfoObject.email, updatedValue);
					customerProfilePage();

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
			ResultSet rs = functObject.getServiceHistory(userInfoObject.email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("schedule_id"));
				System.out.println("B. " + rs.getString("plate_no"));
				if (rs.getString("maintenance_schedule_id") == null) {
					System.out.println("C. Repair-" + rs.getInt("rid"));
				} else {
					System.out.println("C. Maintenance-" + rs.getString("m_type"));
				}
				System.out.println("D. " + rs.getString("name"));
				System.out.println("E. " + rs.getString("start_time"));
				System.out.println("F. " + rs.getString("end_time"));
				System.out.println("G. " + rs.getString("status"));
				System.out.println(" ");
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
		System.out.println("Enter license plate:");
		String licensePlate = s.nextLine();
		System.out.println("Enter current milage:");
		int currMileage = s.nextInt();
		System.out.println("Mechanic name:");
		s.nextLine();
		String mechanicName = s.nextLine();

		System.out.println("1.Schedule Maintenance");
		System.out.println("2.Schedule Repair");
		System.out.println("3.Go Back");

		Scanner s2 = new Scanner(System.in);
		while (true) {
			String selected_option = s2.nextLine();
			if (selected_option.equals("1")) {
				customerScheduleMaintenancePage1(email, licensePlate, currMileage, mechanicName);
			} else if (selected_option.equals("2")) {
				customerScheduleRepairPage1(email, licensePlate, currMileage, mechanicName);
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
	public static void customerScheduleMaintenancePage1(String email, String licensePlate, int currMileage,
			String mechanicName) {
		System.out.println("1. Find Service Date");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				String sType = functObject.getNextMaintenanceType(email, licensePlate, currMileage);
				Timestamp t = functObject.checkForPartsForMaintenanceService(licensePlate, sType,
						userInfoObject.service_centre_id);
				if (t == null) {
					customerScheduleMaintenancePage2(email, licensePlate, currMileage, mechanicName, sType);
				} else {
					System.out.println("Please try again after " + t);
					customerScheduleService(userInfoObject.email);
				}
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

	public static void customerScheduleMaintenancePage2(String email, String licensePlate, int currMileage,
			String mechanicName, String sType) {
		ArrayList<Timestamp> dates = functObject.findMaintenanceScheduleDates(mechanicName, licensePlate, sType);
		System.out.println("1. " + dates.toArray()[0]);
		System.out.println("2. " + dates.toArray()[1]);
		System.out.println("1. Schedule on Date");
		System.out.println("2. Go Back");

		Scanner s = new Scanner(System.in);
		while (true) {
			String selected_option = s.nextLine();

			if (selected_option.equals("1")) {
				Scanner s2 = new Scanner(System.in);
				while (true) {
					System.out.println("Choose date option:");
					String dateOption = s2.nextLine();

					if (dateOption.equals("1")) {
						functObject.addToMaintenanceSchedule((Timestamp) dates.toArray()[0], licensePlate, mechanicName,
								(Timestamp) dates.toArray()[0], sType);
						customerScheduleService(userInfoObject.email);

					} else if (dateOption.equals("2")) {
						functObject.addToMaintenanceSchedule((Timestamp) dates.toArray()[1], licensePlate, mechanicName,
								(Timestamp) dates.toArray()[1], sType);
						customerScheduleService(userInfoObject.email);
					} else {
						System.out.println("Choose a valid option");

					}
				}
			} else if (selected_option.equals("2")) {
				customerScheduleMaintenancePage1(email, licensePlate, currMileage, mechanicName);
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void showDiagnosticReport(ResultSet x) {
		try {
			System.out.print("Service Name");
			System.out.print(" , ");
			System.out.print("Part Name");
			System.out.print(" , ");
			System.out.print("Quantity");
			System.out.print(" , ");
			System.out.print("Repair Name");
			System.out.print(" , ");
			System.out.print("Diagnostic Name");
			System.out.println();
			while (x.next()) {
				System.out.print(x.getString("service_name"));
				System.out.print(" , ");
				System.out.print(x.getString("part_name"));
				System.out.print(" , ");
				System.out.print(x.getInt("quantity"));
				System.out.print(" , ");
				System.out.print(x.getString("repair_name"));
				System.out.print(" , ");
				System.out.print(x.getString("diagnostic_name"));
				System.out.println();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// Customer Repair Schedule
	public static void customerScheduleRepairPage1(String email, String licensePlate, int currMileage,
			String mechanicName) {
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

			if (Integer.parseInt(selected_option)>=1 &&Integer.parseInt(selected_option)<=7) {
				Timestamp t = functObject.checkForPartsForRepairService(licensePlate, selected_option,
						userInfoObject.service_centre_id);
				if (t == null) {
					customerScheduleRepairPage2(email, licensePlate, currMileage, mechanicName, selected_option);
				} else {
					System.out.println("Please try again after " + t);
					customerScheduleService(userInfoObject.email);
				}

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

	public static void customerScheduleRepairPage2(String email, String licensePlate, int currMileage,
			String mechanicName, String repairId) {
		rs = functObject.getDiagnosticReport(licensePlate, repairId);
		showDiagnosticReport(rs);
		ArrayList<Timestamp> dates = functObject.findRepairScheduleDates(mechanicName, licensePlate, repairId);

		System.out.println("1. " + dates.toArray()[0]);
		System.out.println("2. " + dates.toArray()[1]);
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
					System.out.println("Choose date option:");
					String dateOption = s2.nextLine();

					if (dateOption.equals("1")) {
						functObject.addToRepairSchedule((Timestamp) dates.toArray()[0], licensePlate, mechanicName,
								(Timestamp) dates.toArray()[0], repairId);
						customerScheduleService(userInfoObject.email);
					} else if (dateOption.equals("2")) {
						functObject.addToRepairSchedule((Timestamp) dates.toArray()[1], licensePlate, mechanicName,
								(Timestamp) dates.toArray()[1], repairId);
						customerScheduleService(userInfoObject.email);
					} else {
						System.out.println("Choose a valid option");
					}
				}
			} else if (selected_option.equals("2")) {
				customerScheduleRepairPage1(email, licensePlate, currMileage, mechanicName);
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	// Customer Reschedule Service
	public static void customerRescheduleServicePage1(String email) {
		try {
			ResultSet rs = functObject.getCustomerScheduleInfo(userInfoObject.email);
			while (rs.next()) {
				System.out.println("A. " + rs.getString("plate_no"));
				System.out.println("B. " + rs.getString("schedule_id"));
				System.out.println("C. " + rs.getString("start_time"));

				if (rs.getString("maintenance_schedule_id") == null) {
					int repairId = rs.getInt("rid");
					System.out.println("D. Repair-" + repairId);
					System.out.println("E. " + rs.getString("repair_name"));

				} else {
					String mType = rs.getString("m_type");
					System.out.println("D. Maintenance");
					System.out.println("E. " + mType);
				}
				System.out.println(" ");
			}
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
						customerRescheduleServicePage2(userInfoObject.email, service_id);

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
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void customerRescheduleServicePage2(String email, String scheduleId) {
		try {
			ArrayList<Timestamp> dates = null;
			String licensePlate = "";
			String mechanicName = "";
			String id = "";
			String type = functObject.checkRescheduleType(scheduleId);
			rs = functObject.findRecheduleDates(scheduleId,type);
			if (rs.next()) {
				if (type == "M") {
					licensePlate = rs.getString("customer_plate_no");
					mechanicName = rs.getString("name");
					id = rs.getString("m_type");
					dates = functObject.findMaintenanceScheduleDates(mechanicName, licensePlate, id);
				} else if (type == "R") {
					licensePlate = rs.getString("customer_plate_no");
					mechanicName = rs.getString("name");
					id = rs.getString("rid");
					dates = functObject.findRepairScheduleDates(mechanicName, licensePlate, id);
				}

			}

			System.out.println("1. " + dates.toArray()[0]);
			System.out.println("2. " + dates.toArray()[1]);

			System.out.println("1. Reschedule Date");
			System.out.println("2. Go Back");

			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

				if (selected_option.equals("1")) {
					Scanner s2 = new Scanner(System.in);
					while (true) {
						System.out.println("Choose date option:");
						String dateOption = s2.nextLine();

						if (dateOption.equals("1")) {
							if (type == "M") {
								functObject.updateMaintenanceSchedule((Timestamp) dates.toArray()[0], scheduleId, id,
										licensePlate);
								customerServicePage();
							} else if (type == "R") {
								functObject.updateRepairSchedule((Timestamp) dates.toArray()[0], scheduleId, id,
										licensePlate);
								customerServicePage();
							}

						} else if (dateOption.equals("2")) {
							if (type == "M") {
								functObject.updateMaintenanceSchedule((Timestamp) dates.toArray()[1], scheduleId, id,
										licensePlate);
								customerServicePage();
							} else if (type == "R") {
								functObject.updateRepairSchedule((Timestamp) dates.toArray()[1], scheduleId, id,
										licensePlate);
								customerServicePage();
							}
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
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// Customer Invoice
	public static void customerInvoice() {
		try {
			ResultSet rs = functObject.viewInvoices(userInfoObject.email);
			while (rs.next()) {
				int totalCost = 0;
				System.out.println("A. " + rs.getString("schedule_id"));
				System.out.println("B. " + rs.getString("start_time"));
				System.out.println("C. " + rs.getString("end_time"));
				System.out.println("D. " + rs.getString("plate_no"));
				int vehicleId = rs.getInt("vehicle_id");
				if (rs.getString("maintenance_schedule_id") == null) {
					int repairId = rs.getInt("rid");
					System.out.println("E. Repair-" + repairId);
					totalCost = functObject.getTotalCostForRepair(repairId);
					ResultSet rs2 = functObject.getTotalPartsForRepair(repairId, vehicleId);
					while (rs2.next()) {
						int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
						totalCost = totalCost + partCost;
					}
				} else {
					String mType = rs.getString("m_type");
					System.out.println("E. Maintenance-" + mType);
					totalCost = functObject.getTotalCostForMaintenance(vehicleId, mType);
					ResultSet rs2 = functObject.getTotalPartsForMaintenance(mType, vehicleId);
					while (rs2.next()) {
						int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
						totalCost = totalCost + partCost;
					}
				}
				System.out.println("F. " + rs.getString("name"));
				System.out.println("H.Total Cost- " + totalCost);
				System.out.println(" ");
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

				ResultSet rs = functObject.viewInvoiceById(userInfoObject.email, service_id);
				while (rs.next()) {
					int totalCost = 0;
					int totalPartCost = 0;
					float totalTime = 0;
					System.out.println("A. " + rs.getString("schedule_id"));
					System.out.println("B. " + rs.getString("start_time"));
					System.out.println("C. " + rs.getString("end_time"));
					System.out.println("D. " + rs.getString("plate_no"));
					int vehicleId = rs.getInt("vehicle_id");
					if (rs.getString("maintenance_schedule_id") == null) {
						int repairId = rs.getInt("rid");
						System.out.println("E. Repair-" + repairId);
						totalCost = functObject.getTotalCostForRepair(repairId);
						totalTime = functObject.getTotalHoursForRepair(repairId);
						ResultSet rs2 = functObject.getTotalPartsForRepair(repairId, vehicleId);
						System.out.println("F. Parts-");
						while (rs2.next()) {
							int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
							totalCost = totalCost + partCost;
							System.out.println(rs2.getString("name") + "-" + partCost + "$");
						}
					} else {
						String mType = rs.getString("m_type");
						System.out.println("E. Maintenance-" + mType);
						totalCost = functObject.getTotalCostForMaintenance(vehicleId, mType);
						totalTime = functObject.getTotalHoursForMaintenance(vehicleId, mType);
						ResultSet rs2 = functObject.getTotalPartsForMaintenance(mType, vehicleId);
						System.out.println("F. Parts-");
						while (rs2.next()) {
							int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
							totalCost = totalCost + partCost;
							System.out.println(rs2.getString("name") + "-" + partCost + "$");
						}
					}
					System.out.println("G. " + rs.getString("name"));
					System.out.println("H. " + totalTime);
					System.out.println("I. " + rs.getString("wage"));
					System.out.println("J.Total Cost- " + totalCost);
					System.out.println(" ");
				}
				break;
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
					managerPayrollPage();
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
					ResultSet temp = functObject.getEmployeeInfoById(employee_id);
					if(temp.next()) {
						if(temp.getString("role").equals("manager") || temp.getString("role").equals("receptionist")) {
							String name = temp.getString("name");
							String units = "15";
							ResultSet rs = functObject.getEmployeePayrollDetailsForRecepOrManager(employee_id);
							while (rs.next()) {
								System.out.println("A. Paycheck Date: " + rs.getString("end_date"));
								System.out.println("B. Pay Period: " + rs.getDate("start_date") + " to " + rs.getDate("end_date"));
								System.out.println("C. Employee ID: " + employee_id);
								System.out.println("D. Employee Name: " + name);
								System.out.println("E. Compensation ($): " + rs.getInt("compensation"));
								System.out.println("F. Frequency (monthly/hourly): " + rs.getString("freq"));
								System.out.println("G. Units (# of hours/days): " + units);
								System.out.println("H. Earnings (Current): " + rs.getInt("earning_till_date"));
								System.out.println("I. Earnings (Year-to-date): " + rs.getInt("earning_this_year"));
								System.out.println();
							}
						} else {
							String name = temp.getString("name");
							ResultSet rs = functObject.getEmployeePayrollDetailsForMechanic(employee_id);
							while (rs.next()) {
								System.out.println("A. Paycheck Date: " + rs.getString("end_date"));
								System.out.println("B. Pay Period: " + rs.getDate("start_date") + " to " + rs.getDate("end_date"));
								System.out.println("C. Employee ID: " + employee_id);
								System.out.println("D. Employee Name: " + name);
								System.out.println("E. Compensation ($): " + rs.getInt("compensation"));
								System.out.println("F. Frequency (monthly/hourly): hourly");
								System.out.println("G. Units (# of hours/days): " + rs.getInt("total_work_done"));
								System.out.println("H. Earnings (Current): " + rs.getInt("compensation"));
								System.out.println("I. Earnings (Year-to-date): " + rs.getInt("compensation"));
								System.out.println();
							}
						}
						
						break;
					}
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
				receptionistInvoicesPage();
			} else if (selected_option.equals("8")) {
				dailyTaskUpdateInventoryReceptionist();
			} else if (selected_option.equals("9")) {
				dailyTaskRecordDeliveries();
			} else if (selected_option.equals("10")) {
				mainMenu();
			} else {
				System.out.println("Choose a valid option");
			}
		}
	}

	public static void dailyTaskUpdateInventoryReceptionist() {
		boolean ans = functObject.dailyTaskUpdateInventory(userInfoObject.service_centre_id);

		if (ans == true) {
			System.out.println("Daily Task-Update Inventory Successful");
		} else {
			System.out.println("Daily Task-Update Inventory Was Not Successful");
		}

		Scanner s = new Scanner(System.in);
		System.out.println("1. Go Back");

		while (true) {
			String option = s.nextLine();
			if (option.equals("1")) {
				receptionistLandingPage();
			} else {
				System.out.println("Choose a valid option");
			}
		}

	}

	public static void dailyTaskRecordDeliveries() {
		Scanner s = new Scanner(System.in);
		System.out.println("1. Enter Comma Separated Order Ids");
		System.out.println("2. Go Back");
		while (true) {
			String option = s.nextLine();
			if (option.equals("1")) {
				String orderIds = s.nextLine();
				String[] arr = orderIds.split(",");
				for (int i = 0; i < arr.length; i++) {
					arr[i] = arr[i].trim();
				}

				boolean ans = functObject.dailyTaskRecordDeliveries(arr, userInfoObject.service_centre_id);

				if (ans == true) {
					System.out.println("Daily Task-Record Deliveries Successful");
				} else {
					System.out.println("Daily Task-Record Deliveries Was Not Successful");
				}

				receptionistLandingPage();
			} else if (option.equals("2")) {
				receptionistLandingPage();
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

	public static void receptionistInvoicesPage() {
		try {
			System.out.println("Enter customer email:");
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String customer_email = s2.nextLine();
				if (functObject.doesUserExists(customer_email)) {
					ResultSet rs = functObject.viewInvoices(customer_email);
					while (rs.next()) {
						int totalCost = 0;
						int totalPartCost = 0;
						float totalTime = 0;
						System.out.println("A. " + rs.getString("schedule_id"));
						System.out.println("B. " + rs.getString("start_time"));
						System.out.println("C. " + rs.getString("end_time"));
						System.out.println("D. " + rs.getString("plate_no"));
						int vehicleId = rs.getInt("vehicle_id");
						if (rs.getString("maintenance_schedule_id") == null) {
							int repairId = rs.getInt("rid");
							System.out.println("E. Repair-" + repairId);
							totalCost = functObject.getTotalCostForRepair(repairId);
							totalTime = functObject.getTotalHoursForRepair(repairId);
							ResultSet rs2 = functObject.getTotalPartsForRepair(repairId, vehicleId);
							System.out.println("F. Parts-");
							while (rs2.next()) {
								int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
								totalCost = totalCost + partCost;
								System.out.println(rs2.getString("name") + "-" + partCost + "$");
							}
						} else {
							String mType = rs.getString("m_type");
							System.out.println("E. Maintenance-" + mType);
							totalCost = functObject.getTotalCostForMaintenance(vehicleId, mType);
							totalTime = functObject.getTotalHoursForMaintenance(vehicleId, mType);
							ResultSet rs2 = functObject.getTotalPartsForMaintenance(mType, vehicleId);
							System.out.println("F. Parts-");
							while (rs2.next()) {
								int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
								totalCost = totalCost + partCost;
								System.out.println(rs2.getString("name") + "-" + partCost + "$");
							}
						}
						System.out.println("G. " + rs.getString("name"));
						System.out.println("H. " + totalTime);
						System.out.println("I. " + rs.getString("wage"));
						System.out.println("J.Total Cost- " + totalCost);
						System.out.println(" ");
					}
					System.out.println("1. Go Back");
					Scanner s3 = new Scanner(System.in);
					while (true) {
						String selected_option = s3.nextLine();

						if (selected_option.equals("1")) {
							receptionistLandingPage();
						} else {
							System.out.println("Choose a valid option");
						}
					}
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
					System.out.println("Enter New Name:");
					String updatedValue = s.nextLine();
					functObject.updateEmployeeName(userInfoObject.email, updatedValue);
					employeeProfilePage();
				} else if (selected_option.equals("2")) {
					System.out.println("Enter New Address:");
					String updatedValue = s.nextLine();
					functObject.updateEmployeeAddress(userInfoObject.email, updatedValue);
					employeeProfilePage();
				} else if (selected_option.equals("3")) {
					System.out.println("Enter New Email Address:");
					String updatedValue = s.nextLine();
					functObject.updateEmployeeEmail(userInfoObject.email, updatedValue);
					employeeProfilePage();
				} else if (selected_option.equals("4")) {
					System.out.println("Enter New Phone Number:");
					String updatedValue = s.nextLine();
					functObject.updateEmployeePhoneNumber(userInfoObject.email, updatedValue);
					employeeProfilePage();
				} else if (selected_option.equals("5")) {
					System.out.println("Enter New Password:");
					String updatedValue = s.nextLine();
					functObject.updateEmployeePassword(userInfoObject.email, updatedValue);
					employeeProfilePage();
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

		while (true) {
			int option = s.nextInt();
			if (option == 1) {
				login();
			} else if (option == 2) {
				signup();
			} else if (option == 3) {
				System.exit(0);
			} else {
				System.out.println("Wrong Input");
			}
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