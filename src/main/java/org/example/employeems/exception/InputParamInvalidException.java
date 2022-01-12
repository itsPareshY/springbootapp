package org.example.employeems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputParamInvalidException extends CustomEmployeeException {

    public InputParamInvalidException(int errorCode , String message){
        super(errorCode , message);
    }
}
