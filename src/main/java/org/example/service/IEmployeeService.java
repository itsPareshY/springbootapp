package org.example.service;

import org.example.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(long id);

    Employee addEmployee (Employee employee);

    boolean deleteEmployee (long id);
}
