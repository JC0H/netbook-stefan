package pl.laptopy.polizingowe.test;

import java.util.List;

public interface ApplicationService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();
}