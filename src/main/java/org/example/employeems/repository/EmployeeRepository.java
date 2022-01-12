package org.example.employeems.repository;

import org.example.employeems.controller.dto.EmployeePhoneJoinResponse;
import org.example.employeems.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    @Query("SELECT e FROM Employee e join e.department d where d.name =:deptName")
    Page<Employee> findEmployees(@Param("deptName") String deptName , Pageable pageable     );

    @Query("SELECT new org.example.employeems.controller.dto.EmployeePhoneJoinResponse (e.fname , e.lname , p.number) FROM Employee e join e.phones p")
     List<EmployeePhoneJoinResponse> getEmployeePhoneJoin();
}

