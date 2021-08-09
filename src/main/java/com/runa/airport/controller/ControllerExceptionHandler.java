package com.runa.airport.controller;

import com.runa.airport.dto.ExceptionDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import javax.persistence.EntityNotFoundException;

@Log4j2
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ExceptionDto> handleRuntimeException(Exception exc) {
        log.error(exc.getMessage(), exc);
        return new ResponseEntity<>(new ExceptionDto(exc), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler({EntityNotFoundException.class})
//    public ResponseEntity<ExceptionDto> handleEntityNotFoundException(Exception exc) {
//        log.error(exc.getMessage(), exc);
//        return new ResponseEntity<>(new ExceptionDto(exc), HttpStatus.NOT_FOUND);
//    }
}