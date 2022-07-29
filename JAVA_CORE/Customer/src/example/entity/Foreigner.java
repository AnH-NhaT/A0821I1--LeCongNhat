package example.entity;

import java.util.Date;

public class Foreigner extends Customer {
	private String Passport;
	private int TravelTimes;

	public Foreigner(int type, String cusID, String name, Date birthDate, boolean sex, String identifyID,
			int vaccineTimes, Date travelDate, int ticketPrice, String passport, int travelTimes) {
		super(type, cusID, name, birthDate, sex, identifyID, vaccineTimes, travelDate, ticketPrice);
		Passport = passport;
		TravelTimes = travelTimes;
	}

	public String getPassport() {
		return Passport;
	}

	public int getTravelTimes() {
		return TravelTimes;
	}

	public void setPassport(String passport) {
		Passport = passport;
	}

	public void setTravelTimes(int travelTimes) {
		TravelTimes = travelTimes;
	}

	@Override
	public String toString() {
		return super.toString() + ", Passport=" + Passport + ", TravelTimes=" + TravelTimes;
	}

}
