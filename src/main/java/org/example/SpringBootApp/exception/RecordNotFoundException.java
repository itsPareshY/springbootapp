package org.example.SpringBootApp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends CustomEmployeeException{

    public RecordNotFoundException(int errorCode , String message ){
        super(errorCode, message);
    }
}
