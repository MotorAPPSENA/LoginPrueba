package com.motor.app.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.motor.app.login.dto.RequestDto;
import com.motor.app.login.dto.ResponseDto;
import com.motor.app.login.service.LoginService;
import com.motor.app.login.service.RegistrarUsuarioService;
import lombok.RequiredArgsConstructor;

/*
 * Esta es la capa de presentación, es aquella que permite recibir las peticiones
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
class UsuarioController {

  private final RegistrarUsuarioService registro;

  private final LoginService loginService;

  /*
   * Este metodo esta disponible para recibir la peticion de registro de usuarios, en esta capa no
   * debería existir logica de negocio
   */
  @PostMapping(path = "registrar", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ResponseDto> crearUsuario(@RequestBody RequestDto requestDto) {
    return new ResponseEntity<>(registro.registrarUsuario(requestDto), HttpStatus.CREATED);
  }

  /*
   * Este metodo me permite recibir la peticion para el login
   */
  @GetMapping(path = "login", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ResponseDto> login(@RequestParam(name = "username") String username,
      @RequestParam(name = "password") String password) {
    return new ResponseEntity<>(loginService.login(username, password), HttpStatus.OK);
  }
}
