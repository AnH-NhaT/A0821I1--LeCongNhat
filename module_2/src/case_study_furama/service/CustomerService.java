package case_study_furama.service;

import case_study_furama.model.Customer;

public interface CustomerService extends BaseService<Customer> {
    Customer getById(int id);
}
