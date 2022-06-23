package case_study_furama.view;

import case_study_furama.controller.BookingController;
import case_study_furama.controller.ContractController;
import case_study_furama.controller.CustomerController;
import case_study_furama.controller.FacilityController;
import case_study_furama.model.*;
import case_study_furama.util.CommomUtil;
import case_study_furama.util.ValidationUtil;

import java.time.LocalDate;
import java.util.Stack;
import java.util.TreeSet;

public class BookingView {
    private static BookingController bookingController = new BookingController();
    private static CustomerController customerController = new CustomerController();
    private static FacilityController facilityController = new FacilityController();
    private static ContractController contractController= new ContractController();

    public static void bookingManager() {
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("1. Add new booking\n"
                    + "2. Display list booking\n"
                    + "3. Create new constracts\n"
                    + "4. Display list contracts\n"
                    + "5. Edit contracts\n"
                    + "6. Return main menu");

            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 6: ");
            tmp = CommomUtil.getScanner().nextLine();
            if (ValidationUtil.isNumber(tmp)) choice = Integer.parseInt(tmp);
        } while (choice <= 0 || choice > 6);

        switch (choice) {
            case 1:
                creatBooking();
                break;
            case 2:
                display(bookingController.getAll());
                break;
            case 3:
                createContract();
                break;
            case 4:
                HomeView.displayHomeMenu();
                break;
        }
    }

    private static void createContract() {
        Stack<Booking> bookingStack= bookingController.getForContract();
        while (!bookingStack.empty()){
            Booking booking= bookingStack.pop();
            System.out.println("Please create contract for "+ booking.getCode());
            System.out.print("Contract Code: ");
            String code= CommomUtil.getScanner().nextLine();
            System.out.print("Down Payment: ");
            double down=  Double.parseDouble(CommomUtil.getScanner().nextLine());
            System.out.print("Total Payment: ");
            double total=  Double.parseDouble(CommomUtil.getScanner().nextLine());
            String customerCode= customerController.getById(booking.getCustomerId()).getCode();
            contractController.save(new Contract(code, down, total, booking.getCode(), customerCode));
            System.out.println("Created successful for "+ booking.getCode());
            booking.setContracted(true);
        }
        System.out.println("No Booking for create contract");
    }

    private static void creatBooking() {
        int customerId = choiceCustomer();
        int facilityId = choiceFacility();
        System.out.print("Code: ");
        String code = CommomUtil.getScanner().nextLine();
        System.out.print("Start Date: ");
        String startDate = CommomUtil.getScanner().nextLine();
        System.out.print("End Date: ");
        String endDate = CommomUtil.getScanner().nextLine();
        Booking booking = new Booking(code, LocalDate.parse(startDate, CommomUtil.getDateFormat()), LocalDate.parse(endDate, CommomUtil.getDateFormat()), customerId, facilityId);
        bookingController.save(booking);
        System.out.println("Booking successful");
    }

    private static int choiceCustomer() {
        customerController.getAll().forEach(System.out::println);
        System.out.print("Please choice customer ID: ");
        return Integer.parseInt(CommomUtil.getScanner().nextLine());
    }

    private static int choiceFacility() {
        facilityController.getAll().keySet().forEach(System.out::println);
        System.out.print("Please choice facility ID: ");
        return Integer.parseInt(CommomUtil.getScanner().nextLine());
    }

    static void display(TreeSet<Booking> bookingTreeSet) {
        bookingTreeSet.forEach(e->{
            Customer customer= customerController.getById(e.getCustomerId());
            Facility facility= facilityController.getById(e.getFacilityId());
            String typeService= facility instanceof Villa? "Villa": facility instanceof House ? "House": "Room";
            String res= String.format("id= %d, code= %s, startDate= %s, endDate= %s, customerName= %s, customerPhone= %s," +
                            " customerAddress= %s, serviceName= %s, serviceType= %s, servicePrice= %s, isContracted= %b",
                    e.getId(), e.getCode(), e.getStartDate().format(CommomUtil.getDateFormat()),
                    e.getEndDate().format(CommomUtil.getDateFormat()), customer.getFullName(), customer.getPhone(),
                    customer.getAddress(), facility.getName(), typeService, facility.getPrice(), e.isContracted());
            System.out.println(res);
        });
    }
}
