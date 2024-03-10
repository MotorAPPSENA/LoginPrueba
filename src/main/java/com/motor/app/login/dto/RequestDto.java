package com.motor.app.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

  private String username;

  private String password;
}
