package org.example.employeems.controller.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.employeems.domain.Department;
import org.example.employeems.domain.Phone;

import javax.validation.constraints.*;
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

    @NotBlank (message = "fname cannot be blank")
    private String fname;

    @NotEmpty(message = "lname should not be empty")
    private String lname;

    @Past(message = "DoB should be past date")
    private LocalDate dob;

    @PastOrPresent(message = "Doj should be past/present date")
    private LocalDate doj;

    private String address;

    @NotNull (message = "Department is required")
    private Department department;

    @DecimalMin(value = "0.0", inclusive = false, message = "Salary min value is 0")
    @Digits(integer=9, fraction=2, message = "Salary numeric value <Max 9 digits>.<Max 2 digits> expected")
    private BigDecimal salary;

    @NotEmpty (message = "Phone list must not be empty")
    private List<Phone> phones;
}
