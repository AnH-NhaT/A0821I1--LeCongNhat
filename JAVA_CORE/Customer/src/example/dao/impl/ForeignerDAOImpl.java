package example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import example.dao.ShowInfoDAO;
import example.entity.Customer;
import example.entity.Foreigner;

public class ForeignerDAOImpl implements ShowInfoDAO {

	@Override
	public List<Foreigner> showInfo(List<Customer> list) {
		List<Foreigner> listForeigners = new ArrayList<>();
		list.forEach((e) -> {
			if (e instanceof Foreigner) {
				Foreigner foreigner = (Foreigner) e;
				listForeigners.add(foreigner);
			}
		});
		return listForeigners;
	}

}
