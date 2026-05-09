package dev.java10x.cadastroDeNinjas.Ninjas.exception;

import dev.java10x.cadastroDeNinjas.Ninjas.dto.NinjaErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class NinjaExcepetionHandler {

    @ExceptionHandler(NinjaNotFoundException.class)
    public ResponseEntity<NinjaErrorResponse> handleNinjaNotFoundException(NinjaNotFoundException exception)
    {

        NinjaErrorResponse errorResponse = new NinjaErrorResponse(
                exception.getMessage(),
                Instant.now()
        );


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }


}
