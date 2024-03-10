package com.motor.app.login.service;

import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.motor.app.login.dto.RequestDto;
import com.motor.app.login.dto.ResponseDto;
import com.motor.app.login.repository.UsuarioRepository;
import com.motor.app.login.util.Validacion;
import lombok.RequiredArgsConstructor;

/*
 * 
 */
@Service
@RequiredArgsConstructor
public class LoginService {

  private final UsuarioRepository usuarioRepository;

  /*
   * Metodo para iniciar sesión
   */
  public ResponseDto login(String username, String password) {

    Validacion.validateRequest(new RequestDto(username, password));

    var pass = Validacion.cifrar(password);

    var usuario = usuarioRepository.findByUsername(username);

    if (Objects.isNull(usuario)) {
      return new ResponseDto(HttpStatus.BAD_REQUEST.name(),
          "Este usuario no existe, registrese.");
    }
    if (!pass.equals(usuario.getPassword())) {
      return new ResponseDto(HttpStatus.BAD_REQUEST.name(), "La contraseña esta errada.");
    }
    return new ResponseDto(HttpStatus.OK.name(), "Inicio de sesión satisfactoriamente");
  }
}
