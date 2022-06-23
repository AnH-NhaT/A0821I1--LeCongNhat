package case_study_furama.controller;

import case_study_furama.model.Employee;
import case_study_furama.service.EmployeeService;
import case_study_furama.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService= new EmployeeServiceImpl();

    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    public void save(Employee employee){
        employeeService.save(employee);
    }
}
