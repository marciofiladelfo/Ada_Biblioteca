package com.ada.emprestimo.exception.handle;

import com.ada.emprestimo.exception.NotFoundDetails;
import com.ada.emprestimo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> hendleNotFoundException(NotFoundException e){
        NotFoundDetails resource = new NotFoundDetails();
        resource.setTimestamp(new Date().getTime());
        resource.setTitle("Recurso não encontrado");
        resource.setStatus(HttpStatus.NOT_FOUND.value());
        resource.setDetail(e.getMessage());

        return new ResponseEntity<>(resource, HttpStatus.NOT_FOUND);
    }
}
