package br.ufms.cpcx.api.demo.controllers;

import br.ufms.cpcx.api.demo.Dtos.StandardErrorMessageDto;
import br.ufms.cpcx.api.demo.Exceptions.AlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class PetResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public final ResponseEntity<StandardErrorMessageDto> handleConflictException(Exception e) {
        var errorMessage = new StandardErrorMessageDto(new Date(), HttpStatus.CONFLICT.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}