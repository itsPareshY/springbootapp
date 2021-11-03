package org.example.SpringBootApp.domain;


import lombok.*;

import javax.persistence.*;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department;

    private BigDecimal salary;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.PERSIST)
    private List<Phone> phones;
}
