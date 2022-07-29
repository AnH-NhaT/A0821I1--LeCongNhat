package example.repositories;

import java.util.ArrayList;
import java.util.List;

import example.models.Customer;
import example.models.OutProvincePeople;

public class OutProvincePeopleImpl implements ICustomer {

	@Override
	public List<?> showInformation(List<Customer> list) {
		List<OutProvincePeople> listOutProvincePeople = new ArrayList<>();
		list.forEach((e) -> {
			if (e instanceof OutProvincePeople) {
				OutProvincePeople outProvincePeople = (OutProvincePeople) e;
				listOutProvincePeople.add(outProvincePeople);
			}
		});
		return listOutProvincePeople;
	}

}
