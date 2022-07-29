package example.repositories;

import java.util.ArrayList;
import java.util.List;

import example.models.Customer;
import example.models.LocalPeople;

public class LocalPeopleImpl implements ICustomer {

	@Override
	public List<?> showInformation(List<Customer> list) {
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
