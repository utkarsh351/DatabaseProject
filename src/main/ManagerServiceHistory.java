package main;

import java.sql.ResultSet;
import java.util.Scanner;

public class ManagerServiceHistory {

	public void viewServiceHistoryPage() {
		try {
			ResultSet rs = MainApp.functObject.getServiceHistoryForManager(MainApp.userInfoObject.service_centre_id);

			while (rs.next()) {
				System.out.println("A. " + rs.getString("schedule_id"));
				System.out.println("B. " + rs.getString("plate_no"));
				if(rs.getString("maintenance_schedule_id")== null) {
					System.out.println("C. Repair-" + rs.getInt("rid"));
				}
				else {
					System.out.println("C. Maintenance-" + rs.getString("m_type"));
				}
				System.out.println("D. " + rs.getString("name"));
				System.out.println("E. " + rs.getString("start_time"));
				System.out.println("F. "+ rs.getString("end_time"));
				System.out.println("G. " + rs.getString("status"));
				System.out.println(" " );
			}
			
			System.out.println("1. Go Back");
			Scanner s = new Scanner(System.in);
			while (true) {
				String selected_option = s.nextLine();

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
