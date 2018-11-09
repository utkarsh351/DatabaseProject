package utilities;

import java.sql.ResultSet;

import main.connection;

public class utilitiesFunctions {
	static ResultSet rs = null;
	connection connObject = new connection();
	
	public static boolean validUser(String username, String password) {
		return true;
	}

	public static boolean createUser(String email, String password, String name, String add, String ph) {
		return true;
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
