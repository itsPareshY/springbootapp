package org.example.SpringBootApp.serviceimpl;

import org.example.SpringBootApp.domain.Employee;
import org.example.SpringBootApp.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

public class EmployeeServiceImplTest {

    public static final String DEPT_NAME_OPS = "ops";
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this).close();
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void testGetEmployeesWithoutDeptFilterAndNoRecordsInDB(){
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.ASC, "fname"));
        given(employeeRepository.findAll(pageRequest))
                .willReturn(null);

        List<Employee> result = employeeService.getEmployees(null,3,0);

        assertThat(result).hasSize(0);
    }

    @Test
    public void testGetEmployeesWithoutDeptFilter(){
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.ASC, "fname"));
        List<Employee> empList = new ArrayList<Employee>();
        Employee employee = new Employee();
        empList.add(employee);
        given(employeeRepository.findAll(pageRequest))
                .willReturn(new PageImpl<Employee>(empList));

        List<Employee> result = employeeService.getEmployees(null,3,0);

        assertThat(result).hasSize(1);
    }

    @Test
    public void testGetEmployeesWithDeptFilterAndNoRecordsInDB(){
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.ASC, "fname"));
        given(employeeRepository.findEmployees(DEPT_NAME_OPS,pageRequest))
                .willReturn(null);

        List<Employee> result = employeeService.getEmployees(DEPT_NAME_OPS,3,0);

        assertThat(result).hasSize(0);
    }

    @Test
    public void testGetEmployeesWithDeptFilter(){
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.ASC, "fname"));
        List<Employee> empList = new ArrayList<Employee>();
        Employee employee = new Employee();
        empList.add(employee);
        given(employeeRepository.findEmployees(DEPT_NAME_OPS, pageRequest))
                .willReturn(new PageImpl<Employee>(empList));

        List<Employee> result = employeeService.getEmployees(DEPT_NAME_OPS,3,0);

        assertThat(result).hasSize(1);
    }
}
