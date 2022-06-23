package case_study_furama.controller;

import case_study_furama.model.Booking;
import case_study_furama.service.BookingService;
import case_study_furama.service.impl.BookingServiceImpl;

import java.util.Stack;
import java.util.TreeSet;

public class BookingController {
    private BookingService bookingService= new BookingServiceImpl();

    public TreeSet<Booking> getAll(){
        return bookingService.getAll();
    }

    public void save(Booking booking){
        bookingService.save(booking);
    }

    public Stack<Booking> getForContract(){
        return bookingService.getForContract();
    }
}
