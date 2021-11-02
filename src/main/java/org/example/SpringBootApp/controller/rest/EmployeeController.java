package org.example.SpringBootApp.controller.rest;

import org.example.SpringBootApp.controller.vo.ErrorResponseBody;
import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalLong;

import static org.example.SpringBootApp.controller.util.EmployeeConstants.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(final IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(value = "departmentName", required = false) String deptName ,
                                                         @RequestParam(value = "limit", required = false , defaultValue = "10") int limit ,
                                                         @RequestParam(value = "page" , required = false , defaultValue = "0") int page ,
                                                         @RequestParam(value = "offset", required = false , defaultValue = "0") int offset) {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/{empId}")
    public ResponseEntity getEmployee(@PathVariable("empId") long id) {
        long optId = OptionalLong.of(id).orElse(INVALID_EMP_ID);

        if (INVALID_EMP_ID != optId || optId > 0) {
            return ResponseEntity.ok(employeeService.getEmployee(id));
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponseBody(INVALID_EMP_ID_ERROR,
                    INVALID_EMPLOYEE_ID_ERR_MSG));
        }
    }
}
