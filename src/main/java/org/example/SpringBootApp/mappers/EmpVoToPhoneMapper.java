package org.example.SpringBootApp.mappers;

import org.example.SpringBootApp.controller.vo.EmployeeVO;
import org.example.SpringBootApp.domain.Department;
import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.domain.Phone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmpVoToPhoneMapper {
    public static Set<Phone> map (EmployeeVO employeeVO){
        Set<Phone> phones = new HashSet<>();
        employeeVO.getPhones().forEach(item -> {
            Phone phone = new Phone();
            phone.setNumber(item.getNumber());
            phones.add(phone);

        });

        return phones;
    }
}
