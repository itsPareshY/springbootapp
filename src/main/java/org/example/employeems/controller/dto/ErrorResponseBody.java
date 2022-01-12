package org.example.employeems.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ErrorResponseBody {

    private int errorCode;
    private String errorMessage;
    List<String> details;

}
