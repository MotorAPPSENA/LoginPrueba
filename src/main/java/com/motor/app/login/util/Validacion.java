package com.motor.app.login.util;

import java.util.Base64;
import java.util.Objects;
import com.motor.app.login.dto.RequestDto;
import com.motor.app.login.exception.GlobalException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/*
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validacion {

  /*
   * Metodo que me permite validar los campos del objeto a registrar
   */
  public static void validateRequest(RequestDto requestDto) {

    if (Objects.isNull(requestDto)) {
      throw new GlobalException(400, "Objeto");
    }

    if (Objects.isNull(requestDto.getUsername()) || requestDto.getUsername().isEmpty()) {
      throw new GlobalException(400, "Username");
    }

    if (Objects.isNull(requestDto.getPassword()) || requestDto.getPassword().isEmpty()) {
      throw new GlobalException(400, "Password");
    }
  }

  public static String cifrar(String password) {
    return Base64.getEncoder().encodeToString(password.getBytes());
  }
}
