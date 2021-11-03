package org.example.SpringBootApp.mappers;

import org.example.SpringBootApp.controller.vo.EmployeeVO;
import org.example.SpringBootApp.domain.Employee;

public class EmpVoToEmployeeMapper {

    public static Employee map (EmployeeVO employeeVO){
        Employee employee = new Employee();
        employee.setAddress(employeeVO.getAddress());
        employee.setDepartment(employeeVO.getDepartment());
        employee.setDob(employeeVO.getDob());
        employee.setDoj(employeeVO.getDoj());
        employee.setFname(employeeVO.getFname());
        employee.setLname(employeeVO.getLname());
        employee.setPhones(employeeVO.getPhones());
        employee.setSalary(employeeVO.getSalary());
        return employee;
    }
}
