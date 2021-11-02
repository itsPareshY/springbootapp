package org.example.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    private static final long serialVersionUID = 102L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
