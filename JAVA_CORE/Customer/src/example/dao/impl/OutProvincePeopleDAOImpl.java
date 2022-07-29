package example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import example.dao.ShowInfoDAO;
import example.entity.Customer;
import example.entity.OutProvincePeople;

public class OutProvincePeopleDAOImpl implements ShowInfoDAO {

	@Override
	public List<OutProvincePeople> showInfo(List<Customer> list) {
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
