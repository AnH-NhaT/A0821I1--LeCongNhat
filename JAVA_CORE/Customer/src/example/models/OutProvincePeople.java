package example.models;

import java.util.Date;

public class OutProvincePeople extends Customer {
	private String Province;

	public OutProvincePeople(int type, String cusID, String name, Date birthDate, boolean sex, String identifyID,
			int vaccineTimes, Date travelDate, int ticketPrice, String province) {
		super(type, cusID, name, birthDate, sex, identifyID, vaccineTimes, travelDate, ticketPrice);
		Province = province;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	@Override
	public String toString() {
		return super.toString() + ", Province=" + Province;
	}

}
