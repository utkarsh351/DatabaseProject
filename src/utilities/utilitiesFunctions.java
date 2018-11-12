package utilities;

import java.sql.ResultSet;

import main.connection;

public class utilitiesFunctions {
	static ResultSet rs = null;
	static connection connObject = new connection();
	
	public static boolean validUser(String username, String password) {
		try {
			rs = connObject.selectQuery("SELECT email FROM Users where email='"+username +"' And "+ "password='"+password+"'");
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
			rs = connObject.selectQuery("SELECT email FROM Employees e, Manager m where e.email='"+email +"' " + "and m.manager_id=e.eid");
			if (!rs.next()) {
				rs = connObject.selectQuery("SELECT email FROM Employees e, Receptionist r where e.email='"+email +"' " + "and r.receptionist_id=e.eid");
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
		try {
			int ans = connObject.insertQuery("Insert into Users Values('"+ email +"','" + password + "')");
			if(ans!=1) {
				System.out.println("Email already exists.");
				return false;
			} else {
				ans = connObject.insertQuery("Insert into Customers(id, email, name, tel, addr, sc_id) Values('1231','"+ email +"','" + name + "','"+ph+"','"+add+"','S0001')");
				if (ans!=1) {
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
	
	public static boolean addCar(String licencePlate, String purchaseDate, String make, String model, String year, int currMilage, String lastServiceDate, String email) {
		try {
			rs = connObject.selectQuery("SELECT vehicle_id FROM Vehicles v where v.make='"+make +"' " + "and v.model='"+model+"'");
			int vehicle_id=0;
			if (!rs.next()) {
				System.out.println("Make Model doesn't exists");
				return false;
			} else {
				vehicle_id = rs.getInt("vehicle_id");
				int ans = 0;
				if(lastServiceDate.equals("")) {
					ans = connObject.insertQuery("Insert into Owns(plate_no, last_rec_mileage, last_repair_date, purchase_date, vehicle_id, email, car_make_year) "
							+ "Values('"+ licencePlate +"','" + currMilage +"',NULL, Date '"+purchaseDate+"','"+vehicle_id+"','"+make+"')");
				} else {
					ans = connObject.insertQuery("Insert into Owns(plate_no, last_rec_mileage, last_repair_date, purchase_date, vehicle_id, email, car_make_year) "
							+ "Values('"+ licencePlate +"','" + currMilage + "', Date '"+ lastServiceDate + "',Date '"+purchaseDate+"','"+vehicle_id+"','"+make+"')");
				}
				
				if (ans!=1) {
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
		return rs;
	}
	
//	update customer profile
	public static ResultSet updateCustomer(String email, String password, String name, String add, String ph) {
		return rs;
	}
	
//	register car 
//	check what needs to be done with lastServD exactly
	public static boolean registerCar(String email, String licencePlate, String purD, String make, 
			String model, String year, String currMil, String lastServD) {
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
