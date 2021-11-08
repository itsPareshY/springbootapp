package org.example.SpringBootApp.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    private String number;

//    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//    @JoinColumn(name = "employeeId")
//    private Employee employee;
}
