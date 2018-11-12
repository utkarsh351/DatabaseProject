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

	public static String getRole(String email) {
		try {
			rs = connObject.selectQuery("SELECT email FROM Employees e, Manager m where e.email='" + email + "' "
					+ "and m.manager_id=e.eid");
			if (!rs.next()) {
				rs = connObject.selectQuery("SELECT email FROM Employees e, Receptionist r where e.email='" + email
						+ "' " + "and r.receptionist_id=e.eid");
				if (!rs.next()) {
					return "customer";
				} else {
					return "receptionist";
				}
			} else {
				return "manager";
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("Wrong Username or password");
			return "";
		}

	}

	public static boolean createUser(String email, String password, String name, String add, String ph) {
		return true;
	}

//	view profile
	public static ResultSet getCustomerInfo(String email) {
		try {
			rs = connObject.selectQuery("SELECT * FROM Customers where email='" + email);
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}
	
	public static ResultSet getCustomerCars(String email) {
		try {
			rs = connObject.selectQuery("SELECT * FROM Owns O1 JOIN Vehicles V1 ON O1.vehicle_id=V1.vehicle_id where email='" + email);
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}

//	update customer profile
	public static ResultSet updateCustomer(String email, String password, String name, String add, String ph) {
		return rs;
	}
	public static ResultSet updateCustomerName(String email,String name) {
		try {
			rs = connObject.selectQuery("UPDATE Customers SET name=" + name + "WHERE email=" + email);
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}
	public static ResultSet updateCustomerPassword(String email,String password) {
		try {
			rs = connObject.selectQuery("UPDATE Users SET password=" + password + "WHERE email=" + email);
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}
	public static ResultSet updateCustomerAddress(String email, String addr) {
		try {
			rs = connObject.selectQuery("UPDATE Customers SET addr=" + addr + "WHERE email=" + email);
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}
	public static ResultSet updateCustomerPhoneNumber(String email,String tel) {
		try {
			rs = connObject.selectQuery("UPDATE Customers SET tel=" + tel + "WHERE email=" + email);
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
}
