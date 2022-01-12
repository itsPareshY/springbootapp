package org.example.employeems.service;

import org.example.employeems.controller.dto.EmployeePhoneJoinResponse;
import org.example.employeems.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> getEmployees(String deptName, int limit, int page);

    Optional<Employee> getEmployee(long id);

    Employee addEmployee (Employee employee);

    void deleteEmployee (long id);

    List<EmployeePhoneJoinResponse> getAllEmployeePhones();

}
