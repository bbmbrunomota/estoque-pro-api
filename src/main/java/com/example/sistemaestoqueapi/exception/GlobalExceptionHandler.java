package com.example.sistemaestoqueapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> lidarComRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
        Map<String, Object> corpo = new HashMap<>();
        corpo.put("mensagem", ex.getMessage());
        corpo.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(corpo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> lidarComErroGenerico(Exception ex) {
        Map<String, Object> corpo = new HashMap<>();
        corpo.put("mensagem", "Ocorreu um erro interno no servidor.");
        corpo.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(corpo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}