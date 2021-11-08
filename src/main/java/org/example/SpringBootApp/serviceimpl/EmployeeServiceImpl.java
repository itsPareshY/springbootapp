package org.example.SpringBootApp.serviceimpl;

import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.repository.EmployeeRepository;
import org.example.SpringBootApp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//        Page<Employee> resultPage = employeeRepository.findAll(
//                PageRequest.of(1,10, Sort.by(Sort.Direction.DESC, "fname")));
        List<Employee> result = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "fname"));
//        List<Employee> result = resultPage.stream().toList();
        return result;
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
