package case_study_furama.service.impl;

import case_study_furama.model.Booking;
import case_study_furama.model.Customer;
import case_study_furama.service.BookingService;
import case_study_furama.service.CustomerService;
import case_study_furama.service.PromotionService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PromotionServiceImpl implements PromotionService {
    private BookingService bookingService= new BookingServiceImpl();
    private CustomerService customerService= new CustomerServiceImpl();

    @Override
    public List<Booking> getCustomerUseService(int year) {
        return bookingService.getAll().stream().filter(e-> e.getStartDate().getYear()== year).collect(Collectors.toList());
    }

    @Override
    public Map<Customer, Integer> getCustomerVoucher(int amountOf10, int amountOf20, int amountOf50) {
        Map<Customer, Integer> res= new HashMap<>();
        LocalDate now= LocalDate.now();
        bookingService.getAll().stream().forEach(e-> {
            if(e.getEndDate().getYear()== now.getYear() && e.getEndDate().getMonthValue()== now.getMonthValue()){
                if(res.size() <= amountOf10) {
                    res.put(customerService.getById(e.getCustomerId()), amountOf10);
                }
                else if(res.size() <= amountOf20){
                    res.put(customerService.getById(e.getCustomerId()), amountOf20);
                }
                else if(res.size() <= amountOf50){
                    res.put(customerService.getById(e.getCustomerId()), amountOf50);
                }
                else{
                    return;
                }
            }
        });

        return res;
    }
}
