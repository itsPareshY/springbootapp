package org.example.employeems.mappers;

import org.example.employeems.controller.dto.EmployeeVO;
import org.example.employeems.domain.Department;

public class EmpVoToDepartmentMapper {
    public static Department map(EmployeeVO employeeVO){
        Department department = new Department();
        department.setName(employeeVO.getDepartment().getName());
        return department;
    }
}
