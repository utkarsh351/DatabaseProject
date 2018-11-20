package utilities;

import java.sql.ResultSet;
import java.sql.Timestamp;

import main.connection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class utilitiesFunctions {
	static ResultSet rs = null;
	static connection connObject = new connection();
	static connection connObject2 = new connection();
	static connection connObject3 = new connection();

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
				rs = connObject.selectQuery("SELECT * FROM Customers e where e.email='" + email + "'");
				if (!rs.next()) {
					return "";
				} else {
					return "customer";
				}
			} else {
				return rs.getString("role");
			}
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("Wrong Username or password");
			return "";
		}

	}

	public static boolean createUser(String email, String password, String name, String add, String ph, String sc_id) {
		try {
			int ans = connObject.insertQuery("Insert into Users Values('" + email + "','" + password + "')");
			if (ans != 1) {
				System.out.println("Email already exists.");
				return false;
			} else {
				ans = connObject.insertQuery("Insert into Customers(id, email, name, tel, addr, sc_id) Values('1231','"
						+ email + "','" + name + "','" + ph + "','" + add + "','" + sc_id + "')");
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

	public static boolean addCar(String licensePlate, String purchaseDate, String make, String model, String year,
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
									+ "Values('" + licensePlate + "','" + currMilage + "',NULL, Date '" + purchaseDate
									+ "','" + vehicle_id + "','" + email + "','" + make + "')");
				} else {
					ans = connObject.insertQuery(
							"Insert into Owns(plate_no, last_rec_mileage, last_repair_date, purchase_date, vehicle_id, email, car_make_year) "
									+ "Values('" + licensePlate + "','" + currMilage + "', Date '" + lastServiceDate
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

	public static ResultSet getCustomerScheduleInfo(String email) {
		try {
			rs = connObject.selectQuery("SELECT * FROM(SELECT * FROM (SELECT * FROM Owns) W\r\n"
					+ "JOIN Schedule S ON S.customer_plate_no=W.plate_no) X\r\n"
					+ "FULL OUTER JOIN Maintenance_schedule MS ON MS.maintenance_schedule_id=X.schedule_id\r\n"
					+ "FULL OUTER JOIN Repair_schedule RS ON RS.repair_schedule_id=X.schedule_id\r\n" + "WHERE email='"
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
	public static boolean registerCar(String email, String licensePlate, String purD, String make, String model,
			String year, String currMil, String lastServD) {
		return true;
	}

//	schedule customer service based on maintenance and repair and schedule or reschedule, do completely.

//	show all invoices
	public static ResultSet viewInvoices(String email) {
		try {
			rs = connObject.selectQuery("SELECT plate_no,last_rec_mileage, last_repair_date,O.email,O.vehicle_id, "
					+ "schedule_id, start_time,end_time,mechanic_id,status,name,service_centre_id,wage, "
					+ "m_type,maintenance_schedule_id,repair_schedule_id,rid FROM Owns O JOIN (SELECT * FROM (Select * from Schedule S "
					+ "JOIN Employees E " + "ON S.mechanic_id= E.eid " + "WHERE S.status='complete') W "
					+ "FULL OUTER JOIN Maintenance_schedule MS " + "ON W.schedule_id=MS.maintenance_schedule_id "
					+ "\r\n" + "FULL OUTER JOIN Repair_schedule RS " + "ON W.schedule_id=RS.repair_schedule_id) X "
					+ "ON O.plate_no=X.customer_plate_no " + " " + "WHERE O.email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
	}

//	show invoices based on service id
	public static ResultSet viewInvoiceById(String email, String serviceId) {
		try {
			rs = connObject.selectQuery("SELECT plate_no,last_rec_mileage, last_repair_date,O.email,O.vehicle_id, "
					+ "schedule_id, start_time,end_time,mechanic_id,status,name,service_centre_id,wage, "
					+ "m_type,maintenance_schedule_id,repair_schedule_id,rid FROM Owns O JOIN (SELECT * FROM (Select * from Schedule S "
					+ "JOIN Employees E " + "ON S.mechanic_id= E.eid " + "WHERE S.status='complete') W "
					+ "FULL OUTER JOIN Maintenance_schedule MS " + "ON W.schedule_id=MS.maintenance_schedule_id "
					+ "\r\n" + "FULL OUTER JOIN Repair_schedule RS " + "ON W.schedule_id=RS.repair_schedule_id) X "
					+ "ON O.plate_no=X.customer_plate_no " + " " + "WHERE O.email='" + email + "' AND schedule_id='"
					+ serviceId + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
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
	
	public static ResultSet getEmployeeInfoById(int id) {
		try {
			rs = connObject.selectQuery("Select * from Employees E where E.eid="+id);
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
								+ "Values('" + name + "'," + "'" + email + "'," + "'" + tel + "', Date " + "'" + s_date
								+ "'," + "'" + wage + "', 'hour'," + "'" + role + "'," + "'" + sc_id + "')");
			} else if (role.equalsIgnoreCase("receptionist")) {
				connObject.insertQuery("Insert into Users(email, password) " + "Values('" + email + "','12345678')");
				connObject.insertQuery(
						"Insert into Employees(name, email, tel, s_date, wage, freq, role, service_centre_id) "
								+ "Values('" + name + "'," + "'" + email + "'," + "'" + tel + "', Date " + "'" + s_date
								+ "'," + "'" + wage + "', 'month'," + "'" + role + "'," + "'" + sc_id + "')");
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
			rs = connObject.selectQuery("Select P.part_id AS part_id, P.name, Q.current_quantity,"
					+ "Q.unit_price,Q.make,Q.min_inventory_thold,Q.min_order_quantity " + "FROM (SELECT * "
					+ "FROM Inventory I " + "JOIN Parts_to_make PM ON I.parts_to_make_id=PM.parts_to_make_id) Q "
					+ "JOIN Parts P ON P.part_id=Q.part_id " + "WHERE service_center_id='" + sc_id + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Service Center Id");
			return rs;
		}
	}

	public ResultSet getOrderHistory(String service_centre_id) {
		try {
			rs = connObject.selectQuery("SELECT  order_id,order_date,order_expected_delivery_date,order_delivery_date, "
					+ "PM.parts_to_make_id,quantity,requester_center_inventory_id,D.distributor_id, "
					+ "service_center_provider_id,make,P.part_id,unit_price,warranty,P.name AS part_name, "
					+ "dname,SC.name AS sc_name,status,SC2.name AS purchaser_name,SC2.sc_id AS purchaser_id "
					+ "FROM (SELECT O.order_id, order_date,order_expected_delivery_date,order_delivery_date, "
					+ "parts_to_make_id,quantity,status, requester_center_inventory_id,distributor_id, "
					+ "service_center_provider_id FROM Orders O "
					+ "FULL OUTER JOIN Service_center_order SCO ON O.order_id=SCO.order_id "
					+ "FULL OUTER JOIN Distributor_order DO ON O.order_id=DO.order_id) W "
					+ "JOIN Parts_to_make PM ON PM.parts_to_make_id=W.parts_to_make_id "
					+ "JOIN Parts P ON P.part_id=PM.part_id "
					+ "FULL OUTER JOIN Distributor D ON D.distributor_id=W.distributor_id "
					+ "FULL OUTER JOIN Service_center SC ON SC.sc_id =W.service_center_provider_id "
					+ "JOIN Service_center SC2 ON SC2.sc_id =W.requester_center_inventory_id " + "WHERE SC2.sc_id='"
					+ service_centre_id + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Service Center Id");
			return rs;
		}
	}

	public ResultSet getNotifications(String service_centre_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNewCar(String make, String model, String year, int milesA, String monthsA, String partsA, int milesB,
			String monthsB, String partsB, int milesC, String monthsC, String partsC) {
		// TODO Auto-generated method stub

	}

	public ResultSet getCarServiceDetails() {
		try {
			rs = connObject.selectQuery("SELECT * FROM " + "(SELECT V.model,O.car_make_year,make, V.vehicle_id "
					+ "FROM Vehicles V FULL OUTER JOIN Owns O ON V.vehicle_id=O.vehicle_id) W "
					+ "GROUP BY model,car_make_year,make,vehicle_id");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
	}

	public ResultSet getMaintenanceServicesForCars(int vehicleId, String mType) {
		try {
			ResultSet rs = connObject2.selectQuery(
					"SELECT * FROM Maintenance_uses WHERE vehicle_id=" + vehicleId + " AND m_type='" + mType + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
	}

	public ResultSet getServiceHistory(String email) {
		try {
			rs = connObject.selectQuery("SELECT plate_no,last_rec_mileage, last_repair_date,O.email, "
					+ "schedule_id, start_time,mechanic_id,status,name,service_centre_id,end_time, "
					+ "m_type,maintenance_schedule_id,repair_schedule_id,rid FROM Owns O JOIN (SELECT * FROM (Select * from Schedule S "
					+ "JOIN Employees E " + "ON S.mechanic_id= E.eid " + ") W "
					+ "FULL OUTER JOIN Maintenance_schedule MS " + "ON W.schedule_id=MS.maintenance_schedule_id "
					+ "\r\n" + "FULL OUTER JOIN Repair_schedule RS " + "ON W.schedule_id=RS.repair_schedule_id) X "
					+ "ON O.plate_no=X.customer_plate_no " + " " + "WHERE O.email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
	}

	public ResultSet getServiceHistoryForManager(String sc_id) {
		try {
			rs = connObject.selectQuery(
					"SELECT plate_no,last_rec_mileage, last_repair_date,O.email, schedule_id, start_time,mechanic_id,status,name,service_centre_id,"
							+ "m_type,maintenance_schedule_id,repair_schedule_id,rid,end_time, "
							+ "FROM Owns O JOIN (SELECT * FROM (Select * from Schedule S "
							+ "JOIN Employees E ON S.mechanic_id= E.eid) W "
							+ "FULL OUTER JOIN Maintenance_schedule MS "
							+ "ON W.schedule_id=MS.maintenance_schedule_id " + "FULL OUTER JOIN Repair_schedule RS "
							+ "ON W.schedule_id=RS.repair_schedule_id) X " + "ON O.plate_no=X.customer_plate_no "
							+ "WHERE X.service_centre_id='" + sc_id + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
	}

	public ResultSet getInvoiceDetails(String scId) {
		try {
			rs = connObject.selectQuery("SELECT plate_no,last_rec_mileage, last_repair_date,O.email,O.vehicle_id, "
					+ "schedule_id, start_time,end_time,mechanic_id,status,name,service_centre_id,wage, "
					+ "m_type,maintenance_schedule_id,repair_schedule_id,rid FROM Owns O JOIN (SELECT * FROM (Select * from Schedule S "
					+ "JOIN Employees E " + "ON S.mechanic_id= E.eid " + "WHERE S.status='complete') W "
					+ "FULL OUTER JOIN Maintenance_schedule MS " + "ON W.schedule_id=MS.maintenance_schedule_id "
					+ "\r\n" + "FULL OUTER JOIN Repair_schedule RS " + "ON W.schedule_id=RS.repair_schedule_id) X "
					+ "ON O.plate_no=X.customer_plate_no " + " " + "WHERE service_centre_id='" + scId + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Error");
			return rs;
		}
	}

// Schedule
	public static ResultSet getLastMaintenanceType(String licensePlate) {
		try {
			rs = connObject.selectQuery(
					"Select S2.m_type, S2.last_rec_mileage FROM ( Select M.m_type, S.start_time, O.last_rec_mileage from Maintenance_schedule M, Schedule S, Owns O WHERE O.plate_no=S.customer_plate_no AND S.schedule_id=M.maintenance_schedule_id AND S.customer_plate_no ='"
							+ licensePlate + "') S2 WHERE ROWNUM=1 ORDER BY S2.start_time DESC");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return rs;
		}
	}

	public static ResultSet getVehicleMaintenanceTypeDetails(String licensePlate, String serviceType) {
		try {
			rs = connObject.selectQuery(
					"select M2.miles from Owns O, (select DISTINCT m_type, vehicle_id, miles from Maintenance_uses) M2 where O.plate_no = '"
							+ licensePlate + "' AND M2.vehicle_id = O.vehicle_id AND M2.M_type = '" + serviceType
							+ "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return rs;
		}
	}

	public static ResultSet getMechanicByName(String mechanicName) {
		try {
			rs = connObject
					.selectQuery("SELECT * FROM Employees where name='" + mechanicName + "' AND role ='mechanic'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Mechanic Name");
			return rs;
		}
	}

	public static Timestamp checkForPartsForMaintenanceService(String licensePlate, String serviceType, String scId) {
		try {
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
			boolean hasMissingPart = false;
			ResultSet rs = connObject.selectQuery(
					"SELECT T3.quantity - Inv.current_quantity as shortage, Inv.uncommited_current_quantity,T11.sc_id, T3.part_id, T3.Parts_to_make_id, Inv.current_quantity, Inv.min_inventory_thold, Inv.min_order_quantity, T3.quantity FROM Inventory Inv, "
							+ "(SELECT PM.Parts_to_make_id, T2.part_id, T2.quantity FROM Parts_to_make PM, "
							+ "(SELECT I.part_id, I.quantity, I.vehicle_id, T1.m_type, T1.make FROM Involves I, "
							+ "(SELECT MU.sid, MU.vehicle_id, MU.m_type, V.make FROM Owns O, Maintenance_uses MU, Vehicles V "
							+ "WHERE O.plate_no = '" + licensePlate + "' AND " + "O.vehicle_id = MU.vehicle_id AND "
							+ "MU.m_type='" + serviceType + "' AND " + "V.vehicle_id = O.vehicle_id) T1 "
							+ "WHERE I.service_id = T1.sid AND " + "T1.vehicle_id = I.vehicle_id) T2 "
							+ "WHERE T2.part_id=Pm.part_id AND " + "T2.make = PM.make) T3, "
							+ "(SELECT C1.sc_id from Customers C1, Owns O1 WHERE O1.plate_no = '" + licensePlate
							+ "' AND O1.email = C1.email) T11 " + "WHERE "
							+ "T3.Parts_to_make_id = Inv.Parts_to_make_id AND " + "T11.sc_id=Inv.service_center_id "
							+ "AND T3.quantity > Inv.uncommited_current_quantity");
			while (rs.next()) {
				hasMissingPart = true;
				Timestamp t2 = checkExistingOrders(rs.getString("parts_to_make_id"), scId, rs.getInt("shortage"));
				if (compareTwoTimeStamps(t, t2) > 0) {
					t = t2;
				}
			}
			if (!hasMissingPart) {
				t = null;
			}
			return t;
		} catch (Throwable e) {
			System.out.println("Wrong values");
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
			return t;
		}
	}

	public static Timestamp checkForPartsForRepairService(String licensePlate, String repairId, String scId) {
		try {
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
			boolean hasMissingPart = false;
			ResultSet rs = connObject.selectQuery(
					"SELECT T11.sc_id, T3.part_id, T3.Parts_to_make_id, Inv.current_quantity, Inv.min_inventory_thold, Inv.min_order_quantity, T3.quantity FROM Inventory Inv, "
							+ "(SELECT PM.Parts_to_make_id, T2.part_id, T2.quantity FROM Parts_to_make PM, "
							+ "(SELECT I.part_id, I.quantity, I.vehicle_id, T1.make FROM Involves I, "
							+ "(SELECT RU.sid, V.make, O.vehicle_id from Repair_uses RU, Vehicles V, Owns O " + "Where "
							+ "RU.rid='" + repairId + "' AND " + "V.vehicle_id = O.vehicle_id AND " + "O.plate_no = '"
							+ licensePlate + "') T1 " + "WHERE I.service_id = T1.sid AND "
							+ "T1.vehicle_id = I.vehicle_id) T2 " + "WHERE T2.part_id=Pm.part_id AND "
							+ "T2.make = PM.make) T3, "
							+ "(SELECT C1.sc_id from Customers C1, Owns O1 WHERE O1.plate_no = '" + licensePlate
							+ "' AND O1.email = C1.email) T11 " + "WHERE "
							+ "T3.Parts_to_make_id = Inv.Parts_to_make_id AND " + "T11.sc_id=Inv.service_center_id AND "
							+ "T3.quantity > Inv.UNCOMMITED_CURRENT_QUANTITY");
			while (rs.next()) {
				hasMissingPart = true;
				Timestamp t2 = checkExistingOrders(rs.getString("parts_to_make_id"), scId, rs.getInt("shortage"));
				if (compareTwoTimeStamps(t, t2) > 0) {
					t = t2;
				}
			}
			if (!hasMissingPart) {
				t = null;
			}
			return t;
		} catch (Throwable e) {
			System.out.println("Wrong values");
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
			return t;
		}
	}

	public static Timestamp checkExistingOrders(String parts_to_make_id, String scId, int shortage) {
		try {
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
			String supplierId = "";
			rs = connObject2.selectQuery(
					"SELECT O.quantity, O.parts_to_make_id, O.order_expected_delivery_date FROM Orders O WHERE O.status = 'pending' AND O.parts_to_make_id ='"
							+ parts_to_make_id + "' AND rownum = 1 ORDER BY O.order_expected_delivery_date DESC");
			if (rs.next()) {
				return new java.sql.Timestamp(rs.getDate("order_expected_delivery_date").getTime());
			}
			rs = connObject2.selectQuery("SELECT service_center_id FROM Inventory I WHERE I.parts_to_make_id='"
					+ parts_to_make_id + "' AND I.service_center_id <> '" + scId + "' AND I.current_quantity>1");
			supplierId = rs.getString("service_center_id");
			if (rs.next()) {
				int ans = connObject2.insertQuery("Insert into Orders Values(" + "1, " + "Date '" + sqlDate + "', "
						+ "Date '" + sqlDate + "' + interval '1' day, " + "Null, " + parts_to_make_id + ", " + shortage
						+ ", " + "'pending', " + "'" + scId + "')");

				rs = connObject2.selectQuery("SELECT O.order_id,O.order_expected_delivery_date FROM Orders O WHERE "
						+ "O.order_date = Date '" + sqlDate + "' AND O.parts_to_make_id = '" + parts_to_make_id
						+ "' AND " + "O.status = 'pending' AND " + "O.requester_center_inventory_id = '" + scId + "'");

				if (rs.next()) {
					t = new java.sql.Timestamp(rs.getDate("order_expected_delivery_date").getTime());
					connObject2.insertQuery("Insert into Service_center_order values(1, " + "'" + supplierId + "', "
							+ rs.getInt("order_id") + ")");
					return t;
				}
			}
			// order from dist

			rs = connObject2.selectQuery("SELECT distributor_id FROM Supplies WHERE parts_to_make_id='"
					+ parts_to_make_id + "' AND window IS NOT NULL");
			supplierId = rs.getString("distributor_id");
			if (rs.next()) {
				int ans = connObject2.insertQuery("Insert into Orders Values(" + "1, " + "Date '" + sqlDate + "', "
						+ "Date '" + sqlDate + "' + interval '1' day, " + "Null, " + parts_to_make_id + ", " + shortage
						+ ", " + "'pending', " + "'" + scId + "')");

				rs = connObject2.selectQuery("SELECT O.order_id,O.order_expected_delivery_date FROM Orders O WHERE "
						+ "O.order_date = Date '" + sqlDate + "' AND O.parts_to_make_id = '" + parts_to_make_id
						+ "' AND " + "O.status = 'pending' AND " + "O.requester_center_inventory_id = '" + scId + "'");

				if (rs.next()) {
					t = new java.sql.Timestamp(rs.getDate("order_expected_delivery_date").getTime());
					connObject2.insertQuery("Insert into Distributor_order values(1, " + "'" + supplierId + "', "
							+ rs.getInt("order_id") + ")");
					return t;
				}
			}
			return t;
		} catch (Throwable e) {
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
			System.out.println("Wrong values");
			return t;
		}
	}

	public static ArrayList<Timestamp> findMaintenanceScheduleDates(String mechanic_name, String plate_no,
			String m_type) {
		try {
			ArrayList<Timestamp> arr = new ArrayList<>();
			int day_increment = 1;
			int mechanic_id = 0;
			String s3 = "";
			if (!mechanic_name.equals("")) {
				rs = getMechanicByName(mechanic_name);
				if (rs.next()) {
					mechanic_id = rs.getInt("eid");
					s3 = "AND mechanic_id='" + mechanic_id + "'";
				}
			}

			long totalTime = 0;
			if (m_type.equals("A")) {
				totalTime = getTotalTimeForMaintenance(plate_no, "A");
			} else if (m_type.equals("B")) {
				totalTime = getTotalTimeForMaintenance(plate_no, "A") + getTotalTimeForMaintenance(plate_no, "B");
			} else if (m_type.equals("C")) {
				totalTime = getTotalTimeForMaintenance(plate_no, "A") + getTotalTimeForMaintenance(plate_no, "B")
						+ getTotalTimeForMaintenance(plate_no, "C");
			}

			java.util.Date utilDate = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(utilDate);
			cal.add(Calendar.DATE, day_increment);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.set(Calendar.HOUR_OF_DAY, 4);
			Timestamp date1 = null;
			Timestamp date2 = null;
			while (day_increment <= 10) {
				String s1 = new java.sql.Timestamp(cal.getTimeInMillis()).toString();
				cal.set(Calendar.HOUR_OF_DAY, 19);
				String s2 = new java.sql.Timestamp(cal.getTimeInMillis()).toString();
				rs = connObject.selectQuery(
						"select S.start_time, S.end_time, S.mechanic_id from Schedule S WHERE S.start_time >= TIMESTAMP '" + s1
								+ "' AND S.end_time < TIMESTAMP '" + s2 + "'" + s3 + " ORDER BY start_time DESC");
				if (rs.next()) {
					Timestamp endTime = getTimeInTimestampInSlots(rs.getTimestamp("end_time"), rs.getTimestamp("start_time"));
					if (compareTwoTimeStamps(endTime,
							new java.sql.Timestamp(cal.getTimeInMillis())) >= totalTime) {
						if (date1 == null) {
							date1 = endTime;
						} else {
							date2 = endTime;
							break;
						}
					}
				} else {
					cal.set(Calendar.HOUR_OF_DAY, 8);
					Timestamp t1 = new java.sql.Timestamp(cal.getTimeInMillis());
					if (date1 == null) {
						date1 = t1;
					} else {
						date2 = t1;
						break;
					}
				}
				cal.add(Calendar.DATE, day_increment);
				// apply scheduling instead of the current greedy approach
			}
			arr.add(date1);
			arr.add(date2);

			return arr;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return new ArrayList<>();
		}
	}

	public static ArrayList<Timestamp> findRepairScheduleDates(String mechanic_name, String plate_no,
			String repair_id) {
		try {
			ArrayList<Timestamp> arr = new ArrayList<>();
			int day_increment = 1;
			int mechanic_id = 0;
			String s3 = "";
			if (!mechanic_name.equals("")) {
				rs = getMechanicByName(mechanic_name);
				if (rs.next()) {
					mechanic_id = rs.getInt("eid");
					s3 = "AND mechanic_id='" + mechanic_id + "'";
				}
			}

			long totalTime = 0;
			totalTime = getTotalTimeForRepair(repair_id);

			java.util.Date utilDate = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(utilDate);
			cal.add(Calendar.DATE, day_increment);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.set(Calendar.HOUR_OF_DAY, 4);
			Timestamp date1 = null;
			Timestamp date2 = null;
			while (day_increment <= 10) {
				String s1 = new java.sql.Timestamp(cal.getTimeInMillis()).toString();
				cal.set(Calendar.HOUR_OF_DAY, 19);
				String s2 = new java.sql.Timestamp(cal.getTimeInMillis()).toString();
				rs = connObject.selectQuery(
						"select S.start_time,S.end_time,S.mechanic_id from Schedule S WHERE S.start_time >= TIMESTAMP '" + s1
								+ "' AND S.end_time < TIMESTAMP '" + s2 + "'" + s3 + " ORDER BY start_time DESC");
				if (rs.next()) {
					Timestamp endTime = getTimeInTimestampInSlots(rs.getTimestamp("end_time"), rs.getTimestamp("start_time"));
					if (compareTwoTimeStamps(endTime,
							new java.sql.Timestamp(cal.getTimeInMillis())) >= totalTime) {
						if (date1 == null) {
							date1 = endTime;
						} else {
							date2 = endTime;
							break;
						}
					}
				} else {
					cal.set(Calendar.HOUR_OF_DAY, 8);
					Timestamp t1 = new java.sql.Timestamp(cal.getTimeInMillis());
					if (date1 == null) {
						date1 = t1;
					} else {
						date2 = t1;
						break;
					}
				}
				cal.add(Calendar.DATE, day_increment);
				// apply scheduling instead of the current greedy approach

			}

			arr.add(date1);
			arr.add(date2);

			return arr;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return new ArrayList<>();
		}
	}

	public static ResultSet findRecheduleDates(String schedule_id) {
		try {
			ResultSet rs = connObject.selectQuery("SELECT * FROM (SELECT * FROM Schedule WHERE schedule_id="
					+ schedule_id + ") W " + "JOIN Maintenance_schedule MS ON MS.maintenance_schedule_id= W.schedule_id"
					+ "JOIN Employees E ON E.eid=W.mechanic_id");
			if (rs.next()) {
				return rs;
			}

			rs = connObject.selectQuery("SELECT * FROM (SELECT * FROM Schedule WHERE schedule_id=" + schedule_id
					+ ") W " + "JOIN Repair_schedule RS ON RS.repair_schedule_id= W.schedule_id"
					+ "JOIN Employees E ON E.eid=W.mechanic_id");
			if (rs.next()) {
				return rs;
			}
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return rs;
		}
	}
	
	public static String checkRescheduleType(String schedule_id) {
		try {
			ResultSet rs = connObject.selectQuery("SELECT * FROM (SELECT * FROM Schedule WHERE schedule_id="
					+ schedule_id + ") W " + "JOIN Maintenance_schedule MS ON MS.maintenance_schedule_id= W.schedule_id"
					+ "JOIN Employees E ON E.eid=W.mechanic_id");
			if (rs.next()) {
				return "M";
			}

			rs = connObject.selectQuery("SELECT * FROM (SELECT * FROM Schedule WHERE schedule_id=" + schedule_id
					+ ") W " + "JOIN Repair_schedule RS ON RS.repair_schedule_id= W.schedule_id"
					+ "JOIN Employees E ON E.eid=W.mechanic_id");
			if (rs.next()) {
				return "R";
			}
			return "";
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return "";
		}
	}

	public static int addToSchedule(Timestamp start_time, String licensePlate, String mechanic_name,
			Timestamp end_time) {
		try {
			int mechanic_id = 0;
			if (!mechanic_name.equals("")) {
				rs = getMechanicByName(mechanic_name);
				if (rs.next()) {
					mechanic_id = rs.getInt("eid");
				}
			}
			int ans = connObject.insertQuery("INSERT into Schedule " + "Values(" + "'1', " + "TIMESTAMP '" + start_time
					+ "', " + "'" + licensePlate + "', " + mechanic_id + ", " + "'pending', " + "TIMESTAMP '" + end_time
					+ "')");
			return ans;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return -1;
		}
	}

	public static int addToMaintenanceSchedule(Timestamp start_time, String licensePlate, String mechanic_name,
			Timestamp end_time, String mType) {
		try {
			int ans = addToSchedule(start_time, licensePlate, mechanic_name, end_time);
			if (ans == 1) {
				rs = connObject.selectQuery(
						"SELECT * FROM Schedule WHERE schedule_id=(SELECT MAX(schedule_id) FROM Schedule)");
				if (rs.next()) {
					String scheduleId = rs.getString("schedule_id");

					updateEndTimeForMaintenanceInSchedule(licensePlate, mType, scheduleId);

					ans = connObject.insertQuery(
							"INSERT into Maintenance_schedule " + "Values('" + scheduleId + "', '" + mType + "')");
				}
			}
			return ans;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return -1;
		}
	}

	public static int addToRepairSchedule(Timestamp start_time, String licensePlate, String mechanic_name,
			Timestamp end_time, String repairId) {
		try {
			int ans = addToSchedule(start_time, licensePlate, mechanic_name, end_time);
			if (ans == 1) {
				rs = connObject.selectQuery(
						"SELECT * FROM Schedule WHERE schedule_id=(SELECT MAX(schedule_id) FROM Schedule)");
				if (rs.next()) {
					String scheduleId = rs.getString("schedule_id");

					updateEndTimeForRepairInSchedule(repairId,scheduleId);
					ans = connObject.insertQuery(
							"INSERT into Repair_schedule " + "Values('" + scheduleId + "', '" + repairId + "')");
				}
			}
			return ans;
		} catch (Throwable e) {
			System.out.println("Wrong License Plate");
			return -1;
		}
	}

	public static String getNextMaintenanceType(String email, String licensePlate, int currMileage) {
		try {
			int mid1, mid2;
			int A = 0, B = 0, C = 0;
			ResultSet a = getVehicleMaintenanceTypeDetails(licensePlate, "A");
			if (a.next()) {
				A = a.getInt("miles");
			}
			ResultSet b = getVehicleMaintenanceTypeDetails(licensePlate, "B");
			if (b.next()) {
				B = b.getInt("miles");
			}
			ResultSet c = getVehicleMaintenanceTypeDetails(licensePlate, "C");
			if (c.next()) {
				C = c.getInt("miles");
			}
			rs = getLastMaintenanceType(licensePlate);

			if (rs.next()) {
				if (rs.getString("m_type").equals("A")) {
					mid1 = (rs.getInt("last_rec_mileage") + B + (rs.getInt("last_rec_mileage") + B + C)) / 2;
					if (currMileage <= mid1) {
						return "B";
					} else if (currMileage > mid1) {
						return "C";
					}
				} else if (rs.getString("m_type").equals("B")) {
					return "C";
				} else if (rs.getString("m_type").equals("C")) {
					mid1 = (rs.getInt("last_rec_mileage") + A + (rs.getInt("last_rec_mileage") + A + B)) / 2;
					mid2 = (rs.getInt("last_rec_mileage") + A + B + (rs.getInt("last_rec_mileage") + A + B + C)) / 2;
					if (currMileage <= mid1) {
						return "A";
					} else if (currMileage > mid1 && currMileage <= mid2) {
						return "B";
					} else if (currMileage > mid2) {
						return "C";
					}
				}
			} else {
				mid1 = (A + (A + B)) / 2;
				mid2 = (A + B + (A + B + C)) / 2;
				if (currMileage <= mid1) {
					return "A";
				} else if (currMileage > mid1 && currMileage <= mid2) {
					return "B";
				} else if (currMileage > mid2) {
					return "C";
				}
			}
			return "";
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return "";
		}
	}

	public static Timestamp getTimeInTimestampInSlots(Timestamp endTime, Timestamp startTime) {
		long endTimeInMilliSeconds = endTime.getTime();
		long startTimeInMilliSeconds = startTime.getTime();
		
		long diff = endTimeInMilliSeconds - startTimeInMilliSeconds;
		
		float min = diff / (60*1000);
		float hours = diff / (60*60*1000);
		
		if(min>59) {
			hours = (int)Math.floor(min/60);
			min = min - (hours*60);
		}

		if (min < 30 && min > 0) {
			min = 30;
		} else if (min > 30 && min <= 59) {
			min = 0;
			hours += 1;
		}

		long newTime = (long) (((hours * 60 * 60) + (min * 60)) * 1000) + startTimeInMilliSeconds;
		return new java.sql.Timestamp(newTime);
	}
	
	public static long getTimeInMilliSeconds(float totalTime) {
		int hours = (int) totalTime;
		float minutes = totalTime - (int) totalTime;

		return (long) (((hours * 60 * 60) + (minutes * 60 * 60)) * 1000);
	}

	public static long getTotalTimeForMaintenance(String plate_no, String m_type) {
		try {
			String s1 = "";
			String s2 = "";
			if (m_type == "B") {
				s1 = " OR MU.m_type='B'";
			} else if (m_type == "C") {
				s1 = " OR MU.m_type='B'";
				s2 = " OR MU.m_type='A'";
			}
			rs = connObject.selectQuery("Select sum(hours_to_complete) as sum from Service S, "
					+ "(SELECT MU.sid, MU.vehicle_id, MU.m_type FROM Owns O, Maintenance_uses MU, Vehicles V WHERE O.plate_no = '"
					+ plate_no + "' AND O.vehicle_id = MU.vehicle_id AND (MU.m_type='" + m_type + "'" + s1 + s2
					+ ") AND V.vehicle_id = O.vehicle_id ) T1  where S.sid = T1.sid");
			if (!rs.next()) {
				return 0;
			} else {
				return getTimeInMilliSeconds(rs.getFloat("sum"));
			}
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return 0;
		}
	}

	public static int getTotalCostForMaintenance(int vehicle_id, String m_type) {
		try {
			String s1 = "";
			String s2 = "";
			if (m_type == "B") {
				s1 = " OR m_type='B'";
			} else if (m_type == "C") {
				s1 = " OR m_type='B'";
				s2 = " OR m_type='A'";
			}
			ResultSet rs = connObject2.selectQuery(
					"SELECT SUM(CT.rate* hours_to_complete) AS total_cost FROM (SELECT * FROM Maintenance_uses MU "
							+ "JOIN Service S ON S.sid = MU.sid " + "WHERE vehicle_id=" + vehicle_id + " AND (m_type='"
							+ m_type + "'" + s1 + s2 + ")) W " + "JOIN Charge_type CT ON CT.charge_type=W.charge_type");
			if (!rs.next()) {
				return 0;
			} else {
				return rs.getInt("total_cost");
			}
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return 0;
		}
	}

	public static int getTotalCostForRepair(int repair_id) {
		try {
			int repairCost = 0;
			int diagnosticCost = 0;
			ResultSet rs = connObject2.selectQuery(
					"SELECT SUM(CT.rate* hours_to_complete) AS total_cost FROM (SELECT * FROM Repair_uses RU "
							+ "JOIN Service S ON S.sid = RU.sid " + "WHERE rid='" + repair_id + "') W "
							+ "JOIN Charge_type CT ON CT.charge_type=W.charge_type");
			if (rs.next()) {
				repairCost = rs.getInt("total_cost");
			} else {
				repairCost = 0;
			}
			rs = connObject2.selectQuery("SELECT diagnostic_cost FROM Repair " + "WHERE rid=" + repair_id + "");
			if (rs.next()) {
				diagnosticCost = rs.getInt("diagnostic_cost");
			} else {
				diagnosticCost = 0;
			}

			return (repairCost + diagnosticCost);
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return 0;
		}
	}

	public static float getTotalHoursForMaintenance(int vehicle_id, String m_type) {
		try {
			String s1 = "";
			String s2 = "";
			if (m_type == "B") {
				s1 = " OR m_type='B'";
			} else if (m_type == "C") {
				s1 = " OR m_type='B'";
				s2 = " OR m_type='A'";
			}
			ResultSet rs = connObject2
					.selectQuery("SELECT SUM(hours_to_complete) AS total_time FROM (SELECT * FROM Maintenance_uses MU "
							+ "JOIN Service S ON S.sid = MU.sid " + "WHERE vehicle_id=" + vehicle_id + " AND (m_type='"
							+ m_type + "'" + s1 + s2 + ")) W " + "JOIN Charge_type CT ON CT.charge_type=W.charge_type");
			if (!rs.next()) {
				return 0;
			} else {
				return rs.getFloat("total_time");
			}
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return 0;
		}
	}

	public static float getTotalHoursForRepair(int repair_id) {
		try {
			ResultSet rs = connObject2
					.selectQuery("SELECT SUM(hours_to_complete) AS total_time FROM (SELECT * FROM Repair_uses RU "
							+ "JOIN Service S ON S.sid = RU.sid " + "WHERE rid='" + repair_id + "') W "
							+ "JOIN Charge_type CT ON CT.charge_type=W.charge_type");
			if (!rs.next()) {
				return 0;
			} else {
				return rs.getFloat("total_time");
			}
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return 0;
		}
	}

	public static ResultSet getTotalPartsForMaintenance(String m_type, int vehicle_id) {
		try {
			String make = "";
			ResultSet rs = connObject2.selectQuery("SELECT * FROM Vehicles WHERE vehicle_id='" + vehicle_id + "'");
			if (rs.next()) {
				make = rs.getString("make");
			}
			String s1 = "";
			String s2 = "";
			if (m_type == "B") {
				s1 = " OR m_type='B'";
			} else if (m_type == "C") {
				s1 = " OR m_type='B'";
				s2 = " OR m_type='A'";
			}
			rs = connObject2.selectQuery("SELECT * FROM ("
					+ "SELECT sid, X.part_id as part_id,vehicle_id,quantity,name FROM (SELECT miles,W.vehicle_id,sid,m_type,quantity,part_id  FROM (SELECT * FROM Maintenance_uses MU  WHERE (m_type='"
					+ m_type + "'" + s1 + s2 + ") AND vehicle_id=" + vehicle_id + ") W "
					+ "JOIN Involves I ON I.service_id=W.sid " + "WHERE W.vehicle_id=I.vehicle_id) X "
					+ "JOIN Parts P ON P.part_id=X.part_id) Z " + "JOIN Parts_to_make PM ON PM.part_id=Z.part_id "
					+ "WHERE make='" + make + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return rs;
		}
	}

	public static ResultSet getTotalPartsForRepair(int repair_id, int vehicle_id) {
		try {
			String make = "";
			ResultSet rs = connObject2.selectQuery("SELECT * FROM Vehicles WHERE vehicle_id='" + vehicle_id + "'");
			if (rs.next()) {
				make = rs.getString("make");
			}
			rs = connObject2.selectQuery("SELECT * FROM ("
					+ "SELECT sid, X.part_id as part_id,vehicle_id,quantity,name FROM (SELECT * FROM (SELECT * FROM Repair_uses RU  WHERE rid='"
					+ repair_id + "') W " + "JOIN Involves I ON I.service_id=W.sid " + "WHERE vehicle_id=" + vehicle_id
					+ ") X " + "JOIN Parts P ON P.part_id=X.part_id) Z "
					+ "JOIN Parts_to_make PM ON PM.part_id=Z.part_id " + "WHERE make='" + make + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return rs;
		}
	}

	public static String getEndTimeForMaintenance(String plate_no, String m_type, String schedule_id) {
		try {
			float totalTime = getTotalTimeForMaintenance(plate_no, m_type);

			rs = connObject.selectQuery("Select * from Schedule where schedule_id='" + schedule_id + "'");
			if (!rs.next()) {
				System.out.println("Wrong schedule_id");
				return "";
			} else {
				Timestamp time = rs.getTimestamp("start_time");

				Long duration = (long) (totalTime);
				time.setTime(time.getTime() + duration);
				return time.toString();
			}
		} catch (Throwable e) {
			System.out.println("Something went wrong");
			return "";
		}
	}

	public static boolean updateEndTimeForMaintenanceInSchedule(String plate_no, String m_type, String schedule_id) {
		try {
			float totalTime = getTotalTimeForMaintenance(plate_no, m_type);

			rs = connObject.selectQuery("Select * from Schedule where schedule_id='" + schedule_id + "'");
			if (!rs.next()) {
				System.out.println("Wrong schedule_id");
				return false;
			} else {
				Timestamp time = rs.getTimestamp("start_time");

				Long duration = (long) (totalTime);
				time.setTime(time.getTime() + duration);
				connObject.insertQuery("Update Schedule SET end_time=TIMESTAMP '" + time.toString() + "'");
				return true;
			}
		} catch (Throwable e) {
			System.out.println("Something went wrong");
			return false;
		}
	}

	public static long getTotalTimeForRepair(String repair_id) {
		try {
			rs = connObject.selectQuery("Select sum(hours_to_complete) as sum from Service S,"
					+ "(Select R2.sid from Repair R1, Repair_uses R2 where R1.rid='" + repair_id
					+ "' and R1.rid = R2.rid) T1 where S.sid = T1.sid");
			if (!rs.next()) {
				return 0;
			} else {
				return getTimeInMilliSeconds(rs.getFloat("sum"));
			}
		} catch (Throwable e) {
			System.out.println("Wrong values");
			return 0;
		}
	}

	public static String getEndTimeForRepair(String repair_id, String schedule_id) {
		try {
			float totalTime = getTotalTimeForRepair(repair_id);

			rs = connObject.selectQuery("Select * from Schedule where schedule_id='" + schedule_id + "'");
			if (!rs.next()) {
				System.out.println("Wrong schedule_id");
				return "";
			} else {
				Timestamp time = rs.getTimestamp("start_time");

				Long duration = (long) (totalTime);
				time.setTime(time.getTime() + duration);
				return time.toString();
			}
		} catch (Throwable e) {
			System.out.println("Something went wrong");
			return "";
		}
	}

	public static boolean updateEndTimeForRepairInSchedule(String repair_id, String schedule_id) {
		try {
			float totalTime = getTotalTimeForRepair(repair_id);

			rs = connObject.selectQuery("Select * from Schedule where schedule_id='" + schedule_id + "'");
			if (!rs.next()) {
				System.out.println("Wrong schedule_id");
				return false;
			} else {
				Timestamp time = rs.getTimestamp("start_time");

				Long duration = (long) (totalTime);
				time.setTime(time.getTime() + duration);
				connObject.insertQuery("Update Schedule SET end_time=TIMESTAMP '" + time.toString() + "'");
				return true;
			}
		} catch (Throwable e) {
			System.out.println("Something went wrong");
			return false;
		}
	}

	public static long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime) {
		long milliseconds1 = oldTime.getTime();
		long milliseconds2 = currentTime.getTime();

		long diff = milliseconds1 - milliseconds2;

		return diff;
	}

	public static ResultSet getDiagnosticReport(String plate_no, String repair_id) {
		try {
			rs = connObject.selectQuery(
					"Select S.name as service_name, Z.name as part_Name, Z.quantity, Z.rid,Z.repair_name, Z.diagnostic_name from Service S,"
							+ "(Select P.name, Y.quantity, Y.rid,Y.repair_name, Y.diagnostic_name, Y.sid from Parts P,"
							+ "(Select I.part_id, I.quantity, T.sid, T.rid,T.repair_name, T.diagnostic_name from Involves I,"
							+ "(Select RU.sid, R.rid,R.repair_name, R.diagnostic_name from Repair_uses RU, "
							+ "(Select repair_name, rid, diagnostic_name from Repair where rid = '" + repair_id
							+ "') R where R.rid= RU.rid) T,"
							+ "(Select T1.vehicle_id, V.make from Vehicles V, (Select vehicle_id from Owns O where O.plate_no='"
							+ plate_no + "') T1 where V.vehicle_id=T1.vehicle_id) X "
							+ "where I.service_id=T.sid and I.vehicle_id = X.vehicle_id) Y where P.part_id=Y.part_id) Z where S.sid = Z.sid");
			return rs;
		} catch (Throwable e) {
			System.out.println("Something Went Wrong");
			return rs;
		}
	}

	public static boolean dailyTaskUpdateInventory(String users_service_centre_id) {
		try {
			java.util.Date utilDate = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(utilDate);
			cal.add(Calendar.DATE, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.set(Calendar.HOUR_OF_DAY, 4);
			String s1 = new java.sql.Timestamp(cal.getTimeInMillis()).toString();
			cal.set(Calendar.HOUR_OF_DAY, 23);
			String s2 = new java.sql.Timestamp(cal.getTimeInMillis()).toString();
			rs = connObject
					.selectQuery("select * from Schedule S WHERE S.start_time > TIMESTAMP '"
							+ s1 + "' AND S.start_time < TIMESTAMP '" + s2 + "'");
			while (rs.next()) {
				int sid = rs.getInt("schedule_id");
				String plate_no = rs.getString("customer_plate_no");
				String type_name = null;
				ResultSet rs2 = connObject2
						.selectQuery("Select * from Maintenance_schedule where maintenance_schedule_id='" + sid + "'");
				if (rs2.next()) {
					type_name = rs2.getString("m_type");
					rs2 = connObject2.selectQuery(
							"SELECT T11.sc_id, T3.part_id, T3.Parts_to_make_id, Inv.current_quantity, Inv.min_inventory_thold, Inv.min_order_quantity, T3.quantity FROM Inventory Inv, "
									+ "(SELECT PM.Parts_to_make_id, T2.part_id, T2.quantity FROM Parts_to_make PM, "
									+ "(SELECT I.part_id, I.quantity, I.vehicle_id, T1.m_type, T1.make FROM Involves I, "
									+ "(SELECT MU.sid, MU.vehicle_id, MU.m_type, V.make FROM Owns O, Maintenance_uses MU, Vehicles V "
									+ "WHERE O.plate_no = 'IRM-1212' AND " + "O.vehicle_id = MU.vehicle_id AND "
									+ "MU.m_type='" + type_name + "' AND " + "V.vehicle_id = O.vehicle_id) T1 "
									+ "WHERE I.service_id = T1.sid AND " + "T1.vehicle_id = I.vehicle_id) T2 "
									+ "WHERE T2.part_id=Pm.part_id AND " + "T2.make = PM.make) T3, "
									+ "(SELECT C1.sc_id from Customers C1, Owns O1 WHERE O1.plate_no = '" + plate_no
									+ "' AND O1.email = C1.email) T11 " + "WHERE "
									+ "T3.Parts_to_make_id = Inv.Parts_to_make_id AND "
									+ "T11.sc_id=Inv.service_center_id");
					while (rs2.next()) {
						int ans = connObject3.insertQuery(
								"Update Inventory SET current_quantity=current_quantity - " + rs2.getInt("quantity")
										+ " where Inventory.parts_to_make_id=" + rs2.getInt("Parts_to_make_id")
										+ " and " + "Inventory.service_center_id='" + users_service_centre_id + "'");
					}

				} else {
					rs2 = connObject2
							.selectQuery("Select * from Repair_schedule where repair_schedule_id='" + sid + "'");
					if (rs2.next()) {
						int rid = rs2.getInt("repair_schedule_id");
						rs2 = connObject2.selectQuery(
								"SELECT T11.sc_id, T3.part_id, T3.Parts_to_make_id, Inv.current_quantity, Inv.min_inventory_thold, Inv.min_order_quantity, T3.quantity FROM Inventory Inv,"
										+ "(SELECT PM.Parts_to_make_id, T2.part_id, T2.quantity FROM Parts_to_make PM,"
										+ "(SELECT I.part_id, I.quantity, I.vehicle_id, T1.make FROM Involves I, "
										+ "(SELECT RU.sid, V.make, O.vehicle_id from Repair_uses RU, Vehicles V, Owns O "
										+ "Where" + "RU.rid=" + rid + " AND " + "V.vehicle_id = O.vehicle_id AND "
										+ "O.plate_no = 'IRM-1212') T1 " + "WHERE I.service_id = T1.sid AND "
										+ "T1.vehicle_id = I.vehicle_id) T2 " + "WHERE T2.part_id=Pm.part_id AND "
										+ "T2.make = PM.make) T3, "
										+ "(SELECT C1.sc_id from Customers C1, Owns O1 WHERE O1.plate_no = '" + plate_no
										+ "' AND O1.email = C1.email) T11 " + "WHERE "
										+ "T3.Parts_to_make_id = Inv.Parts_to_make_id AND "
										+ "T11.sc_id=Inv.service_center_id");
						while (rs2.next()) {
							int ans = connObject3
									.insertQuery("Update Inventory SET current_quantity=current_quantity - "
											+ rs2.getInt("quantity") + " where Inventory.parts_to_make_id="
											+ rs2.getInt("Parts_to_make_id") + " and " + "Inventory.service_center_id='"
											+ users_service_centre_id + "'");
						}
					}
				}
			}

			return true;
		} catch (Throwable e) {
			System.out.println("Something Went Wrong");
			return false;
		}
	}

	public static boolean dailyTaskRecordDeliveries(String[] arr, String users_service_center_id) {
		try {
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			for (int i = 0; i < arr.length; i++) {
				String orderId = arr[i];
				rs = connObject
						.selectQuery("Select quantity, parts_to_make_id from Orders where order_id='" + orderId + "'");
				if (rs.next()) {
					int quant = rs.getInt("quantity");
					int parts_to_make_id = rs.getInt("parts_to_make_id");
					connObject2.insertQuery("Update Orders Set status='complete', order_delivery_date= Date '" + sqlDate
							+ "' where order_id='" + orderId + "'");
					connObject2.insertQuery("Update Inventory Set current_quantity = current_quantity + " + quant
							+ " where service_center_id='" + users_service_center_id + "' and parts_to_make_id="
							+ parts_to_make_id);
				}
			}
			
			rs = connObject.selectQuery("Select * from Orders where order_expected_delivery_date<Date '"+sqlDate+"' and "
					+ "requester_center_inventory_id='"+users_service_center_id+"' and status <> 'complete'");
			while(rs.next()) {
				int orderId = rs.getInt("order_id");
				connObject2.insertQuery("Update Orders Set status='delayed' where order_id=" + orderId);
				connObject2.insertQuery(
						"INSERT into Notification(notification_id,order_id,message,notification_date,service_center_id) "
								+ "Values(1," + orderId + ",'Order with id " + orderId + " delayed',Date '" + sqlDate
								+ "','" + users_service_center_id + "')");
			}

			return true;
		} catch (Throwable e) {
			System.out.println("Something Went Wrong");
			return false;
		}
	}

	public ResultSet getEmployeePayrollDetails(String email) {
		try {
			rs = connObject.selectQuery("SELECT E.eid, E.name AS e_name, E.wage AS compensation, "
					+ "E.freq, PR.units, PC.start_date, PC.end_date "
					+ "FROM Employees E JOIN Payment_record PR ON E.eid=PR.eid "
					+ "JOIN Payment_cycle PC ON PR.pcid=PC.pcid WHERE email='" + email + "'");
			return rs;
		} catch (Throwable e) {
			System.out.println("Wrong Email");
			return rs;
		}
	}
}
