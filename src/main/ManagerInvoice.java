package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerInvoice {

	public void viewInvoice() {
		try {
			ResultSet rs = MainApp.functObject.getInvoiceDetails(MainApp.userInfoObject.service_centre_id);
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
					totalCost = MainApp.functObject.getTotalCostForRepair(repairId);
					totalTime = MainApp.functObject.getTotalHoursForRepair(repairId);
					ResultSet rs2 = MainApp.functObject.getTotalPartsForRepair(repairId, vehicleId);
					System.out.println("F. Parts-");
					while (rs2.next()) {
						int partCost = (rs2.getInt("quantity") * rs2.getInt("unit_price"));
						totalCost = totalCost + partCost;
						System.out.println(rs2.getString("name") + "-" + partCost + "$");
					}
				} else {
					String mType = rs.getString("m_type");
					System.out.println("E. Maintenance-" + mType);
					totalCost = MainApp.functObject.getTotalCostForMaintenance(vehicleId, mType);
					totalTime = MainApp.functObject.getTotalHoursForMaintenance(vehicleId, mType);
					ResultSet rs2 = MainApp.functObject.getTotalPartsForMaintenance(mType, vehicleId);
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
			Scanner s2 = new Scanner(System.in);
			while (true) {
				String selected_option = s2.nextLine();

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
