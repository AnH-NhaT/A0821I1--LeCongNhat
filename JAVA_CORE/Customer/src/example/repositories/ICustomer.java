package example.repositories;

import java.util.List;

import example.models.Customer;

public interface ICustomer {
	List<?> showInformation(List<Customer> list);
}
