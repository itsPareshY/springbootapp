package org.example.SpringBootApp.controller.dto;


import lombok.*;
import org.example.SpringBootApp.domain.Department;
import org.example.SpringBootApp.domain.Phone;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO implements Serializable {

    private static final long serialVersionUID = 102L;

    private String fname;

    private String lname;

    private LocalDate dob;

    private LocalDate doj;

    private String address;

    private Department department;

    private BigDecimal salary;

    private List<Phone> phones;
}
