package br.com.zup.refund.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.zup.refund.model.exception.InvalidTokenException;

@Component
abstract class MainController {
    protected <T> ResponseEntity<T> responseCreated(T object) {
        return new ResponseEntity<T>(object, HttpStatus.CREATED);
    }
    
    protected <T> ResponseEntity<T> responseOk(T object) {
        return new ResponseEntity<T>(object, HttpStatus.OK);
    }
    
    protected <T> ResponseEntity<T> responseOk() {
        return new ResponseEntity<T>(HttpStatus.OK);
    }
    
    protected <T> ResponseEntity<T> responseBadRequest(T object) {
        return new ResponseEntity<T>(object, HttpStatus.BAD_REQUEST);
    }
    
    protected <T> ResponseEntity<T> responseNotFound(T object) {
        return new ResponseEntity<T>(object, HttpStatus.NOT_FOUND);
    }
    
    protected <T> ResponseEntity<T> response(T object, HttpStatus status) {
        return new ResponseEntity<T>(object, status);
    }
    
    @ExceptionHandler({ InvalidTokenException.class })
    public ResponseEntity<Object> invalidTokenExceptionHandler() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
