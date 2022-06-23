package case_study_furama.controller;

import case_study_furama.model.Customer;
import case_study_furama.service.CustomerService;
import case_study_furama.service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerService customerService= new CustomerServiceImpl();

    public List<Customer> getAll(){
        return customerService.getAll();
    }

    public void save(Customer customer){
        customerService.save(customer);
    }

    public Customer getById(int id){
        return customerService.getById(id);
    }
}
