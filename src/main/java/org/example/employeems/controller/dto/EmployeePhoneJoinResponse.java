package org.example.employeems.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // Added to ignore the property not initialized by constructor EmployeePhoneJoinResponse(String fname, String lname, String phoneNumber)
public class EmployeePhoneJoinResponse {

    private String fname;

    private String lname;

    private String phoneNumber;

    //This constructor is used to create object in EmployeeRepository
    // SELECT new org.example.SpringBootApp.controller.dto.EmployeePhoneJoinResponse (e.fname , e.fname , p.number)
    public EmployeePhoneJoinResponse(String fname, String lname, String phoneNumber) {
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
    }

    private String address;
}
