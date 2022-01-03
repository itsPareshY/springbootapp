package org.example.SpringBootApp.controller.rest;

import org.example.SpringBootApp.controller.dto.EmployeeVO;
import org.example.SpringBootApp.controller.dto.ErrorResponseBody;
import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.exception.InputParamInvalidException;
import org.example.SpringBootApp.exception.RecordNotFoundException;
import org.example.SpringBootApp.mappers.EmpVoToEmployeeMapper;
import org.example.SpringBootApp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import static org.example.SpringBootApp.controller.util.EmployeeConstants.*;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {


    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(final IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(value = "departmentName", required = false) String deptName ,
                                                         @RequestParam(value = "limit", required = false , defaultValue = "10") int limit ,
                                                         @RequestParam(value = "page" , required = false , defaultValue = "0") int page ) {
        List<Employee> employees = employeeService.getEmployees(deptName , limit , page );
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{empId}")
    public ResponseEntity getEmployee(@PathVariable("empId") long id) throws RecordNotFoundException, InputParamInvalidException {
        long optId = OptionalLong.of(id).orElse(INVALID_EMP_ID);

        if (INVALID_EMP_ID != optId && optId > 0) {
            Optional<Employee> result = employeeService.getEmployee(id);
            return  ResponseEntity.ok(result.orElseThrow(() ->  new RecordNotFoundException(INVALID_EMP_ID_ERROR , INVALID_EMPLOYEE_ID + id ))) ;
        } else {
            throw new InputParamInvalidException(INVALID_EMP_ID_ERROR,INVALID_EMPLOYEE_ID_ERR_MSG);
        }
    }

    @PostMapping
    public ResponseEntity addEmployee(@Valid @RequestBody EmployeeVO employeeVO) {
            Employee emp = EmpVoToEmployeeMapper.map(employeeVO);
            return ResponseEntity.ok(employeeService.addEmployee(emp));
    }

    @GetMapping("/phones")
    public ResponseEntity getEmployeePhones() {
            return ResponseEntity.ok(employeeService.getAllEmployeePhones());
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity deleteEmpById(@PathVariable("empId") long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
