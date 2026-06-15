package com.yurigb.luabank.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yurigb.luabank.exception.badrequest.CpfInvalidoException;
import com.yurigb.luabank.exception.badrequest.SaldoInsuficienteException;
import com.yurigb.luabank.exception.badrequest.TelefoneInvalidoException;
import com.yurigb.luabank.exception.badrequest.TransferenciaInvalidaException;
import com.yurigb.luabank.exception.conflict.CpfJaCadastradoException;
import com.yurigb.luabank.exception.conflict.EmailJaCadastradoException;
import com.yurigb.luabank.exception.notfound.ContaNaoEncontradaException;
import com.yurigb.luabank.exception.notfound.unauthorized.CredenciaisInvalidasException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        private ResponseEntity<ErrorResponse> erro(
                        HttpStatus status,
                        Exception ex) {

                return ResponseEntity
                                .status(status)
                                .body(new ErrorResponse(ex.getMessage()));
        }

        @ExceptionHandler({
                        CpfJaCadastradoException.class,
                        EmailJaCadastradoException.class
        })
        public ResponseEntity<ErrorResponse> tratarConflitos(
                        RuntimeException ex) {

                return erro(HttpStatus.CONFLICT, ex);
        }

        @ExceptionHandler(ContaNaoEncontradaException.class)
        public ResponseEntity<ErrorResponse> tratarContaNaoEncontrada(
                        ContaNaoEncontradaException ex) {

                return erro(HttpStatus.NOT_FOUND, ex);
        }

        @ExceptionHandler(CredenciaisInvalidasException.class)
        public ResponseEntity<ErrorResponse> tratarCredenciaisInvalidas(
                        CredenciaisInvalidasException ex) {

                return erro(HttpStatus.UNAUTHORIZED, ex);
        }

        @ExceptionHandler({
                        CpfInvalidoException.class,
                        TelefoneInvalidoException.class,
                        SaldoInsuficienteException.class,
                        TransferenciaInvalidaException.class
        })
        public ResponseEntity<ErrorResponse> tratarBadRequest(
                        RuntimeException ex) {

                return erro(HttpStatus.BAD_REQUEST, ex);
        }

}
