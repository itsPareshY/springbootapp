package org.example.SpringBootApp.controller.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.SpringBootApp.domain.Department;
import org.example.SpringBootApp.domain.Phone;

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

    @PastOrPresent
    private LocalDate doj;

    private String address;

    @NotNull (message = "Department is required")
    private Department department;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal salary;

    @NotEmpty (message = "Phone list must not be empty")
    private List<Phone> phones;
}
