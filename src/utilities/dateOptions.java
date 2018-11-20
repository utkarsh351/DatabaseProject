package utilities;

import java.sql.Timestamp;

public class dateOptions {

	public Timestamp s_time;
	
	public Timestamp e_time;

	public String mechanicId;

	dateOptions(Timestamp s_time,Timestamp e_time, String mechanicId) {
		this.s_time = s_time;
		this.e_time = e_time;
		this.mechanicId = mechanicId;
	}
}
