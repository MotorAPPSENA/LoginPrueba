package com.motor.app.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.motor.app.login.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;

/*
 * Esta clase esta construida para capturar la excepcion y lanzar el mensaje de error
 */
@Slf4j
@RestControllerAdvice
public class ManejoErrores {

  @ExceptionHandler(value = {GlobalException.class})
  public ResponseEntity<ResponseDto> handlerException(GlobalException ex) {

    log.error(ex.getMessage(), ex);
    var err = String.format("El '%s' no debe ser nulo", ex.getMessage());
    return new ResponseEntity<>(new ResponseDto(HttpStatus.BAD_REQUEST.name(), err),
        HttpStatus.BAD_REQUEST);
  }
}
