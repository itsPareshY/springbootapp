package org.example.SpringBootApp.service;

import org.example.SpringBootApp.controller.dto.EmployeePhoneJoinResponse;
import org.example.SpringBootApp.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(long id);

    Employee addEmployee (Employee employee);

    boolean deleteEmployee (long id);

    List<EmployeePhoneJoinResponse> getAllEmployeePhones();

}
