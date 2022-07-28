package example.views;

import example.services.CustomerService;

public class Main {

	public static void main(String[] args) {
		CustomerService.insertFromCSV();
		CustomerService.updateTicketPrice();
		CustomerService.delete();
	}
}
