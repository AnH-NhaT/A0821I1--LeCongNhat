package case_study_furama.service.impl;

import case_study_furama.model.Booking;
import case_study_furama.model.Facility;
import case_study_furama.service.BookingService;
import case_study_furama.service.FacilityService;
import case_study_furama.util.CommomUtil;

import java.time.LocalDate;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    private static TreeSet<Booking> bookings= new TreeSet<>();
    private static FacilityService facilityService= new FacilityServiceImpl();

    static {
        LocalDate startDate= LocalDate.parse("05/01/2021", CommomUtil.getDateFormat());
        LocalDate endDate= LocalDate.parse("15/01/2021", CommomUtil.getDateFormat());
        Booking booking= new Booking("BOK01", startDate , endDate,1, 1);
        booking.setId(1);
        bookings.add(booking);
    }

    @Override
    public TreeSet<Booking> getAll() {
        return bookings;
    }

    @Override
    public void save(Booking booking) {
        booking.setId(bookings.size()+ 1);
        bookings.add(booking);

        Facility facility= facilityService.getById(booking.getFacilityId());
        Map<Facility, Integer> tmp= facilityService.getFacilitys();
        tmp.put(facility,tmp.get(facility)+1);
    }

    @Override
    public Stack<Booking> getForContract() {
        Stack<Booking> res= new Stack<>();
        bookings.forEach(e->{
            if(!e.isContracted()) res.add(e);
        });
        return res;
    }

}
