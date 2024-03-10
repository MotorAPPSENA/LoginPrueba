package com.motor.app.login.service;

import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.motor.app.login.dto.RequestDto;
import com.motor.app.login.dto.ResponseDto;
import com.motor.app.login.model.Usuario;
import com.motor.app.login.repository.UsuarioRepository;
import com.motor.app.login.util.Validacion;
import lombok.RequiredArgsConstructor;

/*
 * Service, aqui se establece la lógica del negocio
 */
@Service
@RequiredArgsConstructor
public class RegistrarUsuarioService {

  private final UsuarioRepository usuarioRepository;

  /*
   * Este metodo permite validar el usuario y mandar la inserción a la base de datos.
   */
  public ResponseDto registrarUsuario(RequestDto requestDto) {

    Validacion.validateRequest(requestDto);

    var usuarioEncontrado = usuarioRepository.findByUsername(requestDto.getUsername());

    if (Objects.nonNull(usuarioEncontrado)) {
      return new ResponseDto(HttpStatus.BAD_REQUEST.name(),
          "Este usuario ya existe, intente nuevamente");
    }
    var pass = Validacion.cifrar(requestDto.getPassword());

    var usuario = new Usuario(requestDto.getUsername(), pass);

    usuarioRepository.save(usuario);

    return new ResponseDto(HttpStatus.CREATED.name(), "Usuario registrado satisfactoriamente");
  }
}
