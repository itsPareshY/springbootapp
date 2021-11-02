package org.example.SpringBootApp.controller.rest;

import org.example.SpringBootApp.controller.rest.vo.ErrorResponseBody;
import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalLong;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    public static final long INVALID_EMP_ID = 0l;
    private static final int INVALID_EMP_ID_ERROR = 100;
    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(final IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam("departmentName") String deptName ,
                                                         @RequestParam("limit") int limit ,
                                                         @RequestParam("page") int page ,
                                                         @RequestParam("offset") int offset) {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/{empId}")
    public ResponseEntity getEmployee(@PathVariable("empId") long id) {
        long optId = OptionalLong.of(id).orElse(INVALID_EMP_ID);

        if (INVALID_EMP_ID != optId) {
            return ResponseEntity.ok(employeeService.getEmployee(id));
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponseBody(INVALID_EMP_ID_ERROR,
                    "Invalid Employee Id"));
        }
    }
}
