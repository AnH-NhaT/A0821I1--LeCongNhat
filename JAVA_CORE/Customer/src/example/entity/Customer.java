package example.entity;

import java.util.Date;

public abstract class Customer {
	private int type;
	private String CusID;
	private String Name;
	private Date BirthDate;
	private boolean Sex;
	private String IdentifyID;
	private int VaccineTimes;
	private Date TravelDate;
	private int TicketPrice;

	public Customer() {
	}

	public Customer(int type, String cusID, String name, Date birthDate, boolean sex, String identifyID,
			int vaccineTimes, Date travelDate, int ticketPrice) {
		this.type = type;
		CusID = cusID;
		Name = name;
		BirthDate = birthDate;
		Sex = sex;
		IdentifyID = identifyID;
		VaccineTimes = vaccineTimes;
		TravelDate = travelDate;
		TicketPrice = ticketPrice;
	}

	public int getType() {
		return type;
	}

	public String getCusID() {
		return CusID;
	}

	public String getName() {
		return Name;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public boolean isSex() {
		return Sex;
	}

	public String getIdentifyID() {
		return IdentifyID;
	}

	public int getVaccineTimes() {
		return VaccineTimes;
	}

	public Date getTravelDate() {
		return TravelDate;
	}

	public int getTicketPrice() {
		return TicketPrice;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setCusID(String cusID) {
		CusID = cusID;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public void setSex(boolean sex) {
		Sex = sex;
	}

	public void setIdentifyID(String identifyID) {
		IdentifyID = identifyID;
	}

	public void setVaccineTimes(int vaccineTimes) {
		VaccineTimes = vaccineTimes;
	}

	public void setTravelDate(Date travelDate) {
		TravelDate = travelDate;
	}

	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "type=" + type + ", CusID=" + CusID + ", Name=" + Name + ", BirthDate=" + BirthDate + ", Sex=" + Sex
				+ ", IdentifyID=" + IdentifyID + ", VaccineTimes=" + VaccineTimes + ", TravelDate=" + TravelDate
				+ ", TicketPrice=" + TicketPrice;
	}

}
