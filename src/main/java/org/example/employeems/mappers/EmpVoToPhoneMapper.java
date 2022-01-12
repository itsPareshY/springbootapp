package org.example.employeems.mappers;

import org.example.employeems.controller.dto.EmployeeVO;
import org.example.employeems.domain.Phone;

import java.util.HashSet;
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
