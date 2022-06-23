package case_study_furama.controller;

import case_study_furama.model.Contract;
import case_study_furama.service.ContractService;
import case_study_furama.service.impl.ContractServiceImpl;

import java.util.List;

public class ContractController {
    private ContractService contractService= new ContractServiceImpl();

    public List<Contract> getAll(){ return contractService.getAll();}

    public void save(Contract contract){
        contractService.save(contract);
    }
}
