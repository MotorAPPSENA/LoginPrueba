package com.motor.app.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 *
 * Este es un objeto para transferir información hacia el frontend
 */
@Data
@AllArgsConstructor
public class ResponseDto {

  private String status;

  private String message;
}
