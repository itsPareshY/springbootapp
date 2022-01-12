package org.example.employeems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CustomForbiddenException extends CustomEmployeeException {

    public CustomForbiddenException(int errorCode , String message){
        super(errorCode , message);
    }
}
