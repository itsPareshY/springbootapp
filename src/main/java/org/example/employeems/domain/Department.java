package org.example.employeems.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties ( ignoreUnknown = true )
public class Department {

    private static final long serialVersionUID = 102L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private String name;

    @JsonIgnoreProperties("department")
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Employee> employees;

}
