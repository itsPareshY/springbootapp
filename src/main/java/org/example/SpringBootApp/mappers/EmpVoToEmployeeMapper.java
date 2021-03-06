package org.example.SpringBootApp.mappers;

import org.example.SpringBootApp.controller.dto.EmployeeVO;
import org.example.SpringBootApp.domain.Employee;

public class EmpVoToEmployeeMapper {

    public static Employee map (EmployeeVO employeeVO){
        Employee employee = new Employee();
        employee.setAddress(employeeVO.getAddress());
        employee.setDob(employeeVO.getDob());
        employee.setDoj(employeeVO.getDoj());
        employee.setFname(employeeVO.getFname());
        employee.setLname(employeeVO.getLname());
        employee.setSalary(employeeVO.getSalary());
        employee.setPhones(EmpVoToPhoneMapper.map(employeeVO));
        employee.setDepartment(EmpVoToDepartmentMapper.map(employeeVO));
        return employee;
    }
}
