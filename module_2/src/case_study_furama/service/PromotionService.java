package case_study_furama.service;

import case_study_furama.model.Booking;
import case_study_furama.model.Customer;

import java.util.*;

public interface PromotionService {
    List<Booking> getCustomerUseService(int year);
    Map<Customer, Integer> getCustomerVoucher(int amountOf10, int amountOf20, int amountOf50);
}
