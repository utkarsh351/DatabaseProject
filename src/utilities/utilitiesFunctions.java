package utilities;

import java.sql.ResultSet;

import main.connection;

public class utilitiesFunctions {
	static ResultSet rs = null;
	static connection connObject = new connection();

	public static boolean validUser(String username, String password) {
		try {
			rs = connObject.selectQuery(
					"SELECT email FROM Users where email='" + username + "' And " + "password='" + password + "'");
			if (!rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("Wrong Username or password");
			return false;
		}
	}

	// does user exist
	public static boolean doesUserExists(String username) {
		try {
			rs = connObject.selectQuery("SELECT email FROM Users where email='" + username + "'");
			if (!rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Throwable e) {
			System.out.println("Wrong Username");
			return false;
		}

	}
	
	// does Employee exist
		public static boolean doesEmployeeExists(int emp_id) {
			try {
				rs = connObject.selectQuery("SELECT email FROM Employees where eid='" + emp_id + "'");
				if (!rs.next()) {
					return false;
				} else {
					return true;
				}
			} catch (Throwable e) {
				System.out.println("Wrong Username");
				return false;
			}

		}

	public static String getRole(String email) {
		try {
			rs = connObject.selectQuery("SELECT role FROM Employees e where e.email='" + email + "'");
			if (!rs.next()) {
				return "";
			}
			else {
				return rs.getString("role");
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("Wrong Username or password");
			return "";
		}

	}

	public static boolean createUser(String email, String password, String name, String add, String ph) {
		try {
			int ans = connObject.insertQuery("Insert into Users Values('" + email + "','" + password + "')");
			if (ans != 1) {
				System.out.println("Email already exists.");
				return false;
			} else {
				ans = connObject.insertQuery("Insert into Customers(id, email, name, tel, addr, sc_id) Values('1231','"
						+ email + "','" + name + "','" + ph + "','" + add + "','S0001')");
				if (ans != 1) {
					System.out.println("Error occured while adding to customer table!");
					return false;
				} else {
					return true;
				}
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("Error occured!");
			return false;
		}
	}

	public static boolean addCar(String licencePlate, String purchaseDate, String make, String model, String year,
			int currMilage, String lastServiceDate, String email) {
		try {
			rs = connObject.selectQuery(
					"SELECT vehicle_id FROM Vehicles v where v.make='" + make + "' " + "and v.model='" + model + "'");
			int vehicle_id = 0;
			if (!rs.next()) {
				System.out.println("Make Model doesn't exists");
				return false;
			} else {
				vehicle_id = rs.getInt("vehicle_id");
				int ans = 0;
				if (lastServiceDate.equals("")) {
					ans = connObject.insertQuery(
							"Insert into Owns(plate_no, last_rec_mileage, last_repair_date, purchase_date, vehicle_id, email, car_make_year) "
									+ "Values('" + licencePlate + "','" + currMilage + "',NULL, Date '" + purchaseDate
									+ "','" + vehicle_id + "','" + email + "','" + make + "')");
				} else {
					ans = connObject.insertQuery(
							"Insert into Owns(plate_no, last_rec_mileage, last_repair_date, purchase_date, vehicle_id, email, car_make_year) "
									+ "Values('" + licencePlate + "','" + currMilage + "', Date '" + lastServiceDate
									+ "',Date '" + purchaseDate + "','" + vehicle_id + "','" + email + "','" + make
									+ "')");
				}

				if (ans != 1) {
					System.out.println("Error occured while adding to vehicle table!");
					return false;
				} else {
					return true;
				}
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("Error occured!");
			return false;
		}
	}

//	view profile
	public static ResultSet getCustomerInfo(String email) {
		try {
			rs = connObject.selectQuery("SELECT * FROM Customers WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet getCustomerCars(String email) {
		try {
			rs = connObject
					.selectQuery("SELECT * FROM Owns O1 JOIN Vehicles V1 ON O1.vehicle_id=V1.vehicle_id WHERE email='"
							+ email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

//	update customer profile

	public static ResultSet updateCustomerName(String email, String name) {
		try {
			rs = connObject.selectQuery("UPDATE Customers SET name='" + name + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateCustomerPassword(String email, String password) {
		try {
			rs = connObject
					.selectQuery("UPDATE Users SET password='" + password + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateCustomerAddress(String email, String addr) {
		try {
			rs = connObject.selectQuery("UPDATE Customers SET addr='" + addr + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateCustomerPhoneNumber(String email, String tel) {
		try {
			rs = connObject.selectQuery("UPDATE Customers SET tel='" + tel + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

//	register car 
//	check what needs to be done with lastServD exactly
	public static boolean registerCar(String email, String licencePlate, String purD, String make, String model,
			String year, String currMil, String lastServD) {
		return true;
	}

//	view customer history
	public static ResultSet viewCustomerHistory(String email) {
		return rs;
	}

//	schedule customer service based on maintenance and repair and schedule or reschedule, do completely.

//	show all invoices
	public static ResultSet viewInvoices(String email) {
		return rs;
	}

//	show invoices based on service id
	public static ResultSet viewInvoiceById(String email, String serviceId) {
		return rs;
	}

// get Employee info
	public static ResultSet getEmployeeInfo(String email) {
		try {
			rs = connObject.selectQuery(
					"SELECT eid,s_date,service_centre_id,email,E.addr AS e_addr,E.tel AS e_tel ,wage,freq,E.name AS e_name,SC.name AS sc_name FROM Employees E JOIN Service_center SC ON E.service_centre_id=SC.sc_id WHERE email='"
							+ email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

//	update employee profile

	public static ResultSet updateEmployeeName(String email, String name) {
		try {
			rs = connObject.selectQuery("UPDATE Employees SET name='" + name + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateEmployeePassword(String email, String password) {
		try {
			rs = connObject
					.selectQuery("UPDATE Users SET password='" + password + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateEmployeeEmail(String email, String new_email) {
		try {
			rs = connObject.selectQuery("UPDATE Users SET email='" + new_email + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateEmployeeAddress(String email, String addr) {
		try {
			rs = connObject.selectQuery("UPDATE Employees SET addr='" + addr + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

	public static ResultSet updateEmployeePhoneNumber(String email, String tel) {
		try {
			rs = connObject.selectQuery("UPDATE Employees SET tel='" + tel + "' " + "WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

// Manager
	public static void addEmpolyee(String name, String addr, String email, String tel, String role, String s_date,
			int wage, String sc_id) {
		try {
			if (role.equalsIgnoreCase("mechanic")) {
				connObject.insertQuery("Insert into Users(email, password) " + "Values('" + email + "','12345678')");
				connObject.insertQuery(
						"Insert into Employees(name, email, tel, s_date, wage, freq, role, service_centre_id) "
								+ "Values('" + name + "'," + "'" + email + "'," + "'" + tel + "', Date " + "'" + s_date + "',"
								+ "'" + wage + "', 'hour'," + "'" + role + "'," + "'" + sc_id + "')");
			} else if (role.equalsIgnoreCase("receptionist")) {
				connObject.insertQuery("Insert into Users(email, password) " + "Values('" + email + "','12345678')");
				connObject.insertQuery(
						"Insert into Employees(name, email, tel, s_date, wage, freq, role, service_centre_id) "
								+ "Values('" + name + "'," + "'" + email + "'," + "'" + tel + "', Date " + "'" + s_date + "',"
								+ "'" + wage + "', 'month'," + "'" + role + "'," + "'" + sc_id + "')");
			}
			System.out.println("Employee Added Successfully");
		} catch (Throwable e) {
			System.out.println("Error occured!");
		}
	}

	public static int generateNewEmployeeId() {
		try {
			int new_id = 0;
			rs = connObject.selectQuery("SELECT MAX(eid) FROM Employees");
			while (rs.next()) {
				new_id = rs.getInt("max(eid)") + 1;
			}
			return new_id;
		} catch (Throwable e) {
			System.out.println("Wrong Username or password");
			return 0;
		}
	}

	// get Employee info
		public static ResultSet getInventory(String sc_id) {
			try {
				rs = connObject.selectQuery(
						"Select P.part_id AS part_id, P.name, Q.current_quantity," + 
						"Q.unit_price,Q.make,Q.min_inventory_thold,Q.min_order_quantity " + 
						"FROM (SELECT * " + 
						"FROM Inventory I " + 
						"JOIN Parts_to_make PM ON I.parts_to_make_id=PM.parts_to_make_id) Q " + 
						"JOIN Parts P ON P.part_id=Q.part_id " + 
						"WHERE service_center_id='"
								+ sc_id + "'");
				return rs;
			} catch (Throwable e) {
				System.out.println("Wrong Service Center Id");
				return rs;
			}
		}

		public ResultSet getOrderHistory(String service_centre_id) {
			// TODO Auto-generated method stub
			return null;
		}

		public ResultSet getNotifications(String service_centre_id) {
			// TODO Auto-generated method stub
			return null;
		}

		public void addNewCar(String make, String model, String year, int milesA, String monthsA, String partsA,
				int milesB, String monthsB, String partsB, int milesC, String monthsC, String partsC) {
			// TODO Auto-generated method stub
			
		}

		public ResultSet getCarServiceDetails() {
			// TODO Auto-generated method stub
			return null;
		}

		public ResultSet getServiceHistory() {
			// TODO Auto-generated method stub
			return null;
		}

		public ResultSet getInvoiceDetails() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public ResultSet getEmployeePayrollDetails(String email) {
			try {
				rs = connObject.selectQuery(
						"SELECT E.eid, E.name AS e_name, E.wage AS compensation, "
						+ "E.freq, PR.units, PC.start_date, PC.end_date "
						+ "FROM Employees E JOIN Payment_record PR ON E.eid=PR.eid "
						+ "JOIN Payment_cycle PC ON PR.pcid=PC.pcid WHERE email='"
								+ email + "'");
				return rs;
			} catch (Throwable e) {
				System.out.println("Wrong Email");
				return rs;
			}
		}
}
