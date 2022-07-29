package final_test.dao;

import java.util.List;

import final_test.entity.Customer;

public interface ShowInfoDAO {
	List<?> showInfo(List<Customer> list);
}
