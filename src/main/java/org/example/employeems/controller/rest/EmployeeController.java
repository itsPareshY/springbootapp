package org.example.employeems.controller.rest;

import org.example.employeems.controller.dto.EmployeeVO;
import org.example.employeems.domain.Employee;
import org.example.employeems.exception.InputParamInvalidException;
import org.example.employeems.exception.RecordNotFoundException;
import org.example.employeems.mappers.EmpVoToEmployeeMapper;
import org.example.employeems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import static org.example.employeems.controller.common.EmployeeConstants.*;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(final IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(value = DEPARTMENT_NAME, required = false) String deptName ,
                                                         @RequestParam(value = LIMIT, required = false , defaultValue = DEFAULT_LIMIT) int limit ,
                                                         @RequestParam(value = PAGE, required = false , defaultValue = DEFAULT_PAGE) int page ) {
        List<Employee> employees = employeeService.getEmployees(deptName , limit , page );
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{empId}")
    public ResponseEntity getEmployee(@PathVariable(EMP_ID) long id) throws RecordNotFoundException, InputParamInvalidException {
        long optEmpId = OptionalLong.of(id).orElse(INVALID_EMP_ID);

        if (INVALID_EMP_ID != optEmpId && optEmpId > 0) {
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
    public ResponseEntity deleteEmpById(@PathVariable(EMP_ID) long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
