package case_study_furama.service.impl;

import case_study_furama.model.Customer;
import case_study_furama.service.CustomerService;
import case_study_furama.util.ConstantUtil;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static LinkedList<Customer> customers= new LinkedList<>();

    static {
        customers.add(new Customer(1, "CUS01", "Phong Nguyen", "23/09/1984", ConstantUtil.Gender.MALE, "0708230984",
                "phongnna@gmail.com", "19 Le Do", ConstantUtil.TypeCustomer.SILVER));
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId()>0){
            int index= customers.indexOf(customer);
            customers.set(index, customer);
        }
        else {
            customer.setId(customers.size()+ 1);
            customers.add(customer);
        }
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(int id) {
        return customers.stream().filter(e-> id== e.getId()).findFirst().get();
    }
}
