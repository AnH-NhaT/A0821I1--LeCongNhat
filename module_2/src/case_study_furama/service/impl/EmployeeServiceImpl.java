package case_study_furama.service.impl;

import case_study_furama.model.Employee;
import case_study_furama.service.EmployeeService;
import case_study_furama.util.CSVHelper;
import case_study_furama.util.ConstantUtil.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    //    private static List<Employee> employees = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private CSVHelper<Employee> csvHelper = new CSVHelper<>();

    public EmployeeServiceImpl() {
        employees = getAll();
    }

//    static {
//        employees.add(new Employee(1, "EMP01", "Quoc Nguyen", "23/09/1984", Gender.MALE, "0708230984",
//                "quocnna@gmail.com", "19 Le Do", Degree.BACHERLOR, Position.SUPERVISOR, 2000));
//        employees.add(new Employee(2, "EMP02", "Dung Nguyen", "05/05/1995", Gender.MALE, "0708230984",
//                "dungnna@gmail.com", "19 Le Do", Degree.DOCTER, Position.SUPERVISOR, 3000));
//        employees.add(new Employee(3, "EMP03", "Toan Nguyen", "03/03/1991", Gender.MALE, "0708230984",
//                "toannna@gmail.com", "19 Le Do", Degree.PROFESSOR, Position.SUPERVISOR, 4000));
//        employees.add(new Employee(4, "EMP04", "My Nguyen", "02/02/1961", Gender.MALE, "0708230984",
//                "mynna@gmail.com", "19 Le Do", Degree.MASTER, Position.SUPERVISOR, 5000));
//        employees.add(new Employee(5, "EMP05", "Xuan Le", "01/0901/1962", Gender.FEMALE, "0708230984",
//                "xuanltt.com", "19 Le Do", Degree.BACHERLOR, Position.DIRECTOR, 6000));
//    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() > 0) {
            int index = employees.indexOf(employee);
            employees.set(index, employee);
            csvHelper.write(employees, PATH.EMPLOYEE, false);
        } else {
            employee.setId(employees.size() + 1);
            employees.add(employee);
            List<Employee> tmp= new ArrayList();
            tmp.add(employee);
            csvHelper.write(tmp, PATH.EMPLOYEE, true);
        }
    }

    @Override
    public List<Employee> getAll() {
        if (employees.size() == 0) getFromFile();
        return employees;
    }

    private void getFromFile() {
        List<String> lines = csvHelper.read(PATH.EMPLOYEE);
        for (String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String fullName = tmp[2];
            String birthday = tmp[3];
            String gender = tmp[4];
            String phone = tmp[5];
            String email = tmp[6];
            String address = tmp[7];
            String degree = tmp[8];
            String position = tmp[9];
            double salary = Double.parseDouble(tmp[10]);
            Employee employee = new Employee(id, code, fullName, birthday, Gender.valueOf(gender), phone,
                    email, address, Degree.valueOf(degree), Position.valueOf(position), salary);
            employees.add(employee);
        }
    }
}
