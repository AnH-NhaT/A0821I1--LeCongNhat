package final_test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import final_test.dao.ShowInfoDAO;
import final_test.entity.Customer;
import final_test.entity.LocalPeople;

public class LocalPeopleDAOImpl implements ShowInfoDAO {

	@Override
	public List<LocalPeople> showInfo(List<Customer> list) {
		List<LocalPeople> listLocalPeople = new ArrayList<>();
		list.forEach((e) -> {
			if (e instanceof LocalPeople) {
				LocalPeople localPeople = (LocalPeople) e;
				listLocalPeople.add(localPeople);
			}
		});
		return listLocalPeople;
	}
	
}
