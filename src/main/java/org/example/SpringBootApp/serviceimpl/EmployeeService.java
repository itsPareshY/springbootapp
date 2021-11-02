package org.example.SpringBootApp.serviceimpl;

import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public Employee getEmployee(long id) {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        return false;
    }
}
