package case_study_furama.service;

import case_study_furama.model.Booking;

import java.util.Stack;
import java.util.TreeSet;

public interface BookingService {
    TreeSet<Booking> getAll();
    void save(Booking booking);
    Stack<Booking> getForContract();
}
