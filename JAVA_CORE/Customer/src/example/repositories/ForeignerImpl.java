package example.repositories;

import java.util.ArrayList;
import java.util.List;

import example.models.Customer;
import example.models.Foreigner;

public class ForeignerImpl implements ICustomer {

	@Override
	public List<?> showInformation(List<Customer> list) {
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
