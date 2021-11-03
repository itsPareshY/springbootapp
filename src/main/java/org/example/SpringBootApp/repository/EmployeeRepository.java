package org.example.SpringBootApp.repository;

import org.example.SpringBootApp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {

}
