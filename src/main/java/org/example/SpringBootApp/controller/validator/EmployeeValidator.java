package org.example.SpringBootApp.controller.validator;

import org.example.SpringBootApp.controller.dto.EmployeeVO;

import java.util.Optional;

public class EmployeeValidator {

    public static boolean valid(EmployeeVO employeeVO){
        if(Optional.of(employeeVO).isPresent()){
            return  true;
        }
        else{
            return false;
        }
    }
}
