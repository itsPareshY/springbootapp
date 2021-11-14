package org.example.SpringBootApp.repository;

import org.example.SpringBootApp.controller.dto.EmployeePhoneJoinResponse;
import org.example.SpringBootApp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

//    public List<Employee> findEmployees();

    @Query("SELECT new org.example.SpringBootApp.controller.dto.EmployeePhoneJoinResponse (e.fname , e.fname , p.number) FROM Employee e join e.phones p")
     List<EmployeePhoneJoinResponse> getEmployeePhoneJoin();
}
