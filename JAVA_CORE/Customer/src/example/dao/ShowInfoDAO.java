package example.dao;

import java.util.List;

import example.entity.Customer;

public interface ShowInfoDAO {
	List<?> showInfo(List<Customer> list);
}
