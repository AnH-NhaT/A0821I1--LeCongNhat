package case_study_furama.service.impl;

import case_study_furama.model.Contract;
import case_study_furama.service.BookingService;
import case_study_furama.service.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    private BookingService bookingService= new BookingServiceImpl();
    private List<Contract> contracts= new ArrayList<>();

    @Override
    public void save(Contract contract) {
        contract.setId(contracts.size()+ 1);
        contracts.add(contract);
    }

    @Override
    public List<Contract> getAll() {
        return contracts;
    }
}
