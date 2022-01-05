package org.example.SpringBootApp.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 101L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String fname;

    private String lname;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "date_of_joining")
    private LocalDate doj;

    private String address;

    @JsonIgnoreProperties("employees")
    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    private Department department;

    private BigDecimal salary;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId")
    private Set<Phone> phones;
}
