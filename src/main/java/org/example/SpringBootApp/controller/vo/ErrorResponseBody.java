package org.example.SpringBootApp.controller.vo;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ErrorResponseBody {

    private int errorCode;
    private String errorMessage;

    public ErrorResponseBody(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
