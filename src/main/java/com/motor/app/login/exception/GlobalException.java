package com.motor.app.login.exception;

import lombok.Getter;

/*
 * Esta clase esta destinada a tener la estructura del objeto del error
 */
@Getter
public class GlobalException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final int code;

  private final String message;

  public GlobalException(int code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }
}
