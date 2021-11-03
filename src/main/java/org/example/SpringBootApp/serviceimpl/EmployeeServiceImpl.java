package org.example.SpringBootApp.serviceimpl;

import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.repository.EmployeeRepository;
import org.example.SpringBootApp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

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
        Employee persistedEmp = employeeRepository.save(employee);
        return persistedEmp;
    }

    @Override
    public boolean deleteEmployee(long id) {
        return false;
    }
}
