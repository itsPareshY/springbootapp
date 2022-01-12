package org.example.employeems.serviceimpl;

import org.example.employeems.controller.dto.EmployeePhoneJoinResponse;
import org.example.employeems.controller.common.EmployeeConstants;
import org.example.employeems.domain.Employee;
import org.example.employeems.repository.EmployeeRepository;
import org.example.employeems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees(String deptName, int limit, int page) {
        Page<Employee> resultPage = null;
        if(Optional.ofNullable(deptName).isPresent()){
            resultPage = employeeRepository.findEmployees(deptName,
                    PageRequest.of(page,limit, Sort.by(Sort.Direction.ASC, EmployeeConstants.EMP_FIRST_NAME)));
        }
        else {
            resultPage = employeeRepository.findAll(
                    PageRequest.of(page,limit, Sort.by(Sort.Direction.ASC, EmployeeConstants.EMP_FIRST_NAME)));
        }
        resultPage = Optional.ofNullable(resultPage).orElse(new PageImpl<Employee>(new ArrayList<Employee>()));
        List<Employee> result = resultPage.stream().toList();
        return result;
    }

    @Override
    public Optional<Employee> getEmployee(long id)  {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee persistedEmp = employeeRepository.save(employee);
        return persistedEmp;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeePhoneJoinResponse> getAllEmployeePhones() {
        return  employeeRepository.getEmployeePhoneJoin();
    }


}
