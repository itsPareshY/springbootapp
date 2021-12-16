package org.example.SpringBootApp.exception;

import java.util.ArrayList;
import java.util.List;

import org.example.SpringBootApp.controller.dto.ErrorResponseBody;
import static org.example.SpringBootApp.controller.util.EmployeeConstants.*;

import org.example.SpringBootApp.controller.util.EmployeeConstants;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{

//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponseBody error = new ErrorResponseBody(UNHANDLED_ERROR_CODE, SERVER_ERROR,  details);
//        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(RecordNotFoundException.class)
//    public final ResponseEntity<Object> handleRecordNotFoundException( RecordNotFoundException ex, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponseBody error = new ErrorResponseBody( ex.getErrorCode() , ex.getErrorMessage() ,  details);
//        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(CustomForbiddenException.class)
    public final ResponseEntity<Object> handleForbiddenException(CustomForbiddenException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseBody error = new ErrorResponseBody( ex.getErrorCode() , ex.getErrorMessage() ,  details);
        return new ResponseEntity(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InputParamInvalidException.class)
    public final ResponseEntity<Object> handleInputPayloadInvalidException(InputParamInvalidException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseBody error = new ErrorResponseBody(ex.getErrorCode() , ex.getErrorMessage(),  details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponseBody error = new ErrorResponseBody(VALIDATION_FAILED_ERR_CODE ,VALIDATION_FAILED_ERROR_MSG, details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(REQUIRED_TYPE_IS + ex.getRequiredType());
        ErrorResponseBody error = new ErrorResponseBody(VALIDATION_FAILED_ERR_CODE ,VALIDATION_FAILED_ERROR_MSG, details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}