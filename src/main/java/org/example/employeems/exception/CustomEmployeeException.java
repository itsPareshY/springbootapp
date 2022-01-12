package org.example.employeems.exception;

import lombok.Getter;

@Getter
public class CustomEmployeeException extends Exception {
    private int errorCode;
    private String errorMessage;

    public CustomEmployeeException(int errorCode , String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}
