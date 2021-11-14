package org.example.SpringBootApp.mappers;

import org.example.SpringBootApp.controller.dto.EmployeeVO;
import org.example.SpringBootApp.domain.Department;

public class EmpVoToDepartmentMapper {
    public static Department map(EmployeeVO employeeVO){
        Department department = new Department();
        department.setName(employeeVO.getDepartment().getName());
        return department;
    }
}
