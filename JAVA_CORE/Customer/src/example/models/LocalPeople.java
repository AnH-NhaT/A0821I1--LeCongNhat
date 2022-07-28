package example.models;

import java.util.Date;

public class LocalPeople extends Customer {
	private String Address;

	public LocalPeople(int type, String cusID, String name, Date birthDate, boolean sex, String identifyID,
			int vaccineTimes, Date travelDate, int ticketPrice, String address) {
		super(type, cusID, name, birthDate, sex, identifyID, vaccineTimes, travelDate, ticketPrice);
		Address = address;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return super.toString() + ", Address=" + Address;
	}

}
