package case_study_furama.controller;

import case_study_furama.model.Booking;
import case_study_furama.model.Customer;
import case_study_furama.service.PromotionService;
import case_study_furama.service.impl.PromotionServiceImpl;

import java.util.List;
import java.util.Map;

public class PromotionController {
    private PromotionService promotionService= new PromotionServiceImpl();

    public List<Booking> getCustomerUseService(int year){
        return promotionService.getCustomerUseService(year);
    }

    public Map<Customer, Integer> getCustomerVoucher(int amountOf10, int amountOf20, int amountOf50){
        return promotionService.getCustomerVoucher(amountOf10, amountOf20, amountOf50);
    }
}
